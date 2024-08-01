package project.app.msmesol.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.screens.homescreen.BidScreen
import project.app.msmesol.presentation.screens.homescreen.CartScreen
import project.app.msmesol.presentation.screens.homescreen.HomeScreen
import project.app.msmesol.presentation.screens.homescreen.ItemScreen
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
import project.app.msmesol.presentation.screens.homescreen.ItemDetails
import project.app.msmesol.presentation.screens.homescreen.OrderScreen
import project.app.msmesol.presentation.screens.homescreen.PaymentDetails
import project.app.msmesol.presentation.screens.homescreen.SettingsScreen
import project.app.msmesol.presentation.screens.msme.DashBoard
import project.app.msmesol.presentation.screens.msme.MSMEMain
import project.app.msmesol.presentation.screens.msme.MSMEMarketPlace
import project.app.msmesol.presentation.screens.msme.OrderDetails
import project.app.msmesol.presentation.viewmodel.MainViewModel

@Composable
fun MainNavController(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    val context = LocalContext.current
    val tagsViewModel: AddTagsViewModel = hiltViewModel()
    val mainViewModel = hiltViewModel<MainViewModel>()

    NavHost(
        navController = navController,
//        startDestination = Screens.SplashScreen.route,
        startDestination = Screens.SplashScreen.route,
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
           ItemScreen(navController = navController, paddingValues = PaddingValues(), mainViewModel = mainViewModel)
        }
        composable(Screens.ItemDetails.route) {
            ItemDetails(
                navController = navController,
                paddingValues = PaddingValues(),
                mainViewModel = mainViewModel
            )
        }

        composable(Screens.BidScreen.route) {
            BidScreen(navController = navController, paddingValues = PaddingValues())
        }

        composable(Screens.OrderScreen.route) {
            OrderScreen(navController = navController, paddingValues = PaddingValues())
        }

        composable(Screens.PaymentDetails.route) {
            PaymentDetails(navController = navController, paddingValues = PaddingValues())
        }

        composable(Screens.SettingsScreen.route) {
           SettingsScreen(navController = navController, paddingValues = PaddingValues())
        }


        //MSME MarketPlace

        composable(Screens.MSMEMain.route) {
            MSMEMain(navController = navController, paddingValues = PaddingValues())
        }

        composable(Screens.MSMEMarketPlace.route) {
           MSMEMarketPlace(navController = navController, paddingValues = PaddingValues(), mainViewModel = mainViewModel)
        }

        composable(Screens.DashBoard.route) {
            DashBoard(navController = navController, paddingValues = PaddingValues())
        }

        composable(Screens.OrderDetails.route) {
            OrderDetails(navController = navController, paddingValues = PaddingValues())
        }





        composable(Screens.MarketPlace.route) {
            MarketPlace(navHostController = navController)
        }

        composable(Screens.ProfileScreen.route) {
           ProfileScreen(navController = navController)
        }

    }
}