package com.shashank.daggerwithroom.Repository

import androidx.lifecycle.LiveData
import com.shashank.daggerwithroom.Dao.WordDao
import com.shashank.daggerwithroom.Entity.Word
import javax.inject.Inject

class WordRepository @Inject constructor(val dao: WordDao) {


    val allword:LiveData<List<Word>> = dao.getword()

    suspend fun insert(word: Word){
        dao.insert(word)
    }
}