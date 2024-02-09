package com.islamzada.domain.usecase

import com.islamzada.common.flowstate.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//class FavoriteHotelUseCase @Inject constructor(
//    private val repository: FavoriteRepository
//) {
//    fun getAllData(): LiveData<List<HotelUIModel>> {
//        return repository.getAll()
//    }
//}


//class FavoriteHotelUseCase @Inject constructor(
//    private val repository : FavoriteRepositoryInterface
//) {
//    suspend fun getAll() = flow {
//        emit(Resource.Loading())
//        emit(Resource.Success(repository.getAll()))
//    }.catch { exception->
//        emit(Resource.Error(exception.localizedMessage))
//    }
//}