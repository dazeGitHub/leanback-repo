package com.example.testpad

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import com.example.testpad.utils.DeviceUtils
import com.myleanback.widget.OnChildViewHolderSelectedListener
import com.myleanback.widget.VerticalGridView

class MyVerticalGridViewActivity : ComponentActivity() {

    companion object {
        private const val TAG = "FocusDemo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_grid)

        findViewById<View>(R.id.btn_go_recy).setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        val gridView = findViewById<VerticalGridView>(R.id.verticalGridView)

        // 设置列数（多列才能让左右方向键也生效）
        gridView.setNumColumns(2)
//        gridView.setFocusScrollStrategy(BaseGridView.FOCUS_SCROLL_ON_SCREEN); //用不了

        val screenWidth = DeviceUtils.getScreenWidth(this)
        gridView.setColumnWidth(screenWidth / 2)

        // 准备示例数据
        val items = (1..30).map { i ->
            "Item $i" to "Description for item $i"
        }

        gridView.adapter = GridItemAdapter(items)

        // 监听焦点变化
        gridView.setOnChildViewHolderSelectedListener(
            object : OnChildViewHolderSelectedListener() {
                override fun onChildViewHolderSelected(
                    parent: androidx.recyclerview.widget.RecyclerView,
                    child: androidx.recyclerview.widget.RecyclerView.ViewHolder?,
                    position: Int,
                    subposition: Int
                ) {
                    super.onChildViewHolderSelected(parent, child, position, subposition)
                    Log.d(TAG, "焦点移动到 position=$position, item=${items[position].first}")
                }
            }
        )

        // 让 VerticalGridView 自动请求焦点
        gridView.requestFocus()
    }
}
