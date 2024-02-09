package com.islamzada.favorite

import androidx.lifecycle.ViewModel
import com.islamzada.domain.usecase.FavoriteHotelUseCase
import com.islamzada.entities.model.FavoriteData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@HiltViewModel
//class FavoriteViewModel @Inject constructor(
//    val favUseCase : FavoriteHotelUseCase,
//    private val mapper: HotelResponseToUIStateMapper
//) : BaseViewModel() {
//    val data = MutableLiveData<HotelSearchUIState?>()
//
//    suspend fun getAll() {
//        favUseCase.getAll().collectLatest {
//            when(it) {
//                is Resource.Error -> state.emit(State.error(it.message))
//                is Resource.Loading -> state.emit(State.loading())
//                is Resource.Success -> {
//                    state.emit(State.success())
//                    it.data?.result?.let { result ->
//                        val mappedData = mapper.map(result)
//                        data.postValue(mappedData)
//                    }
//
//                }
//            }
//        }
//    }
//}

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val getFavoritesUseCase: FavoriteHotelUseCase): ViewModel() {

    suspend fun getFav(): Flow<List<FavoriteData>> {
        return getFavoritesUseCase.getFav()
    }
}