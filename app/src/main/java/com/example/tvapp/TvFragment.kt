package com.example.tvapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapp.core.Resource
import com.example.tvapp.data.model.Tv
import com.example.tvapp.data.remote.TvDatasource
import com.example.tvapp.databinding.FragmentTvBinding
import com.example.tvapp.presentation.TvViewHolderFactory
import com.example.tvapp.presentation.TvViewModel
import com.example.tvapp.repository.RetrofitClient
import com.example.tvapp.repository.TvRepositoryImp
import com.example.tvapp.ui.adapters.TvAdapter
import com.example.tvapp.ui.concat.AiringTodayConcat
import com.example.tvapp.ui.concat.OnTheAirConcat
import com.example.tvapp.ui.concat.TopRatedConcat
import com.example.tvapp.ui.concat.TvPopularConcat

class TvFragment : Fragment(R.layout.fragment_tv), TvAdapter.OnTvClickListener {

    private lateinit var binding: FragmentTvBinding

    private lateinit var concatAdapter: ConcatAdapter

    private val viewModel by viewModels<TvViewModel> {
        TvViewHolderFactory(TvRepositoryImp(TvDatasource(RetrofitClient.webService)))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvBinding.bind(view)
        concatAdapter = ConcatAdapter()
        viewModel.fetchAllTv().observe(viewLifecycleOwner, Observer { results ->
            when (results) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE

                    Log.d("TvData", "Loading....")
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            AiringTodayConcat(TvAdapter(results.data.t1.results, this@TvFragment))
                        )
                        addAdapter(
                            1,
                            OnTheAirConcat(TvAdapter(results.data.t2.results, this@TvFragment))
                        )
                        addAdapter(
                            2,
                            TopRatedConcat(TvAdapter(results.data.t3.results, this@TvFragment))
                        )
                        addAdapter(
                            3,
                            TvPopularConcat(TvAdapter(results.data.t2.results, this@TvFragment))
                        )
                    }
                    binding.rvTv.setHasFixedSize(true)
                    binding.rvTv.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                    binding.rvTv.adapter = concatAdapter

                }
                is Resource.Failure -> {
                    Log.d("TvDataError", results.e.message.toString())
                }
            }
        })
    }

    override fun onMovieClick(tv: Tv) {
        //navigation components

    }


}