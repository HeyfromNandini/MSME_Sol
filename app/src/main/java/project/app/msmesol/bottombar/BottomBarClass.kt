package project.app.msmesol.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import project.app.msmesol.navigation.Screens


sealed class BottomBarClass(val route: String?, val title: String?, val icon: ImageVector) {


    object Home : BottomBarClass(
        Screens.HomeScreen.route,
        "Home",
        Icons.Default.AccountBalance
    )

    object MarketPlace : BottomBarClass(
        Screens.MarketPlace.route,
        "MarketPlace",
        Icons.Default.AddShoppingCart
    )

    object Profile : BottomBarClass(
        Screens.ProfileScreen.route,
        "Profile",
        Icons.Default.Person
    )

}

val items = listOf(
    BottomBarClass.Home,
    BottomBarClass.MarketPlace,
    BottomBarClass.Profile,

    )