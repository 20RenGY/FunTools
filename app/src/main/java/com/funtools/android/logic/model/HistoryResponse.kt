package com.funtools.android.logic.model

data class HistoryResponse(
    val error_code: Int,
    val reason: String,
    val result: List<Result>
)

data class Result(
    val date: String,
    val day: String,
    val e_id: String,
    val title: String
)