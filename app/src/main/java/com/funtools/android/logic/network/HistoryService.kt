package com.funtools.android.logic.network

import com.funtools.android.global.ToolsApplication
import com.funtools.android.logic.model.HistoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface HistoryService {

    @GET("todayOnhistory/queryEvent.php?key=${ToolsApplication.HistoryToken}")
    fun searchHistory(@Query("date")query:String):Call<HistoryResponse>
}