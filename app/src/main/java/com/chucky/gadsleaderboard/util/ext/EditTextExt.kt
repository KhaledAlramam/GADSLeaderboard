package com.chucky.gadsleaderboard.util.ext

import android.widget.EditText

fun EditText.isTextVerified(): Boolean = text.toString().isNotBlank()