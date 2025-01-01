package com.example.evoting.network

import com.example.evoting.models.LoginRequest
import com.example.evoting.models.LoginResponse
import com.example.evoting.models.OtpRequest
import com.example.evoting.models.OtpResponse
import com.example.evoting.models.RegisterRequest
import com.example.evoting.models.RegisterResponse
import retrofit2.Response

class AuthManager {

    suspend fun login(email: String, password: String): Response<LoginResponse> {
        val loginRequest = LoginRequest(email, password)
        return RetrofitClient.instance.login(loginRequest)
    }
    suspend fun register(fullName: String, email: String, password: String, confirmPassword: String): Response<RegisterResponse> {
        val registerRequest = RegisterRequest(fullName, email, password, confirmPassword)
        return RetrofitClient.instance.register(registerRequest)
    }
    suspend fun sendOtp(email: String): Response<OtpResponse> {
        val otpRequest = OtpRequest(email)
        return RetrofitClient.instance.sendOtp(otpRequest)
    }
    suspend fun verifyOtp(email: String, otp: String): Response<OtpResponse> {
        val otpRequest = OtpRequest(email, otp)
        return RetrofitClient.instance.verifyOtp(otpRequest)
    }

}
