package com.gs.core.ui.view.progressview.callback

/**  OnProgressChangeListener is an interface for listening to the progress is changed. */
fun interface OnProgressChangeListener {

    /** invoked when progress value is changed. */
    fun onChange(progress: Float)
}
