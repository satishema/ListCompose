package com.satish.mycomposeapp.data.remote

import com.satish.mycomposeapp.model.Photos
import com.satish.mycomposeapp.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Satish V on 05-01-2023.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */

interface APIService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    @GET("photos")
    suspend fun getPhotos(): List<Photos>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}