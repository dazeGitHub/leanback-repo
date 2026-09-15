package com.example.testpad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridItemAdapter(
    private val items: List<Pair<String, String>>
) : RecyclerView.Adapter<GridItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = view.findViewById(R.id.textTitle)
        val textSubtitle: TextView = view.findViewById(R.id.textSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title, subtitle) = items[position]
        holder.textTitle.text = title
        holder.textSubtitle.text = subtitle
    }

    override fun getItemCount(): Int = items.size
}
