package com.example.exampleapp.network

import com.example.exampleapp.model.KanjiObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface KanjiInterface {

    @Headers("x-rapidapi-host: kanjialive-api.p.rapidapi.com", "x-rapidapi-key: 5e767cb641msh8241007199f1aa8p1c505bjsna85704504edc")
    @GET("/all")
    fun getAllKanji(): Call<List<KanjiObject>>
}