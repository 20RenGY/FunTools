package com.funtools.android.logic

import androidx.lifecycle.liveData
import com.funtools.android.logic.network.HistoryNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchHistory(query: String)= fire(Dispatchers.IO){
        val historyResponse=HistoryNetwork.searchHistory(query)
        if (historyResponse.reason=="success"){
            val history=historyResponse.result
            Result.success(history)
        }else{
            Result.failure(RuntimeException("response status is ${historyResponse.reason}"))
        }

    }


    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}