package com.digigene.android.easymvp

import android.app.Fragment

interface BasePresenter {
    fun <V> setView(view: V) where V : Fragment, V : BaseView
    fun doWhenOnStopIsCalled()
}