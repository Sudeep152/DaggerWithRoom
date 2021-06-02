package com.shashank.daggerwithroom.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shashank.daggerwithroom.Entity.Word

@Dao
interface WordDao {


    @Insert
    suspend fun insert(word: Word)

    @Query("SELECT * FROM word_table")
    fun getword():LiveData<List<Word>>
}