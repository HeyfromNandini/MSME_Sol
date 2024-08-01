package project.app.msmesol.presentation.screens.msme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import project.app.msmesol.presentation.screens.homescreen.AppName
import project.app.msmesol.presentation.screens.homescreen.FilterCards
import project.app.msmesol.presentation.screens.homescreen.HighlightedRowTitle
import project.app.msmesol.presentation.screens.homescreen.ItemsGrid
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox


@Composable
fun OrderDetails(paddingValues: PaddingValues, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            AppName()

            HighlightedRowTitle(text1 = "Market Connect")

            DoubleLineCard(text1 = "Total Sales:", text2 = "$12.345.00")
            DoubleLineCard(text1 = "Pending Order", text2 = "24")
            DoubleLineCard(text1 = "Upcoming Bids", text2 = "5")
            FourLineCard(
                text1 = "Recent Activity",
                text2 = "Order #12345 Shipped",
                text3 = "Bid placed on item #6782",
                text4 = "Received payment for order #7903 "
            )
            TransactionCard(text1 = "Transaction Insights")



            DoubleLineCard(text1 = "Account Aggregation", text2 = "75%")

            FourLineCard(
                text1 = "Support Resources",
                text2 = "Onboarding Guide",
                text3 = "Marketplace Guidelines",
                text4 = "Customer Support"
            )

        }
    }


}

@Composable
fun DoubleLineCard(text1: String, text2: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {

                Text(
                    text = text1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = text2,
                    fontSize = 15.sp,
                    lineHeight = 16.sp
                )

            }
        }
    }


}


@Composable
fun MarketGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
        modifier = Modifier
            .padding(10.dp)
            .height(140.dp)
    ) {
        items(4) { index ->

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {


                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Image, contentDescription = "")
                        Text(
                            text = "Item ", fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionCard(text1: String, ) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {

                Text(
                    text = text1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {

                        Text(
                            text = "Subtotal ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                        Text(
                            text = "$8234.56",
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
                            text = "International",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                        Text(
                            text = "$4111.11",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )


                    }
                }

            }
        }
    }


}


@Composable
fun FourLineCard(text1: String, text2: String, text3: String, text4: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {

                Text(
                    text = text1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = text2,
                    fontSize = 15.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = text3,
                    fontSize = 15.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = text4,
                    fontSize = 15.sp,
                    lineHeight = 16.sp
                )

            }
        }
    }


}