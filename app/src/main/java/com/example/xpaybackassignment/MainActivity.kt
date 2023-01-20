package com.example.xpaybackassignment

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaybackassignment.clicklistener.ClickListener
import com.example.xpaybackassignment.databinding.ItemActivityMainBinding
import com.example.xpaybackassignment.model.User
import com.example.xpaybackassignment.model.UsersDataModel
import com.example.xpaybackassignment.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private val mainActivityViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickListener = object:ClickListener{
            override fun onClick(user: User) {
                val intent = Intent(this@MainActivity,DetailActivity::class.java )
                intent.putExtra("userDetails", user )
                startActivity(intent)
            }

        }
        val textinternet : TextView = findViewById(R.id.text_internet_on)

        if (verifyAvailableNetwork(this)) {
            textinternet.visibility = View.GONE
        } else {
            textinternet.visibility = View.VISIBLE

        }

        mainActivityViewModel.users.observe(this){
            if (it.users.size > 0)
            Log.d("Network data", mainActivityViewModel.users.value.toString())
            Toast.makeText(this,it.users.size.toString(), Toast.LENGTH_SHORT).show()

            val recyclerView:RecyclerView = findViewById(R.id.usersListRecyclerView)
            recyclerView.adapter = UsersAdapter(it.users,clickListener)



        }

    }
    fun verifyAvailableNetwork(activity:AppCompatActivity):Boolean{
        val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}