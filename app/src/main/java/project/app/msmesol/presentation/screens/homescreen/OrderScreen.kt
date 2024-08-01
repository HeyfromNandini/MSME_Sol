package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.presentation.navigation.Screens


@Composable
fun OrderScreen(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppName()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "Finalize Order", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }

            PersonalDetails()


            var paymentmcq by remember { mutableStateOf("cold water") }
            MCQQUes(
                qu = "Payment Method",
                op1 = "Online Wallet",
                op2 = "Credit/Debit Card",
                op3 = "Cash on Delivery",
                selected = paymentmcq,
                verticalpadding = 20.dp,
                onSelect = { paymentmcq = it }
            )
            
            CustomButtons(text = "Confirm", color = Color.Black) {
                navController.navigate(Screens.PaymentDetails.route)
            }


        }
    }
}


@Composable
fun PersonalDetails() {
    HighlightedRowTitle(text1 = "Place a Bid")


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
    ) {

        var name by remember { mutableStateOf("") }

        FormFields(
            fieldname = "Full Name",
            value = name,
            onValueChange = { name = it },
            label = "Enter your name",
            keyboardType = KeyboardType.Text
        )

        var bid by remember { mutableStateOf("") }

        FormFields(
            fieldname = "Phone Number",
            value = bid,
            onValueChange = { bid = it },
            label = "Enter your number",
            keyboardType = KeyboardType.Number
        )
        var advance by remember { mutableStateOf("") }

        FormFields(
            fieldname = "Email",
            value = advance,
            onValueChange = { advance = it },
            label = "Enter your email",
            keyboardType = KeyboardType.Text
        )
    }
}


@Composable
fun MCQQUes(
    qu: String,
    op1: String,
    op2: String,
    op3: String,
    verticalpadding: Dp,
    selected: String,
    onSelect: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp,)
            .padding(vertical = verticalpadding)
    ) {
        Text(
            text = qu,
            fontSize = 16.sp,
            modifier = Modifier
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op1,
                onClick = { onSelect(op1) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op1,
                fontSize = 14.sp,
                modifier = Modifier.weight(4f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op2,
                onClick = { onSelect(op2) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op2,
                fontSize = 14.sp,
                modifier = Modifier.weight(4f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op3,
                onClick = { onSelect(op3) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op3,
                fontSize = 14.sp,
                modifier = Modifier.weight(4f)
            )
        }
    }
}