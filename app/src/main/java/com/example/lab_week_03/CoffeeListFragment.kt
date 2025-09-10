package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class CoffeeListFragment : Fragment() {

    interface OnCoffeeSelectedListener {
        fun onCoffeeSelected(coffee: String)
    }

    private var listener: OnCoffeeSelectedListener? = null
    private lateinit var coffeeList: ListView

    private val coffees = listOf(
        "Affogato",
        "Americano",
        "Caffe Latte"
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCoffeeSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnCoffeeSelectedListener")
        }
        Log.d(TAG, "onAttach CoffeeListFragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView CoffeeListFragment")
        val root = inflater.inflate(R.layout.fragment_coffee_list, container, false)
        coffeeList = root.findViewById(R.id.coffee_listview)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            coffees
        )
        coffeeList.adapter = adapter

        coffeeList.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val coffee = coffees[position]
                listener?.onCoffeeSelected(coffee)
            }

        return root
    }

    companion object {
        private const val TAG = "CoffeeListFragment"
    }
}
