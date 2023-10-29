package com.liau.jetgithub.core.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Budiman on 19/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_jetgithub")

class ViewModelFactory(private val repo: GitRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repo) as T
        }else if( modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ViewModelFactory(Injector.provideRepository(context))
            }.also { INSTANCE = it }
        }
    }
}


object Injector {
    fun provideRepository(context: Context): GitRepository {
        val database = JetDatabase.getInstance(context)
        val appExecutors = AppExecutors()
        val apiService = ApiConfig.provideApiService()
        val preferences = AppPreferences.getInstance(context.dataStore)
        return GitRepository.getInstance(apiService, preferences,appExecutors, database)
    }
}