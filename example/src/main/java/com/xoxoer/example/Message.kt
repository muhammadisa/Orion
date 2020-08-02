package com.xoxoer.example

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message (
    val from: String,
    val content: String
): Parcelable