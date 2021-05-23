package com.merveylcu.rickandmorty.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import com.merveylcu.rickandmorty.core.AppConstants
import com.merveylcu.rickandmorty.ui.dialog.ProgressLoadingDialog

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    private val progress: ProgressLoadingDialog by lazy {
        ProgressLoadingDialog(context = this)
    }

    protected var binding: DB? = null

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract val viewModel: VM

    @UiThread
    protected abstract fun initUI()

    protected abstract fun initListener()

    protected abstract fun onChangedScreenState(state: VMState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding?.setVariable(BR.viewModel, viewModel)
        binding?.lifecycleOwner = this

        viewModel.state.observe(this, {
            onChangedScreenState(it)
        })

        initUI()
        initListener()
    }

    override fun onResume() {
        super.onResume()
        AppConstants.lastActivity = this
    }

    fun showLoading() {
        runOnUiThread {
            progress.toggle(status = true)
        }
    }

    fun hideLoading() {
        runOnUiThread {
            progress.release()
        }
    }

}