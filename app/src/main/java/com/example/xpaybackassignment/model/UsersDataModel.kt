package com.example.xpaybackassignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersDataModel(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
):Parcelable