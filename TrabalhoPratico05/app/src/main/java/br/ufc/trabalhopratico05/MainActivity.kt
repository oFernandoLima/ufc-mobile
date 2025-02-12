package br.ufc.trabalhopratico05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import br.ufc.trabalhopratico05.data.AuthRepository
import br.ufc.trabalhopratico05.navigation.AppNavigation
import br.ufc.trabalhopratico05.ui.theme.TrabalhoPratico05Theme
import br.ufc.trabalhopratico05.ui.view.RegisterScreen
import br.ufc.trabalhopratico05.viewmodel.AuthViewModel
import br.ufc.trabalhopratico05.viewmodel.AuthViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authRepository = AuthRepository()

        val viewModelFactory = AuthViewModelFactory(authRepository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]

        setContent {
            AppNavigation(viewModel = viewModel)
        }
    }
}