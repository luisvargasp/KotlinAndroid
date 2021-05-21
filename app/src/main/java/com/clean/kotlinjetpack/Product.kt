package com.clean.kotlinjetpack

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Product ( @SerializedName("idProducto")var productId :String ):Parcelable{

    @SerializedName("nombre")
    var name:String ?=""
    @SerializedName("descripcion")
    var description:String?=""
    @SerializedName("urlImagen")
    var imgUrl:String?=""
    @SerializedName("precioVenta")
    var price :Double?=0.0
    @SerializedName("stock")
    var stock:Int?=0
    @SerializedName("estado")
    var state:String?="A"

    constructor(parcel: Parcel) : this(parcel.readString()!!) {
        name = parcel.readString()
        description = parcel.readString()
        imgUrl = parcel.readString()
        price = parcel.readValue(Double::class.java.classLoader) as? Double
        stock = parcel.readValue(Int::class.java.classLoader) as? Int
        state = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productId)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(imgUrl)
        parcel.writeValue(price)
        parcel.writeValue(stock)
        parcel.writeString(state)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}