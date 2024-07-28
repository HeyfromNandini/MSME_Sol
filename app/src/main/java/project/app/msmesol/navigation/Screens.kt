package project.app.msmesol.navigation


sealed class Screens(val route: String){

    object SplashScreen: Screens("splash")
    object Screen1:Screens("screen1")
    object Screen2:Screens("screen2")
    object Screen3: Screens("screen3")

    object SignUpChoice: Screens("signupchoice")
    object SignUpScreen: Screens("signupscreen")
    object SignInScreen: Screens("signinscreen")



    object HomeScreen: Screens("home")
    object MarketPlace: Screens("marketplace")
    object ProfileScreen: Screens("profile")
}

