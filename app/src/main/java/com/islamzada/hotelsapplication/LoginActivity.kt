package com.islamzada.hotelsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.islamzada.hotelsapplication.loginPage.LoginFragment
import com.islamzada.hotelsapplication.loginPage.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            // Eğer kullanıcı oturum açmamışsa, giriş fragmentini aç
            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostLogin, LoginFragment())
                .commit()
        } else {
            // Eğer kullanıcı oturum açmışsa, ana ekrana geç
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    // Giriş (Login) fragmentine geçiş yapmak için
    fun loginToRegister() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navigationApp, RegisterFragment())
            .commit()
    }

    // Kayıt (Register) fragmentine geçiş yapmak için
    fun registerToLogin() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navigationApp, LoginFragment())
            .commit()
    }

}