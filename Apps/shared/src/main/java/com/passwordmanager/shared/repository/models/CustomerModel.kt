package com.passwordmanager.shared.repository.models


import com.google.gson.annotations.SerializedName
import java.util.*

data class CustomerModel(
    var id: Long? = null,
    @SerializedName("group_id")
    var groupId: Long? = null,
    @SerializedName("created_at")
    var createdAt: Date? = null,
    @SerializedName("updated_at")
    var updatedAt: Date? = null,
    @SerializedName("created_in")
    var createdIn: String? = null,
    var email: String? = null,
    @SerializedName("firstname")
    var firstName: String? = null,
    @SerializedName("lastname")
    var lastName: String? = null,
    @SerializedName("store_id")
    var storeId: Long? = null,
    @SerializedName("website_id")
    var websiteId: Long? = null,
)
