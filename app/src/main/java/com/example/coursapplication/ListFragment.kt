package com.example.coursapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.list,
            container,
            false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = List(4) {
            generateFakeProduct()
        }

        view.findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter(data)
        }
    }

}

class ListAdapter(private val data: List<Product>) : RecyclerView.Adapter<ListItem>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        return ListItem(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        holder.bindItem(data[position])
    }

}

class ListItem(v: View) : RecyclerView.ViewHolder(v) {

    val name : TextView = v.findViewById(R.id.item_name)
    val publisher : TextView = v.findViewById(R.id.item_publisher)
    val episodes : TextView = v.findViewById(R.id.item_episodes)
    val date : TextView = v.findViewById(R.id.item_date)
    val image : ImageView = v.findViewById(R.id.item_image)

    fun bindItem(product: Product) {
        name.text = product.name
        publisher.text = product.publisher
        episodes.text = product.episodes
        date.text = product.date

        Glide.with(itemView).load(product.thumbnail).into(image)
    }

}