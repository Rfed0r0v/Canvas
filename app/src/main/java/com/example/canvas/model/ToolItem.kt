package com.example.canvas.model

import androidx.annotation.ColorRes
import com.example.canvas.data.COLOR
import com.example.canvas.data.SIZE
import com.example.canvas.data.TOOLS

sealed class ToolItem : Item {

    data class ColorModel(@ColorRes val color: Int) : ToolItem()
    data class SizeModel(val size: Int) : ToolItem()
    data class ToolModel(
        val type: TOOLS,
        val selectedTool: TOOLS = TOOLS.NORMAL,
        val isSelected: Boolean = false,
        val selectedSize: SIZE = SIZE.SMALL,
        val selectedColor: COLOR = COLOR.BLACK
    ) : ToolItem()
}