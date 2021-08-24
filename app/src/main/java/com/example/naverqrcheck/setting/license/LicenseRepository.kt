package com.example.naverqrcheck.setting.license

class LicenseRepository {
    fun requestLicense(): List<License> {
        return listOf(
            License(
                "firebase",
                "firebase",
                " "
            ),
            License(
                "lottie",
                "lottie",
                "Copyright 2018 Airbnb, Inc."
            )
        )
    }
}