package com.islamzada.hotels

import androidx.lifecycle.MutableLiveData
import com.islamzada.common.base.BaseViewModel
import com.islamzada.common.flowstate.Resource
import com.islamzada.common.flowstate.State
import com.islamzada.domain.mapper.HotelResponseToUIStateMapper
import com.islamzada.domain.usecase.MainHotelsUseCase
import com.islamzada.entities.uimodel.HotelSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    val searchUseCase : MainHotelsUseCase,
    private val mapper: HotelResponseToUIStateMapper
) : BaseViewModel() {
    val data = MutableLiveData<HotelSearchUIState?>()

    suspend fun getHotels() {
        searchUseCase.getList().collectLatest {
            when(it) {
                is Resource.Error -> state.emit(State.error(it.message))
                is Resource.Loading -> state.emit(State.loading())
                is Resource.Success -> {
                    state.emit(State.success())
                    it.data?.result?.let { result ->
                        val mappedData = mapper.map(result)
                        data.postValue(mappedData)
                    }

                }
            }
        }
    }
}