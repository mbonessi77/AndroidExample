package com.example.exampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.model.KanjiObject
import com.example.exampleapp.network.KanjiInterface
import com.example.exampleapp.network.RetrofitLayer
import com.example.exampleapp.recyclerview.KanjiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: KanjiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = v.findViewById(R.id.rv_list)

        adapter = KanjiAdapter()
        recyclerView.adapter = adapter

        val service = RetrofitLayer().getInstance().create(KanjiInterface::class.java)
        val call = service.getAllKanji()
        call.enqueue(object : Callback<List<KanjiObject>> {
            override fun onFailure(call: Call<List<KanjiObject>>, t: Throwable) {
                Toast.makeText(context, "Call Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<KanjiObject>>,
                response: Response<List<KanjiObject>>
            ) {
                response.body()?.let {
                    adapter.setDataSet(response.body()!!)
                    recyclerView.layoutManager = LinearLayoutManager(context)
                } ?: run {
                    Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show()
                }
            }

        })
        return v
    }
}
