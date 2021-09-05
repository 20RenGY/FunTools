package com.funtools.android.ui.History

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.funtools.android.logic.Repository
import com.funtools.android.logic.model.Result

class HistoryViewModel : ViewModel() {

    private val searchHistoryLiveData=MutableLiveData<String>()
    val historyList = ArrayList<Result>()
    val historyLiveData=Transformations.switchMap(searchHistoryLiveData){query->
         Repository.searchHistory(query)
    }
    fun searchHistory(query:String){
        searchHistoryLiveData.value=query
    }
}