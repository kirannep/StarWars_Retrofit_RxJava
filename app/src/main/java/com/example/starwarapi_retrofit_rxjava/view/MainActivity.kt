package com.example.starwarapi_retrofit_rxjava.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.starwarapi_retrofit_rxjava.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentmanager:FragmentManager = supportFragmentManager
        var fragmentTransaction:FragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,StarWarFragment())
            .commit()
    }
}
