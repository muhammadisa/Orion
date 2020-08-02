package com.xoxo.mnp.utils.orion

import android.net.Uri
import android.os.Parcelable

interface OrionContract {

    val appDomain: String

    val routes: Map<String, Uri>

    fun navigate(uri: Uri)

    fun navigate(uri: Uri, extraKey: String, extra: Any)

    fun navigateNoHistory(uri: Uri)

}