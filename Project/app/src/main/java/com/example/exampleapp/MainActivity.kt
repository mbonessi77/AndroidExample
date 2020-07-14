package com.example.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_container, fragment).commit()
    }
}
