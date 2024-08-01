package project.app.msmesol.presentation.screens.onboarding

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import project.app.msmesol.R
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.appBackground
import project.app.msmesol.ui.theme.lightText
import project.app.msmesol.ui.theme.textColor

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val context = LocalContext.current
    val datastore = UserDatastore(context)
    val loginStatus = datastore.getLoginStatus.collectAsState(initial = false)
    val userType = datastore.getTypeOfUser.collectAsState(initial = "")
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1000L)
        navController.navigate(
            if (loginStatus.value) {
                if (userType.value == "Buyer") Screens.HomeScreen.route else
                    Screens.MSMEMain.route
            } else Screens.SignUpScreen.route
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = appBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingBasket,
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .padding(vertical = 10.dp),
            tint = textColor,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Xpress",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Your own Market Adda",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        )
    }
}