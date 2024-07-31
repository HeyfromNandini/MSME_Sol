package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.R
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox

@Composable
fun CartScreen(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppName()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {

            RowTitle(text1 = "Available Products")

            CartBidCard(name = "Organic Coffee Beans", bid = "$20", image = R.drawable.onboarding1)

            CartBidCard(name = "Fresh Apples", bid = "$15", image = R.drawable.onboarding1)

            CartBidCard(name = "Wooden Furniture Set", bid = "$100", image = R.drawable.onboarding1)

            RowTitle(text1 = "Track Bidding Activity")

            TrackBiddingCard()

            RowTitle(text1 = "Manage Payments & Logistics")

            PaymentCard()

            RowTitle(text1 = "Feedback Collection")

            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = "Leave Feedback",
                            fontSize = 16.sp,
                        )
                        var name by remember { mutableStateOf("") }
                        OutlinedTextFieldBox(
                            value = name,
                            onValueChange = { name = it },
                            label = "Share Feedback",
                            placeholder = "Feedback",
                            keyboardType = KeyboardType.Text
                        )

                        CartBidButton(text = "Process Payments")
                    }
                }
            }


        }
    }
}


@Composable
fun PaymentCard() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                CartBidButton(text = "Process Payments")
                CartBidButton(text = "Manage Logistics")

            }
        }
    }
}

@Composable
fun TrackBiddingCard() {

    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {

                Text(
                    text = "Your Bids ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Organic Coffee Beans : 25$(leading)",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                Text(
                    text = "Fresh Apples: $!8(OutBid) ",
                    fontSize = 15.sp,
                    lineHeight = 16.sp
                )

            }
        }
    }
}

@Composable
fun CartBidCard(name: String, bid: String, image: Int) {

    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Column(modifier = Modifier) {

                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row {
                        Text(
                            text = name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,

                            )
                    }

                    Row {
                        Text(
                            text = "Start bidding: $bid",
                            fontSize = 14.sp,
                            lineHeight = 16.sp
                        )
                    }

                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 2.dp)
            ) {
                CartBidButton(text = "Place Bids")

            }


        }

    }

}


@Composable
fun RowTitle(text1: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .padding(horizontal = 15.dp, vertical = 3.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = text1, fontSize = 20.sp)

    }
}


@Composable
fun CartBidButton(text: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()

            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()

                .background(color = Color.Black)
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text, fontSize = 12.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}
