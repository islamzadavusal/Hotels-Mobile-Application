package com.islamzada.hotelsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.islamzada.hotelsapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigationApp) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavBar, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == com.islamzada.login.R.id.loginFragment ||
                destination.id == com.islamzada.login.R.id.registerFragment ||
                destination.id == com.islamzada.splashscreen.R.id.splashScreenFragment
            )
            {
                binding.bottomNavBar.visibility = View.GONE

            } else {
                binding.bottomNavBar.visibility = View.VISIBLE
            }
    }
    }
}

//        auth = FirebaseAuth.getInstance()
//
//        if (auth.currentUser == null) {
//            // Eğer kullanıcı oturum açmamışsa, giriş fragmentini aç
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.navigationApp, MainScreenFragment())
//                .commit()
//        } else {
//            // Eğer kullanıcı oturum açmışsa, ana ekrana geç
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.navigationApp, LoginFragment())
//                .commit()
//        }