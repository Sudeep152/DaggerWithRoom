package com.shashank.daggerwithroom.di

import android.content.Context
import com.shashank.daggerwithroom.Dao.WordDao
import com.shashank.daggerwithroom.Repository.WordRepository
import com.shashank.daggerwithroom.RoomDatabase.WordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Singleton
    @Provides
    fun getAppDb(@ApplicationContext context: Context):WordDatabase{
        return WordDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb:WordDatabase):WordDao{
        return appDb.getDao()
    }

    @Singleton
    @Provides
    fun getRepository(wordDao:WordDao):WordRepository{
        return WordRepository(wordDao)
    }
}