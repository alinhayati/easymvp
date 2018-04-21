package com.digigene.android.easymvp

import android.app.Fragment
import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<View> : BasePresenter where View : Fragment, View : BaseView {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var mView: View

    override fun doWhenOnStopIsCalled() {
        compositeDisposable.clear()
    }

    override fun <V> setView(view: V) where V : Fragment, V : BaseView {
        mView = view as View
    }
}