package com.example.tvapp.ui.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapp.core.BaseConcatHolder
import com.example.tvapp.databinding.TvAiringTodayRowBinding
import com.example.tvapp.ui.adapters.TvAdapter

class AiringTodayConcat(private val tvAdapter: TvAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {


    private inner class ConcatViewHolder(val binding: TvAiringTodayRowBinding) :
        BaseConcatHolder<TvAdapter>(binding.root) {
        override fun bind(adapter: TvAdapter) {
            binding.rvAiringTodayTv.adapter = adapter
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {

        val itemBinding =
            TvAiringTodayRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ConcatViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(tvAdapter)
        }
    }

    override fun getItemCount(): Int = 1
}