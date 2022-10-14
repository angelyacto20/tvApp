package com.example.tvapp.repository

import com.example.tvapp.data.model.TvList
import com.example.tvapp.data.remote.TvDatasource

class TvRepositoryImp(private val datasource: TvDatasource) : TvRepository {
    override suspend fun getTvOnTheAir(): TvList = datasource.getTvOnTheAir()

    override suspend fun getTvPopular(): TvList = datasource.getTvPopular()

    override suspend fun getTopRated(): TvList = datasource.getTopRated()

    override suspend fun getTvAiringToday(): TvList = datasource.getTvAiringToday()

}