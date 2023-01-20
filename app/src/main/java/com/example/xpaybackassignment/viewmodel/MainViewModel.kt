package com.example.xpaybackassignment.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.xpaybackassignment.data.Repository
import com.example.xpaybackassignment.model.User
import com.example.xpaybackassignment.model.UsersDataModel
import kotlinx.coroutines.launch
import java.io.IOException


class MainViewModel:ViewModel() {

    private val repository = Repository()

    private val _users = MutableLiveData<UsersDataModel>()
    val users :LiveData<UsersDataModel> = _users




    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            try {
                val data = repository.getUsers()
                _users.postValue(data)
            }catch (e: IOException){

            }


        }
    }
}