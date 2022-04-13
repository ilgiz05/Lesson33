package com.example.lesson33.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson33.common.base.BaseDiffUtilItemCallback
import com.example.lesson33.data.remote.models.Location
import com.example.lesson33.databinding.ItemLocationsBinding

class LocationPagingAdapter(
) : PagingDataAdapter<Location, LocationPagingAdapter.LocationViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }


    inner class LocationViewHolder(
        private val binding: ItemLocationsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Location) {
            binding.tvName.text = item.name
            binding.tvLocation.text = item.type
        }
    }

}