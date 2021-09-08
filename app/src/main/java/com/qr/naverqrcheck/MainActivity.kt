package com.qr.naverqrcheck

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.qr.naverqrcheck.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var baseUrl: String
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        baseUrl = "https://nid.naver.com/login/privacyQR"

        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(baseUrl))
        finish()

    }
}