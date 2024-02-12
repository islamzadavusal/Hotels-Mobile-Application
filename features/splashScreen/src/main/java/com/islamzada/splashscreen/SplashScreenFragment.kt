package com.islamzada.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.islamzada.splashscreen.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)

        val backgroundImg: ImageView = binding.imageViewSplash
        val slideAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide)
        backgroundImg.startAnimation(slideAnimation)

        Handler().postDelayed({
            val action = SplashScreenFragmentDirections.splashToLogin()
            findNavController().navigate(action)
        }, 3500)

        return binding.root
    }
}