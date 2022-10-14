package com.example.tvapp.data.remote

import com.example.tvapp.application.AppConstants
import com.example.tvapp.data.model.TvList
import com.example.tvapp.repository.WebService

class TvDatasource(private val webService: WebService) {

    suspend fun getTvOnTheAir(): TvList = webService.getTvOnTheAir(AppConstants.API_KEY)

    suspend fun getTvPopular(): TvList = webService.getTvPopular(AppConstants.API_KEY)

    suspend fun getTopRated(): TvList = webService.getTopRated(AppConstants.API_KEY)

    suspend fun getTvAiringToday(): TvList = webService.getTvAiringToday(AppConstants.API_KEY)
}