@file:Suppress("DEPRECATION")

package com.passwordmanager.shared.utils

import android.R
import android.graphics.Bitmap
import android.graphics.Paint
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter

@BindingAdapter("entries", "itemLayout", "textViewId", requireAll = false)
fun setAdapterAutoComplete(
    autoCompleteTextView: AutoCompleteTextView,
    entries: List<*>?,
    @LayoutRes itemLayout: Int?,
    @IdRes textViewId: Int?
) {
    val adapter = when {
        itemLayout == null -> {
            ArrayAdapter(
                autoCompleteTextView.context,
                R.layout.simple_list_item_1,
                R.id.text1,
                entries ?: emptyList()
            )
        }
        textViewId == null -> {
            ArrayAdapter(autoCompleteTextView.context, itemLayout, entries ?: emptyList())
        }
        else -> {
            ArrayAdapter(
                autoCompleteTextView.context,
                itemLayout,
                textViewId,
                entries ?: emptyList()
            )
        }
    }
    autoCompleteTextView.setAdapter(adapter)
}


@BindingAdapter("strike")
fun setStrikeThrough(textView: TextView, strike: Boolean) {
    if (strike) {
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}
