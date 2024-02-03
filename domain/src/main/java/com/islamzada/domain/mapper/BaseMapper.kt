package com.islamzada.domain.mapper

interface BaseMapper<Input, Output> {
    fun map(input : Input) : Output
}