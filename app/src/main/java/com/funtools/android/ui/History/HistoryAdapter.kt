package com.funtools.android.ui.History

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.funtools.android.R
import com.funtools.android.logic.model.Result

class HistoryAdapter(private val activity: HistoryActivity,private val historyList:List<Result>):
      RecyclerView.Adapter<HistoryAdapter.ViewHolder>(){

  /*  private var  _binding:HistoryItemBinding?=null
    private val binding get() = _binding!!*/
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val date:TextView=view.findViewById(R.id.date)
        val title:TextView=view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        val holder= ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
       val history=historyList[position]
        holder.date.text=history.date
        holder.title.text=history.title
    }

    override fun getItemCount()= historyList.size



}