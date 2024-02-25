package com.example.projetnav.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.projetnav.R
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.episodes.ListEpisodeAdapter
import com.example.projetnav.ui.series.personnages.ListPersonnageAdapter
import com.example.projetnav.ui.series.personnages.Personnage

class FragmentSerie : Fragment() {
    private lateinit var serieViewModel: SerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_serie, container, false)

        serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)

        val serie = Serie(
            title = "Titre de la série",
            imageResId = R.drawable.astronaut,
            studio = "Nom du studio",
            numberOfEpisodes = 10,
            year = 2022,
            story = "Histoire",
            personnages = listOf(
                Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut)
                // ... Ajoutez d'autres personnages selon vos besoins
            ),
            episodes = listOf(
                Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022")
                // ... Ajoutez d'autres épisodes selon vos besoins
            )
        )

        serieViewModel.serie = serie

        rootView.findViewById<TextView>(R.id.titre_serie).text = serie.title
        rootView.findViewById<ImageView>(R.id.image_serie).setImageResource(serie.imageResId)
        rootView.findViewById<TextView>(R.id.studio).text = serie.studio
        rootView.findViewById<TextView>(R.id.nb_episodes).text = "${serie.numberOfEpisodes} épisodes"
        rootView.findViewById<TextView>(R.id.annee).text = serie.year.toString()
        rootView.findViewById<TextView>(R.id.text_histoire).text = serie.story

        val recycle_perso = rootView.findViewById<View>(R.id.recycler_personnages) as RecyclerView
        recycle_perso.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recycle_perso.adapter = ListPersonnageAdapter(serie.personnages)

        val recycle_episode = rootView.findViewById<View>(R.id.recycler_episodes) as RecyclerView
        recycle_episode.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recycle_episode.adapter = ListEpisodeAdapter(serie.episodes)

        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)

        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE

        val buttonHistoire = rootView.findViewById<Button>(R.id.button_histoire)
        val buttonPersonnages = rootView.findViewById<Button>(R.id.button_personnages)
        val buttonEpisodes = rootView.findViewById<Button>(R.id.button_episodes)

        // Ajout des écouteurs de clic aux boutons
        buttonHistoire.setOnClickListener {
            showHistoire(rootView)
        }

        buttonPersonnages.setOnClickListener {
            showPersonnages(rootView)
        }

        buttonEpisodes.setOnClickListener {
            showEpisodes(rootView)
        }

        return rootView
    }

    private fun showHistoire(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)

        // Afficher la vue d'histoire et masquer les RecyclerViews
        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showPersonnages(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)

        // Afficher la RecyclerView des personnages et masquer les autres vues
        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.VISIBLE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showEpisodes(rootView: View) {
        val textViewHistoire = rootView.findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = rootView.findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = rootView.findViewById<RecyclerView>(R.id.recycler_episodes)

        // Afficher la RecyclerView des épisodes et masquer les autres vues
        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.VISIBLE
    }
}