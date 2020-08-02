package com.xoxoer.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xoxoer.example.InitialRouteName.FIRST
import com.xoxoer.example.InitialRouteName.SECOND
import com.xoxoer.example.InitialRouteName.THIRD
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_first.setOnClickListener {
            // normal navigate
            Route(it.context, FIRST).navigate()
        }

        button_second.setOnClickListener {
            // navigate with extra data parcelable
            Route(it.context, SECOND).navigate("MESSAGE", Message(
                "MainActivity",
                "Hello, navigating with deeplink and orion"
            ))
        }

        button_third.setOnClickListener {
            // navigate without back to previous activity
            Route(it.context, THIRD).navigateNoHistory()
        }

    }

}