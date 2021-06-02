package com.shashank.daggerwithroom.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(val text:String ){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}