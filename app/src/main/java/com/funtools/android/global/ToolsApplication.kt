package com.funtools.android.global

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class ToolsApplication : Application() {
    companion object{
        const val HistoryToken="a08f3309141338dd7caad34b202a3a01"
        //防止泄露上下文
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}