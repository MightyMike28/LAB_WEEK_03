package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CoffeeDetailFragment : Fragment() {

    private lateinit var titleTextView: TextView
    private lateinit var descTextView: TextView

    private val coffeeDetails = mapOf(
        "Affogato" to "Espresso poured on a vanilla ice cream. Served in a cappuccino cup.",
        "Americano" to "Espresso with added hot water (100–120 ml). Served in a normal coffee cup.",
        "Caffe Latte" to "Espresso with steamed milk and a little milk foam (150–300 ml). Served in a latte glass or coffee cup.",
        "Cappuccino" to "Espresso with steamed milk and deep layer of foam (150–180 ml). Often topped with cocoa powder or cinnamon.",
        "Espresso" to "Strong black coffee made by forcing steam through ground coffee beans. Usually served in a small cup (30 ml)."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_coffee_detail, container, false)
        titleTextView = root.findViewById(R.id.tv_coffee_title)
        descTextView = root.findViewById(R.id.tv_coffee_desc)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ambil argumen dari nav (coffeeName)
        val coffeeName = arguments?.getString("coffeeName")
        if (coffeeName != null) {
            titleTextView.text = coffeeName.uppercase()
            descTextView.text = coffeeDetails[coffeeName] ?: "No description available"
        } else {
            titleTextView.text = "SELECT A COFFEE"
            descTextView.text = ""
        }

        // tombol back (gunakan findNavController.navigateUp() — fallback ke onBackPressed jika perlu)
        val backButton = view.findViewById<Button>(R.id.btn_back)
        backButton.setOnClickListener {
            val handled = findNavController().navigateUp()
            if (!handled) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
