package com.liau.jetdog.core.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.liau.jetdog.core.data.local.entity.DogEntity

/**
 * Created by Budiman on 26/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
@Database(entities = [DogEntity::class], version = 1, exportSchema = false)
abstract class JetDogDatabase:RoomDatabase() {
    abstract fun dao(): BreedDao

    companion object {
        @Volatile
        private var INSTANCE: JetDogDatabase? = null

        fun getInstance(context: Context): JetDogDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    JetDogDatabase::class.java,
                    "jetdogapp.db"
                ).build().apply {
                    INSTANCE = this
                }
            }

    }
}