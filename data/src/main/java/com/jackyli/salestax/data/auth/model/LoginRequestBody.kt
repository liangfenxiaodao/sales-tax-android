package com.jackyli.salestax.data.auth.model

data class LoginRequestBody(val userName: String, val password: String, val grant_type: String)