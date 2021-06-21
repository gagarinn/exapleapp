package net.demo.ip.api.ui.core

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun View.setVisibility(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}