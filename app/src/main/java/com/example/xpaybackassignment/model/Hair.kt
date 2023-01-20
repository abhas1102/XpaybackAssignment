package com.example.xpaybackassignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hair(
    val color: String,
    val type: String
):Parcelable