package com.example.exampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.recyclerview.KanjiAdapter
import com.example.exampleapp.viewmodel.KanjiListViewModel

class ListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: KanjiAdapter
    lateinit var viewModel: KanjiListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = v.findViewById(R.id.rv_list)
        viewModel = ViewModelProviders.of(this).get(KanjiListViewModel::class.java)
        adapter = KanjiAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val list = viewModel.getList()
        list?.let {
            adapter.setDataSet(it)
        } ?: kotlin.run {
            Toast.makeText(context, "Call failed", Toast.LENGTH_SHORT).show()
        }

        return v
    }
}
