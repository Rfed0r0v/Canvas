package com.example.canvas.data

import androidx.annotation.ColorRes
import com.example.canvas.R

enum class COLOR(
    @ColorRes
    val value: Int
) {
    RED (R.color.red),
    BLUE(R.color.purple_700),
    GREEN (R.color.green),
    BLACK(R.color.black),
    WHITE (R.color.white);

    companion object {
        private val map = values().associateBy(COLOR::value)
        fun from(color: Int) = map[color] ?: BLACK
    }
}