package com.shashank.daggerwithroom.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.shashank.daggerwithroom.Entity.Word
import com.shashank.daggerwithroom.Repository.WordRepository
import com.shashank.daggerwithroom.RoomDatabase.WordDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WordViewModel @Inject constructor(application: Application):AndroidViewModel(application) {

    val repository : WordRepository

    val allword : LiveData<List<Word>>

    init {
        val dao =WordDatabase.getDatabase(application).getDao()
        repository= WordRepository(dao)
        allword= repository.allword


    }
    fun insertNode(word: Word) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(word)
    }


}