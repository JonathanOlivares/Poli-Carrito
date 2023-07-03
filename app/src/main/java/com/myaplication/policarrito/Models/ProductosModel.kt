package com.myaplication.policarrito.Models

import android.os.Parcel
import android.os.Parcelable

data class ProductosModel(var Nombre : String ?= null,
                          var Precio : String ?= null,
                          var Cantidad : String ?= null,
                          var Imagen : String?= null,
                         )
