package project.app.msmesol.presentation.navigation


sealed class Screens(val route: String) {

    object SplashScreen : Screens("splash")
    object Screen1 : Screens("screen1")
    object Screen2 : Screens("screen2")
    object Screen3 : Screens("screen3")

    object SignUpChoice : Screens("signupchoice")
    object SignUpScreen : Screens("signupscreen")
    object SignInScreen : Screens("signinscreen")


    object HomeScreen : Screens("home")
    object ItemScreen : Screens("items")
    object ItemDetails : Screens("itemdetails")


    object CartScreen : Screens("cart")
    object BidScreen : Screens("bid")
    object OrderScreen : Screens("order")
    object PaymentDetails : Screens("paymentdetails")
    object SettingsScreen : Screens("settings")



    //MSME Screens
    object MSMEMain : Screens("msmemain")
    object MSMEMarketPlace : Screens("msmemarket")
    object DashBoard : Screens("dashboard")
    object OrderDetails : Screens("orderdetails")


    object MarketPlace : Screens("marketplace")
    object ProfileScreen : Screens("profile")
    object TagsScreen : Screens("profile")
}

