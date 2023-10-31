package com.liau.jetdog.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Budiman on 27/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
@Entity(tableName = "dog")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val urlImage :String,
)
