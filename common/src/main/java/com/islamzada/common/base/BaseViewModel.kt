package com.islamzada.common.base

import androidx.lifecycle.ViewModel
import com.islamzada.common.flowstate.State
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel() {
    val state : MutableStateFlow<State?> = MutableStateFlow(null)

}