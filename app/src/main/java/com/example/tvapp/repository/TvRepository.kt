package com.example.tvapp.repository

import com.example.tvapp.data.model.TvList

interface TvRepository {

    suspend fun getTvOnTheAir(): TvList

    suspend fun getTvPopular(): TvList

    suspend fun getTopRated(): TvList

    suspend fun getTvAiringToday(): TvList

}