package com.xoxoer.example

import android.content.Context
import android.net.Uri
import com.xoxo.mnp.utils.orion.Orion
import com.xoxo.mnp.utils.orion.OrionContract
import com.xoxoer.example.InitialRouteName.FIRST
import com.xoxoer.example.InitialRouteName.SECOND
import com.xoxoer.example.InitialRouteName.THIRD

object InitialRouteName {
    const val FIRST = "first"
    const val SECOND = "second"
    const val THIRD = "third"
}

class Route internal constructor(
    context: Context,
    private val initial: String
) : Orion(), OrionContract {

    init {
        super.init(context)
    }

    override val appDomain: String = context.getString(R.string.app_domain)

    override val routes: Map<String, Uri> = mapOf(
        FIRST to Uri.parse("$appDomain://first.act"),
        SECOND to Uri.parse("$appDomain://second.act"),
        THIRD to Uri.parse("$appDomain://third.act")
    )

    fun navigate() {
        super.navigate(routes[initial] ?: error(""))
    }

    fun navigate(extraKey: String, extra: Any) {
        val uri = routes[initial] ?: error("")
        super.navigate(uri, extraKey, extra)
    }

    fun navigateNoHistory() {
        super.navigateNoHistory(routes[initial] ?: error(""))
    }

}