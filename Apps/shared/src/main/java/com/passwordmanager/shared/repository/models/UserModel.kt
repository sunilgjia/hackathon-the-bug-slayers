package com.passwordmanager.shared.repository.models
import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("password")
    var password: Any? = null
)