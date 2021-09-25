package com.passwordmanager.shared.repository.models

data class UserModel(
    val email: String,
    val id: Int,
    val name: String,
    val password: Any
)