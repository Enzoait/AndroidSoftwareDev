import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R
import com.example.projetnav.ui.series.ListSeriesViewModel
import com.example.projetnav.ui.series.SerieAdapter
import com.example.projetnav.ui.series.Serie

class ListSeriesFragment : Fragment() {
    private lateinit var listSeriesViewModel: ListSeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list_series, container, false)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_series)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize ViewModel
        listSeriesViewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)

        // Example data (replace with your real data)
        val series = listOf(
            Serie(
                title = "Titre de la série",
                imageResId = R.drawable.astronaut,
                studio = "Nom du studio",
                numberOfEpisodes = 10,
                year = 2022,
                story = "Histoire"
            ),
            // Add more series as needed
        )

        // Update ViewModel with data
        listSeriesViewModel.series = series

        // Set up RecyclerView with adapter
        recyclerView.adapter = SerieAdapter(listSeriesViewModel.series) { serie ->
            // Handle click on a series item
            navigateToSerieDetails(serie)
        }

        return root
    }

    private fun navigateToSerieDetails(serie: Serie) {
        // Use Navigation Component to navigate to SerieFragment
        val action = ListSeriesFragmentDirection.actionListSeriesToSerieDetails(serie)
        findNavController().navigate(action)
    }
}
