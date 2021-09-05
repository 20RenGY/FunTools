package com.funtools.android.ui.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funtools.android.R
import com.funtools.android.databinding.ActivityHistoryBinding
import com.funtools.android.databinding.ActivityMainBinding
import com.funtools.android.ui.History.HistoryActivity

//好玩的工具
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.historyBtn.setOnClickListener {
            val intent=Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }

    }
}