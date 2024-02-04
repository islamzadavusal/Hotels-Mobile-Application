package com.islamzada.hotelsapplication.loginPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.islamzada.common.util.ErrorMessage
import com.islamzada.common.util.showMessage
import com.islamzada.hotelsapplication.MainActivity
import com.islamzada.hotelsapplication.R
import com.islamzada.hotelsapplication.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private var callbackManager: CallbackManager = CallbackManager.Factory.create()

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRegisterBinding.inflate(inflater)

        binding.textViewLoginNow.setOnClickListener {
            val action = RegisterFragmentDirections.registerToLogin()
            findNavController().navigate(action)
        }

        binding.facebookRegisterButton.setOnClickListener {
            loginFacebook()
        }

        binding.googleRegisterButton.setOnClickListener {
            loginGoogle()
        }

        binding.btnSignUp.setOnClickListener {
            register()
        }


        return binding.root
    }


    //Email &  Password
    private fun register() {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        // Check if any of the fields is empty
        if (email.isEmpty() || password.isEmpty()) {
            showMessage("ERROR", ErrorMessage.getEmptyFieldMessage())
            return
        }

        val firebaseAuth = Firebase.auth
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                openMain()
            }.addOnFailureListener { exception ->
                (exception as? FirebaseAuthException)?.errorCode?.let { errorCode ->
                    showMessage("ERROR", ErrorMessage.getLocalizedMessage(errorCode))
                }
            }
    }



    //Facebook
    fun loginFacebook() {
        //binding.loginButton.setReadPermissions(arrayListOf("email", "public_profile"))
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    handleFacebookAccessToken(loginResult.accessToken)
                }

                override fun onCancel() {
                    Log.d("TAG", "facebook:onCancel")
                }

                override fun onError(error: FacebookException) {
                    Log.d("TAG", "facebook:onError", error)
                }
            },
        )

        LoginManager.getInstance().logInWithReadPermissions(this, callbackManager, PERMISSIONS)
    }

    val PERMISSIONS = listOf("public_profile", "email")

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {

            // callbackManager.onActivityResult(requestCode, resultCode, data)

        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("TAG", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                    val user = auth.currentUser
                    openMain()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        requireContext(),
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    //updateUI(null)
                }
            }
    }


    //Google
    private lateinit var signInRequest: BeginSignInRequest

    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private lateinit var mGoogleSignInClient : GoogleSignInClient
    fun loginGoogle() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(getString(R.string.google_client_id))
            .requestIdToken(getString(R.string.google_client_id))
            .requestEmail().build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.google_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()

        val signInIntent = mGoogleSignInClient.signInIntent
        googleLauncher.launch(signInIntent)
    }

    private val googleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: androidx.activity.result.ActivityResult ->

        result.data?.let {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(it)
            if(result?.isSuccess == true) {
                val acct = result.signInAccount
                val authCode = acct!!.serverAuthCode
                val idToken = acct.idToken

                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                Firebase.auth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success")
                            val user = auth.currentUser
                            openMain()
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.exception)
                            //updateUI(null)
                        }
                    }
            }
        }
    }


    private fun openMain() {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        requireActivity().finish()
        startActivity(intent)
    }

}