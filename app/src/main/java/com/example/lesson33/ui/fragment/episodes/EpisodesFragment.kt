package com.example.lesson33.ui.fragment.episodes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.lesson33.R
import com.example.lesson33.databinding.FragmentEpisodesBinding
import com.example.lesson33.ui.adapter.EpisodePagingAdapter
import com.example.lesson33.ui.adapter.paging.CommonLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : Fragment(R.layout.fragment_episodes) {

    private lateinit var binding: FragmentEpisodesBinding
    private val episodesAdapter : EpisodePagingAdapter = EpisodePagingAdapter()
    private val viewModel: EpisodeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }


    private fun setupRecycler() {
        viewModel.getEpisodes().observe(viewLifecycleOwner){
            lifecycleScope.launchWhenStarted {
                episodesAdapter.submitData(it)
            }
        }
    }

    private fun setupRequests()  = with(binding.episodesRecycler){
        adapter = episodesAdapter.withLoadStateFooter(CommonLoadStateAdapter{
            episodesAdapter.retry()
            episodesAdapter.refresh()
        })
        episodesAdapter.addLoadStateListener { loadStates->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }
}