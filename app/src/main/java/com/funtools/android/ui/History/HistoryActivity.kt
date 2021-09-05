package com.funtools.android.ui.History

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.funtools.android.R
import com.funtools.android.databinding.ActivityHistoryBinding
import com.funtools.android.databinding.ActivityMainBinding

class HistoryActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProviders.of(this).get(HistoryViewModel::class.java) }
    private lateinit var binding: ActivityHistoryBinding
    lateinit var historyDate:String
    lateinit var  adapter:HistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager= LinearLayoutManager(this)
        binding.recyclerviewHistory.layoutManager=layoutManager
        adapter= HistoryAdapter(this,viewModel.historyList)
        binding.recyclerviewHistory.adapter=adapter

        binding.btnSend.setOnClickListener {
            historyDate=binding.etDate.text.toString()
            viewModel.searchHistory(historyDate)
        }

        viewModel.historyLiveData.observe(this,{result->
             val history=result.getOrNull()
            if (history!=null){
                viewModel.historyList.clear()
                viewModel.historyList.addAll(history)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "未能查询到信息,或是格式不对", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })

    }
}