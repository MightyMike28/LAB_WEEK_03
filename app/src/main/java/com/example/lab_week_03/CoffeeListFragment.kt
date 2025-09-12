package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CoffeeListFragment : Fragment() {

    private lateinit var coffeeList: ListView
    private val coffees = listOf("Affogato", "Americano", "Caffe Latte")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_coffee_list, container, false)
        coffeeList = root.findViewById(R.id.coffee_listview)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            coffees
        )
        coffeeList.adapter = adapter

        coffeeList.setOnItemClickListener { _, _, position, _ ->
            val coffee = coffees[position]
            val bundle = bundleOf("coffeeName" to coffee)
            findNavController().navigate(
                R.id.action_coffeeListFragment_to_coffeeDetailFragment,
                bundle
            )
        }

        return root
    }
}
