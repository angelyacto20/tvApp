package com.example.tvapp.ui.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapp.core.BaseConcatHolder
import com.example.tvapp.databinding.TvTopRatedRowBinding
import com.example.tvapp.ui.adapters.TvAdapter

class TopRatedConcat(private val tvAdapter: TvAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {


    private inner class ConcatViewHolder(val binding: TvTopRatedRowBinding) :
        BaseConcatHolder<TvAdapter>(binding.root) {
        override fun bind(adapter: TvAdapter) {
            binding.rvTopRatedTv.adapter = adapter
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {

        val itemBinding = TvTopRatedRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ConcatViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(tvAdapter)
        }
    }

    override fun getItemCount(): Int = 1
}