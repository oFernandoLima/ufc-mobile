package br.ufc.trabalhopratico05.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ufc.trabalhopratico05.data.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository
): ViewModel() {
    var loginResult : ((Boolean) -> Unit)? = null
    var registerResult : ((Boolean) -> Unit)? = null

    fun register(
        email : String,
        password : String,
        name : String,
        onResult : (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val success = authRepository.registerUser(email, password, name)
            onResult(success)
        }
    }

    fun login(
        email : String,
        password : String,
        onResult : (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val success = authRepository.loginUser(email, password)
            onResult(success)
        }
    }

    fun resetPassword(
        email : String,
        onResult : (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val success = authRepository.resetPassword(email)
            onResult(success)
        }
    }

    fun getUserName(
        onResult : (String?) -> Unit
    ) {
        viewModelScope.launch {
            val name = authRepository.getUserName()
            onResult(name)
        }
    }

    fun loginWithGoogle(
        idToken: String,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val success = authRepository.loginWithGoogle(idToken)
            onResult(success)
        }
    }

    fun getGoogleSignInClient(context: Context): GoogleSignInClient {
        return authRepository.getGoogleSignInClient(context)
    }

    fun logout() {
        authRepository.logout()
    }

    fun isUserLogged(): Boolean {
        return authRepository.isUserLogged()
    }
}
