package com.islamzada.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamzada.common.base.BaseFragment
import com.islamzada.hotels.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreenFragment : BaseFragment<FragmentMainScreenBinding, MainScreenViewModel>(FragmentMainScreenBinding::inflate) {

    private val viewModel : MainScreenViewModel by viewModels()

    private lateinit var adapter : MainHotelsListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvAdapter()

        lifecycleScope.launch {
            viewModel.getHotels()

        }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.setData(it?.hotels ?: listOf())
        }

    }


    override fun mViewModel(): MainScreenViewModel {
        return viewModel
    }

    private fun initRvAdapter(){
        adapter = MainHotelsListAdapter()
        binding.rvHt.layoutManager = LinearLayoutManager(context)
        binding.rvHt.adapter = adapter
    }

}