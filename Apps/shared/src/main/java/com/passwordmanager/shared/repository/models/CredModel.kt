package com.passwordmanager.shared.repository.models

data class CredModel(
    val canDelete: Boolean,
    val canEdit: Boolean,
    val canView: Boolean,
    val description: String,
    val id: Int,
    val isDeleted: Boolean,
    val name: String,
    val password: String,
    val userId: Int,
    val userName: String,
    val users: Any
)