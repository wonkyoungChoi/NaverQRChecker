package com.example.naverqrcheck

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import com.example.naverqrcheck.databinding.ActivityMainBinding
import com.example.naverqrcheck.setting.SettingFragment

class MainActivity : AppCompatActivity() {


    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        supportFragmentManager.beginTransaction().add(viewBinding.frameContainer.id, QrFragment()).commit()

        viewBinding.bottomNavigation.setOnItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.action_QR -> QrFragment()
                    //R.id.action_notification -> NotificationFragment()
                    else -> SettingFragment()
                }
            )
            true }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(viewBinding.frameContainer.id, fragment).commit()
    }

}