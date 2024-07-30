package project.app.msmesol.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import project.app.msmesol.R
import project.app.msmesol.navigation.Screens
import project.app.msmesol.ui.theme.OffWhite
import project.app.msmesol.ui.theme.PrimaryBlue
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.SecondaryBlue

@Composable
fun SignInScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = OffWhite)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(color = SecondaryBlue)
        ) {

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clickable { navController.navigate(Screens.SignUpScreen.route) }

                    .background(color = SecondaryBlue), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SignUp",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screens.SignInScreen.route) },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SignIn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

        }


        Column(modifier = Modifier.fillMaxSize()) {


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Your Identity, Our Responsibility",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                val compnotify by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("signin.json")
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


                var phoneNumber by remember { mutableStateOf("") }
                var otp by remember { mutableStateOf("") }

                OutlinedTextFieldBox(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = "Enter phone number",
                    placeholder = "Phone Number",
                    keyboardType = KeyboardType.Number
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Row(modifier = Modifier.fillMaxWidth(0.5f)) {

                        OutlinedTextFieldBox(
                            value = otp,
                            onValueChange = { otp = it },
                            label = "Enter OTP",
                            placeholder = "OTP",
                            keyboardType = KeyboardType.Number
                        )
                    }
                    Button(onClick = { /* Handle OTP verification */ }) {
                        Text("Verify OTP")
                    }
                }


                MyButton(navController = navController, text = "SignIn", destination = "home")


            }
        }

    }

}