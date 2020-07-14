package com.example.exampleapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.exampleapp.model.KanjiObject
import com.example.exampleapp.network.KanjiInterface
import com.example.exampleapp.network.RetrofitLayer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KanjiListViewModel : ViewModel() {
    private var kanjiList: List<KanjiObject>? = ArrayList()

    fun getList(): List<KanjiObject>? {
        val service = RetrofitLayer().getInstance().create(KanjiInterface::class.java)
        val call = service.getAllKanji()
        call.enqueue(object : Callback<List<KanjiObject>> {
            override fun onFailure(call: Call<List<KanjiObject>>, t: Throwable) {
                print("Call failed")
            }

            override fun onResponse(call: Call<List<KanjiObject>>, response: Response<List<KanjiObject>>) {
                response.body()?.let {
                    kanjiList = response.body()
                }
            }
        })

        return kanjiList
    }
}