package com.example.testpad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RVFocusDemo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // 使用 GridLayoutManager 与 VerticalGridView 做对比（3 列）
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // 准备示例数据
        val items = (1..30).map { i ->
            "Item $i" to "Description for item $i"
        }

        recyclerView.adapter = GridItemAdapter(items)

        // 监听子 View 焦点变化
        recyclerView.addOnChildAttachStateChangeListener(
            object : RecyclerView.OnChildAttachStateChangeListener {
                override fun onChildViewAttachedToWindow(view: android.view.View) {
                    view.setOnFocusChangeListener { v, hasFocus ->
                        if (hasFocus) {
                            val pos = recyclerView.getChildAdapterPosition(v)
                            if (pos != RecyclerView.NO_POSITION) {
                                Log.d(TAG, "焦点移动到 position=$pos, item=${items[pos].first}")
                            }
                        }
                    }
                }

                override fun onChildViewDetachedFromWindow(view: android.view.View) {
                    view.setOnFocusChangeListener(null)
                }
            }
        )

        // 请求焦点
        recyclerView.requestFocus()
    }
}
