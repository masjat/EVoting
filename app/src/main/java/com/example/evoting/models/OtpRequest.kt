package com.example.evoting.models


data class OtpRequest(
    val email: String,
    val otp: String? = null // Untuk request verifikasi OTP, bisa menambahkan field OTP
)
