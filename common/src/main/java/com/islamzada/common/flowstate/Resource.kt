package com.islamzada.common.flowstate

sealed class Resource<T>(var data : T? = null,
                         var message : String? = null) {

    class Success<T>(data : T) : Resource<T>(data = data)
    class Error<T>(message: String?) : Resource<T>(message = message)
    class Loading<T>() : Resource<T>()
}