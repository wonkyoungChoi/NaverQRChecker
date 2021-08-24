package com.example.naverqrcheck.setting.license

import androidx.lifecycle.ViewModel

class LicenseViewModel: ViewModel() {
    private val licenseRepository = LicenseRepository()

    fun requestLicense(): List<License> {
        return licenseRepository.requestLicense()
    }

}
