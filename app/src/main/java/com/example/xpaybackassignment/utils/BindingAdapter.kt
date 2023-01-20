package com.example.xpaybackassignment.utils

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.xpaybackassignment.R
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("imageUrl")
fun bindImage(imgView: ShapeableImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(imgUrl).apply ( RequestOptions()
        .placeholder(R.drawable.ic_loading_animation)
        .error(R.drawable.ic_broken_image)).into(imgView)
}