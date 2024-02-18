package com.example.coursapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container0, TitleFragment())
            .replace(R.id.container1, ListFragment())
            .commitAllowingStateLoss()
    }
}