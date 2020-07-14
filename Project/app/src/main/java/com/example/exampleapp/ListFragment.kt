package com.example.exampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.model.KanjiObject
import com.example.exampleapp.recyclerview.KanjiAdapter
import com.example.exampleapp.viewmodel.KanjiListViewModel

class ListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: KanjiAdapter
    lateinit var viewModel: KanjiListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KanjiListViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = v.findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getList()

        return v
    }

    private fun observeViewModel() {
        val observer = Observer<List<KanjiObject>> {
            adapter = KanjiAdapter()
            adapter.setDataSet(it)
            recyclerView.adapter = adapter
        }

        viewModel.kanjiList.observeForever(observer)
    }
}
