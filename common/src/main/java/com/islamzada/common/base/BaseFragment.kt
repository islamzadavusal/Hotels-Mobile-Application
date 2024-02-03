package com.islamzada.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.islamzada.common.flowstate.Status
import com.islamzada.common.util.LoadingDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<B: ViewBinding, V: BaseViewModel>(private val inflate: Inflate<B>) : Fragment() {

    private lateinit var loadingDialog: LoadingDialog

    // Erise bilinmez ve okunmaz & setlenmez
    private var _binding : ViewBinding? = null

    // Okunur ama degisilmez
    protected val binding : B
        get() = _binding as B

    abstract fun mViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            loadingDialog = LoadingDialog(it)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleState()
    }

    private fun handleState(){
        lifecycleScope.launch {
            mViewModel().state.collectLatest { state->
                state?.let {
                    when(it.status) {
                        Status.SUCCESS -> showLoadingProgress(false)
                        Status.ERROR -> showLoadingProgress(false)
                        Status.LOADING -> showLoadingProgress(true)
                    }
                }
            }
        }
    }

    private fun showLoadingProgress(isLoad : Boolean) {
        if (::loadingDialog.isInitialized) { //lateinit = null degilse yoklamak icin

            loadingDialog.apply {
                if (isLoad) {
                    if (!isShowing && isAdded) // isAdded bu fragmentde gorunur yoxsa yox yoxlamak icin
                        show()
                } else {
                    dismiss()
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}