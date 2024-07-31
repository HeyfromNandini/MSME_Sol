package project.app.msmesol.presentation.screens.msme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import project.app.msmesol.presentation.screens.homescreen.CustomButtons
import project.app.msmesol.presentation.screens.signup.MyButton
import project.app.msmesol.ui.theme.OffWhite
import project.app.msmesol.ui.theme.PrimaryBlue


@Composable
fun MSMEMain(paddingValues: PaddingValues, navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding( horizontal = 20.dp)
                .padding(top = 100.dp,), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "MSME",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(vertical = 10.dp)
            )

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

//            MyButton(navController = navController, text = "Buyer", destination = "signupscreen")
            Spacer(modifier = Modifier.height(40.dp))


            CustomButtons(text = "Get Started", color = Color.Black)
        }

    }
}