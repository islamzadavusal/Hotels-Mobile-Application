package com.islamzada.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamzada.favorite.databinding.FragmentFavoriteScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteScreenFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteScreenBinding
    private lateinit var adapter: FavoriteListAdapter
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvAdapter()
        observeViewModel()
    }

    private fun initRvAdapter() {
        adapter = FavoriteListAdapter()
        binding.rvFav.layoutManager = LinearLayoutManager(context)
        binding.rvFav.adapter = adapter
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.getFav().collect { favoriteList ->
                adapter.setData(favoriteList)
            }
        }
    }
}


