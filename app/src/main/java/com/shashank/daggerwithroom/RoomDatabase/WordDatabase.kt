package com.shashank.daggerwithroom.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shashank.daggerwithroom.Dao.WordDao
import com.shashank.daggerwithroom.Entity.Word

@Database(entities = [Word::class],version = 1,exportSchema = false)
abstract class WordDatabase :RoomDatabase(){

     abstract fun getDao():WordDao

     companion object{

         @Volatile
         private var INSTANCE:WordDatabase?=null

         fun getDatabase(context: Context):WordDatabase{

             return INSTANCE?: synchronized(this){
                 val instance= Room.databaseBuilder(
                     context.applicationContext,WordDatabase::class.java,"word_database"
                 ).build()
                 INSTANCE=instance
                 instance
             }
         }
     }
}