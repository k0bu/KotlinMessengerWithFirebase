package com.k0bu.kotlinfirebasemessenger.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//you have to turn paramaters to parcelable object
@Parcelize
class User(val uid: String, val username: String, val profileImageUrl: String): Parcelable{
    constructor() : this("","","")
}