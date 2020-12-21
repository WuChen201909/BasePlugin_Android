package com.harrison.plugin.mvvm.base.impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.harrison.plugin.mvvm.base.IView
import com.harrison.plugin.mvvm.core.MVVMApplication


open abstract class ABaseActivityView<T : ABaseViewModel> : IView, AppCompatActivity() {

    private lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(MVVMApplication.application)
        )
            .get(viewModel.javaClass)

        setContentView(getLayoutId())
        initViewObservable()
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    override fun onStop() {
        super.onStop()
        unBindViewModel()
    }

    override fun bindViewModel() {
        viewModel.initModel()
    }

    override fun unBindViewModel() {

    }

    /**
     *  在Android中使用xml布局使用
     */
    abstract fun getLayoutId(): Int


}