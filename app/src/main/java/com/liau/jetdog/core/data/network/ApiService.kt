package com.liau.jetdog.core.data.network

import androidx.annotation.Keep
import com.liau.jetgithub.core.data.network.request.RequestGithub
import com.liau.jetgithub.core.data.network.response.Response
import com.liau.jetgithub.core.data.network.response.follower.FollowerResponse
import com.liau.jetgithub.core.data.network.response.following.FollowingResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


/**
 * Created by Budiman on 19/01/2023.
 * Email budiliauw87@gmail.com
 * Github github.com/budiliauw87
 */
@Keep
interface ApiService {
    @POST("graphql")
    suspend fun getUsers(
        @Header("Authorization") token: String,
        @Body params: RequestGithub
    ): Response

    @POST("graphql")
    suspend fun getFollowers(
        @Header("Authorization") token: String,
        @Body params: RequestGithub
    ): FollowerResponse

    @POST("graphql")
    suspend fun getFollowing(
        @Header("Authorization") token: String,
        @Body params: RequestGithub
    ): FollowingResponse
    companion object {
        private const val BASE_URL = "https://api.github.com/"
        fun create(): ApiService{
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client =  OkHttpClient.Builder()
                .addInterceptor(logger)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}