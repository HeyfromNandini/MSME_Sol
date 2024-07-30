package project.app.msmesol.presentation.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.R
import project.app.msmesol.ui.theme.PrimaryBlue
import project.app.msmesol.ui.theme.PrimeSecBlue

@Composable
fun Screen1(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(color = PrimeSecBlue)
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding1),
                modifier = Modifier.size(400.dp),
                contentDescription = ""
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "MSME-SOl", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(340.dp))
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(
                    text = "Your Own MarketPlace ",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Your Own Marketplace for MSMEs & Retailers, say goodbye to chikchik and embrace the change",
                    fontSize = 17.sp,
                    textAlign = TextAlign.Justify
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top =15.dp, end = 40.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CircularProgressBar(
                        percentage = 0.33f,
                        navController = navController,
                        navigateTo = "screen2" // Replace with your actual navigation destination
                    )
                }
            }
        }



    }
}
