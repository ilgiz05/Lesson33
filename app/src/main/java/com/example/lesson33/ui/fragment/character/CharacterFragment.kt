package com.example.lesson33.ui.fragment.character

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.lesson33.R
import com.example.lesson33.databinding.FragmentChracterBinding
import com.example.lesson33.ui.adapter.CharacterPagingAdapter
import com.example.lesson33.ui.adapter.paging.CommonLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : Fragment(R.layout.fragment_chracter) {

    private val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter : CharacterPagingAdapter = CharacterPagingAdapter()
    private lateinit var binding: FragmentChracterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChracterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }

    private fun setupRequests() {
        viewModel.getCharacters().observe(viewLifecycleOwner){
            lifecycleScope.launchWhenStarted {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun setupRecycler() = with(binding.characterRecycler){
        adapter = characterAdapter.withLoadStateFooter(CommonLoadStateAdapter{
            characterAdapter.refresh()
        })
        characterAdapter.addLoadStateListener { loadStates->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }
}



