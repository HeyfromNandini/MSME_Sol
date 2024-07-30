package project.app.msmesol.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import project.app.msmesol.screens.homescreen.HomeScreen
import project.app.msmesol.screens.homescreen.ItemScreen
import project.app.msmesol.screens.marketplace.MarketPlace
import project.app.msmesol.screens.onboarding.Screen1
import project.app.msmesol.screens.onboarding.Screen2
import project.app.msmesol.screens.onboarding.Screen3
import project.app.msmesol.screens.onboarding.SplashScreen
import project.app.msmesol.screens.profile.ProfileScreen
import project.app.msmesol.screens.signup.SignInScreen
import project.app.msmesol.screens.signup.SignUpScreen
import project.app.msmesol.screens.signup.SignUpChoice

@Composable
fun MainNavController(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
//        startDestination = Screens.SplashScreen.route,
        startDestination = Screens.ItemScreen.route,
    ) {

        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screens.Screen1.route) {
           Screen1(navController = navController)
        }
        composable(Screens.Screen2.route) {
            Screen2(navController = navController)
        }
        composable(Screens.Screen3.route) {
            Screen3(navController = navController)
        }


        composable(Screens.SignUpChoice.route) {
         SignUpChoice(navController = navController)
        }

        composable(Screens.SignUpScreen.route) {
            SignUpScreen(navController= navController)
        }

        composable(Screens.SignInScreen.route) {
            SignInScreen(navController= navController)
        }



        composable(Screens.HomeScreen.route) {
          HomeScreen(navHostController = navController, paddingValues = PaddingValues())
        }
        composable(Screens.ItemScreen.route) {
           ItemScreen(navController = navController, paddingValues = PaddingValues())
        }


        composable(Screens.MarketPlace.route) {
            MarketPlace(navHostController = navController)
        }

        composable(Screens.ProfileScreen.route) {
           ProfileScreen(navHostController = navController)
        }


    }
}