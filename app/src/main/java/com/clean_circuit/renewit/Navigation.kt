package com.clean_circuit.renewit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clean_circuit.renewit.Screens.ForgotPasswordScreen
import com.clean_circuit.renewit.Screens.LoginScreen
import com.clean_circuit.renewit.Screens.SignUpScreen


sealed class Screen(val route: String) {
    object TeaserOne : Screen("TeaserOne")
    object TeaserTwo : Screen("TeaserTwo")
    object SignUp : Screen("SignUp")
    object SignIn : Screen("SignIn")
    object ForgotPassword : Screen("ForgotPassword")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TeaserOne.route) {
        composable(Screen.TeaserOne.route) {
            RenewItScreen(onClickTeaserOne = { navController.navigate(Screen.TeaserTwo.route) })
        }
        composable(Screen.TeaserTwo.route) {
            RenewItScreenTwo(onClickTeaserTwo = { navController.navigate(Screen.SignUp.route) })
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(
                onClickSignup = { navController.navigate(Screen.SignIn.route) },
                onClickSignIn = { navController.navigate(Screen.SignIn.route) }
            )
        }
        composable(Screen.SignIn.route) {
            LoginScreen(
                onClickSignup = { navController.navigate(Screen.SignUp.route) },
                onClickForgotPassword = { navController.navigate(Screen.ForgotPassword.route) }
            )
        }

        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(
                onClickLogin = { navController.navigate(Screen.SignIn.route) }

            )
        }
    }
}
