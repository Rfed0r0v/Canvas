package com.example.canvas

//data class ViewState(
//    val toolList: List<ToolItem.ToolModel>,
//    val colorList: List<ToolItem.ColorModel>,
//    val sizeList: List<ToolItem.SizeModel>,
//    val canvasViewState: CanvasViewState,
//    val isPaletteVisible: Boolean,
//    val isBrushSizeChangerVisible: Boolean,
//    val isToolVisible: Boolean
//)

sealed class UiEvent : Event {
    data class OnPaletteClicked(val index: Int) : UiEvent()
    data class OnColorClick(val index: Int) : UiEvent()
    data class OnSizeClick(val index: Int) : UiEvent()
    data class OnToolsClick(val index: Int) : UiEvent()
    object OnDrawViewClicked : UiEvent()
    object OnToolBarClicked : UiEvent()
}