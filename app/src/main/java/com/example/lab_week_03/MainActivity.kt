package com.example.lab_week_03

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), CoffeeListFragment.OnCoffeeSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate MainActivity")
    }

    override fun onCoffeeSelected(coffee: String) {
        Log.d(TAG, "Coffee selected: $coffee")
        val detailFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_coffee_detail) as CoffeeDetailFragment
        detailFragment.updateCoffeeDetail(coffee)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
