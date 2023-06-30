package com.myaplication.policarrito

import android.os.Parcel
import android.os.Parcelable

data class Productos(var Nombre : String ?= null,
                     var Precio : String ?= null,
                     var Cantidad : String ?= null) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Nombre)
        parcel.writeString(Precio)
        parcel.writeString(Cantidad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Productos> {
        override fun createFromParcel(parcel: Parcel): Productos {
            return Productos(parcel)
        }

        override fun newArray(size: Int): Array<Productos?> {
            return arrayOfNulls(size)
        }
    }
}
