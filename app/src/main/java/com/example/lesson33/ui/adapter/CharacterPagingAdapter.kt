package com.example.lesson33.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson33.common.base.BaseDiffUtilItemCallback
import com.example.lesson33.data.remote.models.Character
import com.example.lesson33.databinding.ItemCharacterBinding

class CharacterPagingAdapter(
) : PagingDataAdapter<Character,CharacterPagingAdapter.CharacterViewHolder>(
        BaseDiffUtilItemCallback()
){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
                return CharacterViewHolder(
                        ItemCharacterBinding.inflate(
                                LayoutInflater.from(parent.context),
                                parent,
                                false))
        }

        override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
                getItem(position)?.let { holder.onBind(it) }
        }

        inner class CharacterViewHolder(
                private val binding: ItemCharacterBinding
        ) : RecyclerView.ViewHolder(binding.root){
                fun onBind(item: Character) {
                        binding.tvName.text = item.name
                        binding.tvStatus.text = item.status
                        Glide.with(binding.ivCharacter).load(item.image).into(binding.ivCharacter)
                }
        }
}
