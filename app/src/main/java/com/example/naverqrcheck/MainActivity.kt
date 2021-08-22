package com.example.naverqrcheck

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import com.example.naverqrcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var url: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.naverQrButton.setOnClickListener() {
            url = "https://nid.naver.com/login/privacyQR"


            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            builder.setShowTitle(true)
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }

    }

}