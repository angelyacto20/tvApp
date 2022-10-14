package com.example.tvapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.tvapp.core.Resource
import com.example.tvapp.repository.TvRepositoryImp
import kotlinx.coroutines.Dispatchers

class TvViewModel(private val repo: TvRepositoryImp) : ViewModel() {

    fun fetchAllTv() = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    NTuple(

                        repo.getTvAiringToday(),
                        repo.getTvOnTheAir(),
                        repo.getTopRated(),
                        repo.getTvPopular()
                    )
                )
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class TvViewHolderFactory(private val repo: TvRepositoryImp) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TvRepositoryImp::class.java).newInstance(repo)
    }
}

data class NTuple<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4)
