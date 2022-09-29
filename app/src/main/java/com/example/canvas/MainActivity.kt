package com.example.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.example.canvas.ui.CanvasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        private const val PALETTE_VIEW = 0
        private const val TOOLS_VIEW = 2
        private const val SIZE_VIEW = 1
    }

    private val viewModel: CanvasViewModel by viewModel()


    private var toolsList: List<ToolsLayout> = listOf()

    private val paletteLayout: ToolsLayout by lazy { findViewById(R.id.paletteLayout) }
    private val toolsLayout: ToolsLayout by lazy { findViewById(R.id.toolsLayout) }
    private val sizeLayout: ToolsLayout by lazy { findViewById(R.id.sizeLayout) }
    private val ivTools: ImageView by lazy { findViewById(R.id.ivTools) }
    private val drawView: DrawView by lazy { findViewById(R.id.viewDraw) }
    private val clearView: ImageView by lazy { findViewById(R.id.btnClear) }
    private val lineView: View by lazy { findViewById(R.id.viewLine) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolsList = listOf(paletteLayout, sizeLayout, toolsLayout)
        viewModel.viewState.observe(this, ::render)

        paletteLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnPaletteClicked(it))
        }
        sizeLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnSizeClick(it))
        }

        toolsLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnToolsClick(it))
        }

        ivTools.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnToolbarClicked)
        }

        clearView.setOnClickListener {
            drawView.clear()
        }
    }


    private fun render(viewState: ViewState) {
        with(toolsList[PALETTE_VIEW]) {
            render(viewState.colorList)
            isVisible = viewState.isPaletteVisible
        }

        with(toolsList[SIZE_VIEW]) {
            render(viewState.sizeList)
            isVisible = viewState.isBrushSizeChangerVisible
        }

        with(toolsList[TOOLS_VIEW]) {
            render(viewState.toolsList)
            isVisible = viewState.isToolsVisible
        }
        drawView.render(viewState.canvasViewState)

    }
}
