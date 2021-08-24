package com.example.naverqrcheck.setting.appnotice.content

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.naverqrcheck.databinding.ActivityNoticeContentBinding

class NoticeContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAppNoticeTitle.text = intent.getStringExtra("title")
        binding.tvAppNoticeDate.text = intent.getStringExtra("date")
        binding.tvAppNoticeContent.text = intent.getStringExtra("content")

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}