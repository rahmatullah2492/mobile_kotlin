package com.example.kuliahapps

import android.os.Parcel
import android.os.Parcelable


class Moviev(
    var imageMovie: Int,
    var titleMovie: String,
    var descMovie: String


    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageMovie)
        parcel.writeString(titleMovie)
        parcel.writeString(descMovie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Moviev> {
        override fun createFromParcel(parcel: Parcel): Moviev {
            return Moviev(parcel)
        }

        override fun newArray(size: Int): Array<Moviev?> {
            return arrayOfNulls(size)
        }
    }
}