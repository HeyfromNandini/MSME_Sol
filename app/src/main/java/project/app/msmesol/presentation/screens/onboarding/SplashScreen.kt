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

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val context = LocalContext.current
    val datastore = UserDatastore(context)
    val loginStatus = datastore.getLoginStatus.collectAsState(initial = false)
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
        navController.navigate(if (loginStatus.value) Screens.HomeScreen.route else Screens.SignUpScreen.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PrimeSecBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingBasket,
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .padding(vertical = 10.dp),
            tint = Color.White,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "MSME-Sol", fontSize = 45.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Your own Market Adda",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        )
    }
}