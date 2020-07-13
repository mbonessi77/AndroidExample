package com.example.exampleapp.network

import com.example.exampleapp.model.KanjiObject
import retrofit2.Call
import retrofit2.http.GET

interface KanjiInterface {

    @GET("/all")
    fun getAllKanji(): Call<List<KanjiObject>>
}