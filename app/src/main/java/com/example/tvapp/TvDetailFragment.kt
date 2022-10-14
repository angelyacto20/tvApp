package com.example.tvapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tvapp.data.remote.TvDatasource
import com.example.tvapp.databinding.FragmentTvDetailBinding
import com.example.tvapp.presentation.TvViewHolderFactory
import com.example.tvapp.presentation.TvViewModel
import com.example.tvapp.repository.RetrofitClient
import com.example.tvapp.repository.TvRepositoryImp

class TvDetailFragment : Fragment(R.layout.fragment_tv_detail) {

    private val viewModel by viewModels<TvViewModel> {
        TvViewHolderFactory(TvRepositoryImp(TvDatasource(RetrofitClient.webService)))
    }

    private lateinit var binding: FragmentTvDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvDetailBinding.bind(view)
    }


}