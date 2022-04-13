package com.example.lesson33.ui.fragment.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.lesson33.R
import com.example.lesson33.databinding.FragmentLocationsBinding
import com.example.lesson33.ui.adapter.LocationPagingAdapter
import com.example.lesson33.ui.adapter.paging.CommonLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationsFragment : Fragment(R.layout.fragment_locations) {

    private lateinit var binding: FragmentLocationsBinding
    private val locationAdapter: LocationPagingAdapter = LocationPagingAdapter()
    private val viewModel: LocationViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }

    private fun setupRequests() {
        viewModel.getLocations().observe(viewLifecycleOwner) {
            lifecycleScope.launchWhenStarted {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun setupRecycler() = with(binding.locationRecycler) {
        adapter = locationAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            locationAdapter.retry()
            locationAdapter.refresh()
        })
        locationAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

}


