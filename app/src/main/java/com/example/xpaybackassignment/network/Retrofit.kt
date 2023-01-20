package com.example.xpaybackassignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://dummyjson.com/"

    fun getInstance(): Retrofit {
        val builder = Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build()

        return builder
    }

}

