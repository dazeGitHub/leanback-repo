package com.example.testpad

import android.os.Bundle
import android.util.TypedValue
import androidx.activity.ComponentActivity
import androidx.leanback.widget.VerticalGridView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<VerticalGridView>(R.id.verticalGridView)

        // 设置列数
        gridView.setNumColumns(2)

        // 设置间距
        // 准备示例数据
        val items = (1..30).map { i ->
            "Item $i" to "Description for item $i"
        }

        gridView.adapter = GridItemAdapter(items)
    }
}
