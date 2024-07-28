package project.app.msmesol.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.ui.theme.OffWhite
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.SecondaryBlue

@Composable
fun SignInScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = OffWhite)
    ) {
        Row (modifier = Modifier.fillMaxWidth().height(20.dp).background(color = SecondaryBlue)){

        }

        Row(modifier = Modifier
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)

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
                ,
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


        }

    }

}