package com.digigene.android.easymvp

import android.app.Fragment
import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

public abstract class BasePresenterImpl<View> : BasePresenter where View : Fragment, View : BaseView {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var mView: View
    protected lateinit var mActivity: AppCompatActivity
    protected lateinit var mContext: Context

    override fun doWhenOnStopIsCalled() {
        compositeDisposable.clear()
    }

    override fun <V> setView(view: V) where V : Fragment, V : BaseView {
        mView = view as View
        mActivity = mView.activity as AppCompatActivity
        mContext = mActivity as Context
    }
}