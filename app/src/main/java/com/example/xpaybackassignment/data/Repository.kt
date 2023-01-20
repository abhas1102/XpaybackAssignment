package com.example.xpaybackassignment.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.xpaybackassignment.model.User
import com.example.xpaybackassignment.model.UsersDataModel
import com.example.xpaybackassignment.network.ApiInterface
import com.example.xpaybackassignment.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(){

    val userApi = RetrofitHelper.getInstance().create(ApiInterface::class.java)


    suspend fun getUsers(): UsersDataModel?{

        return withContext(Dispatchers.IO) {
            val result = userApi.getUsers(100)
            result.body()
        }
    }
}