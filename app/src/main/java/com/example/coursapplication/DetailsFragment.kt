package com.example.coursapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_main,
            container,
            false
        )
    }

    fun onViewCreate(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.item_name).text = "Hello"
    }
}