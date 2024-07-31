package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox


@Composable
fun BidScreen(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppName()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {
          PlaceABidForm()
            ContractDetailsForm()

            HighlightedRowTitle(text1 = "Account Aggregator Integration")

            Text(text = "Link Your Account", fontSize = 14.sp, modifier = Modifier.padding(start = 15.dp, top = 10.dp))

            CustomButtons(text = "Link Account", color = Color.Transparent)


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                BidButtons(text = "Submit Bid", color = Color.White, colortext= Color.Black )
                BidButtons(text = "Finalize Contracts", color =  Color.Black, colortext= Color.White )
            }

        }
    }
}


@Composable
fun BidButtons(text:String, color: Color, colortext:Color) {
    Card(
        modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(containerColor = color)

    ) {


        Box(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)

        ) {
            Row(
                modifier = Modifier.padding(horizontal = 2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = colortext,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
                )
            }
        }
    }
}


@Composable
fun ContractDetailsForm() {
    HighlightedRowTitle(text1 = "Contract Details")


    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp)) {

        var name by remember { mutableStateOf("") }

        FormFields(
            fieldname= "Logistics Information",
            value = name,
            onValueChange = { name = it },
            label = "Enter Logistics Details",
            keyboardType = KeyboardType.Text
        )

        var bid by remember { mutableStateOf("") }

        FormFields(
            fieldname= "Hedging Details",
            value = bid,
            onValueChange = { bid = it },
            label = "Enter Hedging details",
            keyboardType = KeyboardType.Text
        )

    }
}

@Composable
fun PlaceABidForm() {
    HighlightedRowTitle(text1 = "Place a Bid")


    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp)) {

        var name by remember { mutableStateOf("") }

        FormFields(
            fieldname= "Product Name",
            value = name,
            onValueChange = { name = it },
            label = "Enter name",
            keyboardType = KeyboardType.Text
        )

        var bid by remember { mutableStateOf("") }

        FormFields(
            fieldname= "Your Bid",
            value = bid,
            onValueChange = { bid = it },
            label = "Place Your Bid",
            keyboardType = KeyboardType.Number
        )
        var advance by remember { mutableStateOf("") }

        FormFields(
            fieldname= "Advance Payment",
            value = advance,
            onValueChange = { advance = it },
            label = "Your Advance Payment",
            keyboardType = KeyboardType.Number
        )
    }
}
@Composable
fun HighlightedRowTitle(text1: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .padding(horizontal = 10.dp,),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = text1, fontSize = 20.sp, fontWeight = FontWeight.Bold)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFields(
    fieldname:String,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,

    keyboardType: KeyboardType
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(horizontal = 5.dp)) {

        Text(text = fieldname, fontSize = 14.sp, modifier = Modifier.padding(start = 5.dp, top = 10.dp))

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            label = { Text(text = label, color = Color.Gray, fontSize = 12.sp) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp), // Adjust the text size of the input field
            modifier = Modifier.padding(horizontal = 5.dp)



        )
    }
}