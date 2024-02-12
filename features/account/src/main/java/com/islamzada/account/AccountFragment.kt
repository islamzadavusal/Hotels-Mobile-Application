package com.islamzada.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.islamzada.account.databinding.FragmentAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAccountBinding.inflate(inflater)

        val currentUser = FirebaseAuth.getInstance().currentUser

        binding.userNameSetting.text = currentUser?.email.toString()

        binding.buttonEXT.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            val action = AccountFragmentDirections.accountToLogin()
            findNavController().navigate(action)

//            val action = MainFragmentDirections.MainToIn()
//            findNavController().navigate(action)

        }


        return binding.root
    }

}