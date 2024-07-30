package project.app.msmesol.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
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
import project.app.msmesol.presentation.screens.HomeScreen
import project.app.msmesol.presentation.screens.marketplace.MarketPlace
import project.app.msmesol.presentation.screens.onboarding.Screen1
import project.app.msmesol.presentation.screens.onboarding.Screen2
import project.app.msmesol.presentation.screens.onboarding.Screen3
import project.app.msmesol.presentation.screens.onboarding.SplashScreen
import project.app.msmesol.presentation.screens.profile.ProfileScreen
import project.app.msmesol.presentation.screens.signup.SignInScreen
import project.app.msmesol.presentation.screens.signup.SignUpScreen
import project.app.msmesol.presentation.screens.signup.SignUpChoice
import project.app.msmesol.presentation.utils.TagsScreen
import project.app.msmesol.presentation.viewmodel.AddTagsViewModel

@Composable
fun MainNavController(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    val context = LocalContext.current
    val tagsViewModel: AddTagsViewModel = hiltViewModel()

    NavHost(
        navController = navController,
//        startDestination = Screens.SplashScreen.route,
        startDestination = Screens.TagsScreen.route,
    ) {
        composable(Screens.TagsScreen.route) {
            TagsScreen(reportWasteViewModel = tagsViewModel)
        }

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
           ProfileScreen(navController = navController)
        }

    }
}