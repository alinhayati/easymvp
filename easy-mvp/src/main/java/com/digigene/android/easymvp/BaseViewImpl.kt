package com.digigene.android.easymvp

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewImpl<Presenter : BasePresenter>(val presenter: Presenter) : BaseView, Fragment() {

    val mPresenter: Presenter = presenter
    private lateinit var mActivity: AppCompatActivity
    protected lateinit var rootView: android.view.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as AppCompatActivity
        mPresenter.setView(this)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.doWhenOnStopIsCalled()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        val fragmentLayout = getFragmentLayout()
        if (fragmentLayout > 0) {
            rootView = inflater.inflate(fragmentLayout, container, false)
            return rootView
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun introduceViewElements()

    override fun onStart() {
        super.onStart()
        introduceViewElements()
        setListeners()
    }
}