package com.example.xpaybackassignment.network


import com.example.xpaybackassignment.model.User
import com.example.xpaybackassignment.model.UsersDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers(@Query("limit") limit:Int) : Response<UsersDataModel>
}