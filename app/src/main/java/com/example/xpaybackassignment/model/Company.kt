package com.example.xpaybackassignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
):Parcelable