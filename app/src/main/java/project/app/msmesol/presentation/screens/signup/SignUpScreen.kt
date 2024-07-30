package project.app.msmesol.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.ui.theme.OffWhite
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.SecondaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SecondaryBlue)
            .verticalScroll(rememberScrollState())
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

                    .background(color = OffWhite), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SignUp",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SignIn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = OffWhite)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = "Seller",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

               ContactInfoCard()
                BusinessDetailsCard()


            }
        }

    }

}





//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun OutlinedTextFieldBox(
//    value: String,
//    onValueChange: (String) -> Unit,
//    label: String,
//    placeholder: String,
//    keyboardType: KeyboardType
//) {
//    OutlinedTextField(
//        value = value,
//        onValueChange = { onValueChange(it) },
//        label = { Text(text = label, color = Color.Gray) },
//        placeholder = { Text(text = placeholder, fontSize = 14.sp) },
//        singleLine = true,
//        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
//        modifier = Modifier
//            .fillMaxWidth(0.9f)
//            .size(60.dp)
//    )
//}