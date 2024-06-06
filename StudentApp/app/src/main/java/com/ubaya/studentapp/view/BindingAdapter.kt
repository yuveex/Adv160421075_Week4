package com.ubaya.studentapp.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:imageUrl")
fun loadPhoto(imageView: ImageView, url: String){
    val picasso = Picasso.Builder(imageView.context)
    picasso.listener { picasso, uri, exception ->  exception.printStackTrace()}
    picasso.build().load(url).into(imageView)
    imageView.visibility = View.VISIBLE
}