package com.example.tvapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvapp.core.BaseViewHolder
import com.example.tvapp.data.model.Tv
import com.example.tvapp.databinding.TvItemBinding

class TvAdapter(private val tvList: List<Tv>, private val itemClickListener: OnTvClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTvClickListener {
        fun onMovieClick(tv: Tv)
    }


    private inner class TvViewHolder(val binding: TvItemBinding, val context: Context) :
        BaseViewHolder<Tv>(binding.root) {
        override fun bind(item: Tv) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500"+item.poster_path)
                .centerCrop().into(binding.imgTvItem)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = TvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val holder = TvViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is TvViewHolder -> holder.bind(tvList[position])
        }
    }

    override fun getItemCount(): Int = tvList.size
}