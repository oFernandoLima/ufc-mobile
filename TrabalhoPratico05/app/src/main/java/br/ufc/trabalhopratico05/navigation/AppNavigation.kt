package br.ufc.trabalhopratico05.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.ufc.trabalhopratico05.ui.view.ForgotPasswordScreen
import br.ufc.trabalhopratico05.ui.view.HomeScreen
import br.ufc.trabalhopratico05.ui.view.LoginScreen
import br.ufc.trabalhopratico05.ui.view.RegisterScreen
import br.ufc.trabalhopratico05.viewmodel.AuthViewModel

@Composable
fun AppNavigation(viewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // Tela de Login
        composable("login") {
            LoginScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }

        // Tela de Registro
        composable("register") {
            RegisterScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }

        // Tela Inicial
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }

        // Tela Esqueci Minha Senha
        composable("forgotPassword") {
            ForgotPasswordScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
    }
}
