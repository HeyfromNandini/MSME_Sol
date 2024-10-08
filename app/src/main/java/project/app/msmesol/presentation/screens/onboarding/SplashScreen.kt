package project.app.msmesol.presentation.screens.onboarding

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import project.app.msmesol.R
import project.app.msmesol.data.UserInfo
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.appBackground
import project.app.msmesol.ui.theme.lightText
import project.app.msmesol.ui.theme.textColor

@Composable
fun SplashScreen(navController: NavController, profileList: List<UserInfo>?) {
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
                    Screens.MSMEMarketPlace.route
            } else Screens.SignUpScreen.route
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        if (userType.value == "Buyer") {
            Text(
                text = "Your own Market Adda",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("marketplace.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(220.dp)
                    .padding(vertical = 15.dp)
                    .clickable {
                        // Action when profile image clicked
                    })
        } else {
            Text(
                text = "Manage your business with ease and efficiency",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("marketplace.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1f,
                modifier = Modifier
                    .size(220.dp)
                    .padding(vertical = 15.dp)
                    .clickable {
                        // Action when profile image clicked
                    })
        }
    }
}