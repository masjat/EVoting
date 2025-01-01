// File: PasswordUtils.kt
package com.example.evoting.utils

import android.text.InputType
import android.widget.EditText

object PasswordUtils {
    fun togglePasswordVisibility(editText: EditText, isPasswordVisible: Boolean): Boolean {
        val newVisibility = !isPasswordVisible
        editText.inputType = if (newVisibility) {
            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        } else {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        }
        editText.setSelection(editText.text.length)
        return newVisibility
    }
}
