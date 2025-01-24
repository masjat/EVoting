// File: ValidationUtils.kt
package com.example.evoting.utils

object ValidationUtils {

    fun isFullNameValid(fullname: String): Boolean {
        return fullname.isNotEmpty()
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6 // Password minimal 6 karakter
    }

    fun doPasswordsMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }
    fun noIdentityValid(noIdentity: String): Boolean {
        return noIdentity.isNotEmpty()
    }
}
