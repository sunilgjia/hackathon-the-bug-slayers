package com.passwordmanager.shared.repository.models


import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

@Keep
data class AvailableRegionModel(
    var id: String? = null,
    var code: String? = null,
    var name: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun toString(): String {
        return name ?: super.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(code)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AvailableRegionModel> {
        override fun createFromParcel(parcel: Parcel): AvailableRegionModel {
            return AvailableRegionModel(parcel)
        }

        override fun newArray(size: Int): Array<AvailableRegionModel?> {
            return arrayOfNulls(size)
        }
    }
}
