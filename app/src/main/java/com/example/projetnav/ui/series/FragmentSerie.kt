package com.example.projetnav.ui.series

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.episodes.ListEpisodeAdapter
import com.example.projetnav.ui.series.personnages.ListPersonnageAdapter
import com.example.projetnav.ui.series.personnages.Personnage

class FragmentSerie : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_serie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val serie = FragmentSerieArgs.fromBundle(requireArguments()).serie
        /*val args: FragmentSerieArgs by navArgs()
        val serie: Serie = args.serie*/
        view.findViewById<ImageView>(R.id.background).setImageResource(serie.imageResId)
        view.findViewById<TextView>(R.id.titre_serie).text = serie.title
        view.findViewById<ImageView>(R.id.image_serie).setImageResource(serie.imageResId)
        view.findViewById<TextView>(R.id.studio).text = serie.studio
        view.findViewById<TextView>(R.id.nb_episodes).text = "${serie.numberOfEpisodes} épisodes"
        view.findViewById<TextView>(R.id.annee).text = serie.year.toString()
        view.findViewById<TextView>(R.id.text_histoire).text = serie.story

        val recycle_perso = view.findViewById<View>(R.id.recycler_personnages) as RecyclerView
        recycle_perso.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recycle_perso.adapter = ListPersonnageAdapter(serie.personnages)

        val recycle_episode = view.findViewById<View>(R.id.recycler_episodes) as RecyclerView
        recycle_episode.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recycle_episode.adapter = ListEpisodeAdapter(serie.episodes)

        val textViewHistoire = view.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = view.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = view.findViewById<RecyclerView>(R.id.recycler_episodes)

        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE

        val buttonHistoire = view.findViewById<Button>(R.id.button_histoire)
        val buttonPersonnages = view.findViewById<Button>(R.id.button_personnages)
        val buttonEpisodes = view.findViewById<Button>(R.id.button_episodes)

        // Ajout des écouteurs de clic aux boutons
        buttonHistoire.setOnClickListener {
            showHistoire(view)
        }

        buttonPersonnages.setOnClickListener {
            showPersonnages(view)
        }

        buttonEpisodes.setOnClickListener {
            showEpisodes(view)
        }

        val backButton = view.findViewById<View>(R.id.back_button)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun showHistoire(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)


        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showPersonnages(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)


        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.VISIBLE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showEpisodes(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)


        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.VISIBLE
    }




}
