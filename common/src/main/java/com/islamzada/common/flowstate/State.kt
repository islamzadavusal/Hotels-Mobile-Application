package com.islamzada.common.flowstate

class State (val status : Status, var message : String? = null) {
    companion object {
        fun success() : State = State(status = Status.SUCCESS)
        fun loading() : State = State(status = Status.LOADING)
        fun error(message: String?) : State = State(status = Status.ERROR, message = message)
    }
}

enum class Status {
    SUCCESS, ERROR, LOADING
}