package com.liau.jetdog.core.data.local.database

import androidx.room.*
import com.liau.jetdog.core.data.local.entity.DogEntity

/**
 * Created by Budiman on 27/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
@Dao
interface BreedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(entity: DogEntity)
    @Delete
    fun deleteFavorite(entity: DogEntity)
}