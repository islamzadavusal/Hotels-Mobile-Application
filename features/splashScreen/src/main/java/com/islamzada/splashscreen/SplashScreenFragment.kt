package com.islamzada.splashscreen

import android.animation.Animator
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
import com.google.firebase.auth.FirebaseAuth
import com.islamzada.splashscreen.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)


        binding.imageViewSplash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                checkUserLoggedIn()
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }
        })

        return binding.root
    }

    fun checkUserLoggedIn() {
        val auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            // Eğer kullanıcı oturum açmamışsa, giriş fragmentini aç
            val action = SplashScreenFragmentDirections.splashToMain()
            findNavController().navigate(action)
        } else {
            // Eğer kullanıcı oturum açmışsa, ana ekrana geç
            val action = SplashScreenFragmentDirections.splashToLogin()
            findNavController().navigate(action)
        }
    }
}

//        val backgroundImg: ImageView = binding.imageViewSplash
//        val slideAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide)
//        backgroundImg.startAnimation(slideAnimation)
//
//        Handler().postDelayed({
//            val action = SplashScreenFragmentDirections.splashToLogin()
//            findNavController().navigate(action)
//        }, 3500)