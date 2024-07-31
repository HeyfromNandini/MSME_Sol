package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox


@Composable
fun PaymentDetails(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppName()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {
            PaymentMethod()
            BillingAddress()
            ShippingAddress()
            OrderSummary()

            CustomButtons(text = "Place Order", color = Color.Black)
            
            Spacer(modifier = Modifier.height(30.dp))


        }
    }
}



@Composable
fun OrderSummary() {

    HighlightedRowTitle(text1 = "Shipping Address")

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
           Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
               Column(
                   modifier = Modifier
                       .fillMaxWidth(0.6f)
                       .padding(horizontal = 10.dp, vertical = 10.dp)
               ) {

                   Text(
                       text = "Subtotal ",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "Shipping",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "Tax",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "Total",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )



               }
               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(horizontal = 10.dp, vertical = 10.dp)
               ) {

                   Text(
                       text = "$200.00",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "$12.00",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "$20.00",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )
                   Text(
                       text = "$235.00",
                       fontSize = 15.sp,
                       modifier = Modifier.padding(vertical = 5.dp)
                   )



               }
           }
        }
    }
}




@Composable
fun BillingAddress() {

    HighlightedRowTitle(text1 = "Billing Address")

    var fullName by remember { mutableStateOf("") }
    var addressLine1 by remember { mutableStateOf("") }
    var addressLine2 by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipCode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextFieldBox(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name",
            placeholder = "Full Name",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = addressLine1,
            onValueChange = { addressLine1 = it },
            label = "Address Line 1",
            placeholder = "Address Line 1",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = addressLine2,
            onValueChange = { addressLine2 = it },
            label = "Address Line 2",
            placeholder = "Address Line 2",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = city,
            onValueChange = { city = it },
            label = "City",
            placeholder = "City",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = state,
            onValueChange = { state = it },
            label = "State/Province",
            placeholder = "State/Province",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = "ZIP/Postal Code",
            placeholder = "ZIP/Postal Code",
            keyboardType = KeyboardType.Number
        )

        OutlinedTextFieldBox(
            value = country,
            onValueChange = { country = it },
            label = "Country",
            placeholder = "Country",
            keyboardType = KeyboardType.Text
        )
    }
}

@Composable
fun ShippingAddress() {

    HighlightedRowTitle(text1 = "Shipping Address")

    var fullName by remember { mutableStateOf("") }
    var addressLine1 by remember { mutableStateOf("") }
    var addressLine2 by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipCode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextFieldBox(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name",
            placeholder = "Full Name",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = addressLine1,
            onValueChange = { addressLine1 = it },
            label = "Address Line 1",
            placeholder = "Address Line 1",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = addressLine2,
            onValueChange = { addressLine2 = it },
            label = "Address Line 2",
            placeholder = "Address Line 2",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = city,
            onValueChange = { city = it },
            label = "City",
            placeholder = "City",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = state,
            onValueChange = { state = it },
            label = "State/Province",
            placeholder = "State/Province",
            keyboardType = KeyboardType.Text
        )

        OutlinedTextFieldBox(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = "ZIP/Postal Code",
            placeholder = "ZIP/Postal Code",
            keyboardType = KeyboardType.Number
        )

        OutlinedTextFieldBox(
            value = country,
            onValueChange = { country = it },
            label = "Country",
            placeholder = "Country",
            keyboardType = KeyboardType.Text
        )
    }
}


@Composable
fun PaymentMethod() {


    HighlightedRowTitle(text1 = "Payment Methods")

    var paymentmcq by remember { mutableStateOf("cold water") }
    MCQQUes(
        qu = "",
        op1 = "Online Wallet",
        op2 = "Credit/Debit Card",
        op3 = "Cash on Delivery",
        selected = paymentmcq,
        verticalpadding = 2.dp,
        onSelect = { paymentmcq = it }
    )
}

