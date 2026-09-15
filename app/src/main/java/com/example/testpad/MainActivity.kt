package com.example.testpad

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_go_recy).setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        findViewById<View>(R.id.btn_go_vertical_grid).setOnClickListener {
            startActivity(Intent(this, VerticalGridViewActivity::class.java))
        }

        findViewById<View>(R.id.btn_go_vertical_grid2).setOnClickListener {
            startActivity(Intent(this, MyVerticalGridViewActivity::class.java))
        }
    }
}