package com.xoxo.mnp.utils.orion

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

abstract class Orion: OrionContract {

    lateinit var context: Context

    fun init (ctx: Context) {
        context = ctx
    }

    override fun navigate(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    override fun navigate(uri: Uri, extraKey: String, extra: Any) {
        context.startActivity(Intent(Intent.ACTION_VIEW, uri).apply {
            when(extra) {
                is Bundle -> putExtra(extraKey, extra)
                is Parcelable -> putExtra(extraKey, extra)
                is Serializable -> putExtra(extraKey, extra)
                is Boolean -> putExtra(extraKey, extra)
                is BooleanArray -> putExtra(extraKey, extra)
                is ByteArray -> putExtra(extraKey, extra)
                is CharArray -> putExtra(extraKey, extra)
                is CharSequence -> putExtra(extraKey, extra)
                is Double -> putExtra(extraKey, extra)
                is DoubleArray -> putExtra(extraKey, extra)
                is Float -> putExtra(extraKey, extra)
                is FloatArray -> putExtra(extraKey, extra)
                is Long -> putExtra(extraKey, extra)
                is LongArray -> putExtra(extraKey, extra)
                is Int -> putExtra(extraKey, extra)
                is IntArray -> putExtra(extraKey, extra)
                is Short -> putExtra(extraKey, extra)
                is ShortArray -> putExtra(extraKey, extra)
                is String -> putExtra(extraKey, extra)
                else -> throw OrionException("Unsupported type")
            }
        })
    }

    override fun navigateNoHistory(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

}