package com.example.lab_week_03

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CoffeeDetailFragment : Fragment() {

    private lateinit var titleTextView: TextView
    private lateinit var descTextView: TextView

    private val coffeeDetails = mapOf(
        "Affogato" to "A coffee-based dessert. It usually takes the form of a scoop of vanilla gelato or ice cream topped with a shot of hot espresso.",
        "Americano" to "A style of coffee prepared by brewing espresso with added hot water, giving it a similar strength but different flavor from brewed coffee.",
        "Caffe Latte" to "A tall, mild 'milk coffee' (about 150–300 ml). An espresso with steamed milk and only a little milk foam poured over it. Serve in a latte glass or a coffee cup. Flavoured syrup can be added."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView CoffeeDetailFragment")
        val root = inflater.inflate(R.layout.fragment_coffee_detail, container, false)
        titleTextView = root.findViewById(R.id.tv_coffee_title)
        descTextView = root.findViewById(R.id.tv_coffee_desc)
        return root
    }

    fun updateCoffeeDetail(coffee: String) {
        titleTextView.text = coffee.uppercase()
        descTextView.text = coffeeDetails[coffee] ?: "No description available"
    }

    companion object {
        private const val TAG = "CoffeeDetailFragment"
    }
}
