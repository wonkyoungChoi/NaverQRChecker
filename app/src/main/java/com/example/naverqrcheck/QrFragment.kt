package com.example.naverqrcheck

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.naverqrcheck.databinding.FragmentQrBinding


class QrFragment : Fragment() {

    private var _viewBinding: FragmentQrBinding? = null
    private val viewBinding get() = _viewBinding!!
    private lateinit var url: String

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentQrBinding.inflate(inflater, container, false)

        url = "https://nid.naver.com/login/privacyQR"

        viewBinding.webView.webViewClient = WebViewClient()
        viewBinding.webView.settings.javaScriptEnabled = true // to load mobile version


        viewBinding.webView.loadUrl(url)

        return viewBinding.root
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }
}