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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var list: List<KanjiObject>
    lateinit var adapter: KanjiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = KanjiAdapter()

        val service = RetrofitLayer.getInstance().create(KanjiInterface::class.java)
        val call = service.getAllKanji()
        call.enqueue(object : Callback<List<KanjiObject>> {
            override fun onFailure(call: Call<List<KanjiObject>>, t: Throwable) {
                Toast.makeText(context, "Call Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<KanjiObject>>,
                response: Response<List<KanjiObject>>
            ) {
                adapter.setDataSet(response.body()!!)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = v.findViewById(R.id.rv_list)
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
