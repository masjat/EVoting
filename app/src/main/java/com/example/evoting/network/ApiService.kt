package com.example.evoting.network

import com.example.evoting.models.LoginRequest
import com.example.evoting.models.LoginResponse
import com.example.evoting.models.OtpRequest
import com.example.evoting.models.OtpResponse
import com.example.evoting.models.RegisterRequest
import com.example.evoting.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("send_otp")
    suspend fun sendOtp(@Body otpRequest: OtpRequest): Response<OtpResponse>

    @POST("verify_otp")
    suspend fun verifyOtp(@Body otpRequest: OtpRequest): Response<OtpResponse>
}
