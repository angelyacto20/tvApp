package com.example.tvapp.repository

import com.example.tvapp.application.AppConstants
import com.example.tvapp.data.model.TvList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {


    @GET("/3/tv/on_the_air")
    suspend fun getTvOnTheAir(@Query("api_key") api_key : String ): TvList

    @GET("/3/tv/popular")
    suspend fun getTvPopular(@Query("api_key") api_key : String ): TvList

    @GET("/3/tv/top_rated")
    suspend fun getTopRated(@Query("api_key") api_key : String ): TvList

    @GET("/3/tv/airing_today")
    suspend fun getTvAiringToday(@Query("api_key") api_key : String ): TvList


  }

object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder().baseUrl(AppConstants.API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}