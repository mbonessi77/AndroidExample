package com.example.exampleapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitLayer {
        lateinit var retrofit: Retrofit
        val baseUrl = "https://kanjialive-api.p.rapidapi.com/api/public/kanji/"

        fun getInstance(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
}