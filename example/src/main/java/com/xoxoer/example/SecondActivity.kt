package com.xoxoer.example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent.getParcelableExtra<Message>("MESSAGE").apply {
            Toast.makeText(
                this@SecondActivity,
                "message from ${this?.from}: ${this?.content}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}