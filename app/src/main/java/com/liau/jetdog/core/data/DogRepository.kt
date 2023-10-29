package com.liau.jetgithub.core.data

import com.liau.jetgithub.core.data.local.AppPreferences
import com.liau.jetgithub.core.data.local.database.JetDogDatabase
import com.liau.jetgithub.core.data.local.entity.DogEntity
import com.liau.jetgithub.core.data.network.ApiService
import com.liau.jetgithub.util.AppExecutors
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

/**
 * Created by Budiman on 19/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
@OptIn(ExperimentalCoroutinesApi::class)
class DogRepository(
    private val apiService: ApiService,
    private val pref: AppPreferences,
    private val executors: AppExecutors,
    private val database: JetDogDatabase,
) {
    val querySearchFlow = MutableStateFlow("")
    val methodQuery = MutableStateFlow(1)
    val loginUser = MutableStateFlow("")

    fun getDogBreed(): Flow<DogEntity> = flow {
        delay(2000)
        emit(DogEntity(1, "tester", ""))

    }

    companion object {
        @Volatile
        private var INSTANCE: DogRepository? = null
        fun getInstance(
            apiService: ApiService,
            pref: AppPreferences,
            appExecutors: AppExecutors,
            database: JetDogDatabase
        ): DogRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: DogRepository(apiService, pref, appExecutors, database)
            }.also { INSTANCE = it }
    }

}