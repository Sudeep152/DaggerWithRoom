package com.shashank.daggerwithroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shashank.daggerwithroom.Entity.Word
import kotlinx.android.synthetic.main.single_row.view.*

class WordAdapter(context: Context):RecyclerView.Adapter<WordAdapter.viewHolder> (){
    val list:ArrayList<Word> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val current =list[position]
        holder.Vtitle.text=current.text


    }

    fun update(newTod:List<Word>){
        list.clear()
        list.addAll(newTod)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val Vtitle =itemView.name1


    }

}