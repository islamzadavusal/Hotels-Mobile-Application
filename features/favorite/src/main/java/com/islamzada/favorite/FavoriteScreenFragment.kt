package com.islamzada.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamzada.common.base.BaseFragment
import com.islamzada.favorite.databinding.FragmentFavoriteScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//@AndroidEntryPoint
//class FavoriteScreenFragment : BaseFragment<FragmentFavoriteScreenBinding, FavoriteViewModel>(FragmentFavoriteScreenBinding::inflate) {
//
//    private val viewModel : FavoriteViewModel by viewModels()
//
//    private lateinit var adapter : FavoriteListAdapter
//
//    override fun mViewModel(): FavoriteViewModel {
//        return viewModel
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initRvAdapter()
//
//        lifecycleScope.launch {
//            viewModel.getAll()
//
//        }
//
//        viewModel.data.observe(viewLifecycleOwner) {
//            adapter.setData(it?.hotels ?: listOf())
//        }
//
//    }
//
//    private fun initRvAdapter(){
//        adapter = FavoriteListAdapter()
//        binding.rvFav.layoutManager = LinearLayoutManager(context)
//        binding.rvFav.adapter = adapter
//    }
//
//}

