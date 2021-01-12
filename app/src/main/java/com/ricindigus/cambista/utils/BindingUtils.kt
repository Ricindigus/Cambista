package com.ricindigus.cambista.utils


import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("isVisibleView")
fun View.setVisibleView(value: Boolean?){
    value?.let { visible ->
        visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}

@BindingAdapter("isShowView")
fun View.setShowView(value: Boolean?){
    value?.let { visible ->
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}

@BindingAdapter("enableButton")
fun View.setButtonEnabled(value: Boolean?){
    value?.let { enable ->
        if (enable){
            isEnabled = true
            alpha = 1.0F
        }else{
            isEnabled = false
            alpha = 0.5F
        }
    }
}









