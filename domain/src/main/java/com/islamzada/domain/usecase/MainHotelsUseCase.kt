package com.islamzada.domain.usecase

import com.islamzada.common.flowstate.Resource
import com.islamzada.data.repo.HotelsRepositoryInterface
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainHotelsUseCase @Inject constructor(
    private val repository : HotelsRepositoryInterface
) {
    suspend fun getList() = flow {
        emit(Resource.Loading())
        repository.getHotel()?.let {
            emit(Resource.Success(it))
        } ?: emit(Resource.Error("Empty message error"))
    }.catch { exception->
        emit(Resource.Error(exception.localizedMessage))
    }
}