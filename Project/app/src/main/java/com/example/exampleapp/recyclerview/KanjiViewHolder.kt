package com.example.exampleapp.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R

class KanjiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var character: TextView = itemView.findViewById(R.id.tv_character)
}