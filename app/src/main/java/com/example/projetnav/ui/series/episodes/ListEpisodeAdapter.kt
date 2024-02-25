package com.example.projetnav.ui.series.episodes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R

class ListEpisodeAdapter(private val episodes: List<Episode>) :
    RecyclerView.Adapter<ListEpisodeAdapter.EpisodeViewHolder>() {

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.episode_title)
        val description: TextView = itemView.findViewById(R.id.episode_description)

        val releaseDate: TextView = itemView.findViewById(R.id.episode_release_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.title.text = episode.title
        holder.description.text = episode.description

        holder.releaseDate.text = episode.releaseDate
    }

    override fun getItemCount(): Int {
        return episodes.size
    }
}