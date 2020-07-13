package com.example.exampleapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.model.KanjiObject

class KanjiAdapter() : RecyclerView.Adapter<KanjiViewHolder>() {
    lateinit var kanjiList: List<KanjiObject>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanjiViewHolder {
        return KanjiViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.kanji_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return kanjiList.count()
    }

    override fun onBindViewHolder(holder: KanjiViewHolder, position: Int) {
        holder.character.text = kanjiList[position].kanji.character
    }

    fun setDataSet(kanjiList: List<KanjiObject>) {
        this.kanjiList = kanjiList
        notifyDataSetChanged()
    }
}