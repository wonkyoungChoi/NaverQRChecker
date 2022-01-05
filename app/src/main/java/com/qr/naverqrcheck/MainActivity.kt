package com.qr.naverqrcheck

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val url = "naversearchapp://opennadot?cardId=QRCheckIn&character=brown&nclick=nappwiq.qrcheckin&referer=widget&version=46"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            finish()
        } catch (e : Exception) {
            Toast.makeText(applicationContext, "네이버 앱을 설치하셔야 QR인증이 가능합니다.", Toast.LENGTH_SHORT).show()
            val url = "https://play.google.com/store/apps/details?id=com.nhn.android.search"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            finish()
        }
    }
}