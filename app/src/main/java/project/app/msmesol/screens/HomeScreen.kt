package project.app.msmesol.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import project.app.msmesol.R
import project.app.msmesol.bottombar.items
import project.app.msmesol.screens.signup.OutlinedTextFieldBox
import java.text.Bidi

@Composable
fun HomeScreen(navHostController: NavHostController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AddShoppingCart,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Xpress", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            }



            SearchBar(text = "Search for Products")

            FeatureCard()
            RowHeadings(text1 = "Special Offers", text2 = "View all products")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {

                BidCards(text = "Tropical fruits", image = R.drawable.onboarding1)
                BidCards(text = "Sweet Watermelon", image = R.drawable.onboarding1)
            }

            RowHeadings(text1 = "Product", text2 = "Explore all")
        }

        item {

            GridExample()
        }


    }
}


@Composable
fun RowHeadings(text1: String, text2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = text1, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = text2, fontSize = 16.sp)
    }
}

@Composable
fun FeatureCard() {

    Row(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp, bottom = 10.dp)
                    ) {
                        Row {
                            Text(text = "Feature", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Row {
                        Text(text = "Fresh produce available to bidding", fontSize = 16.sp)
                    }

                }
                Column(modifier = Modifier.fillMaxWidth()) {

                    Image(
                        painter = painterResource(id = R.drawable.onboarding1),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .padding(horizontal = 15.dp)
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(57.8.dp),
//            elevation = 30.dp
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxSize(),
//                    .background(color = NeonYellow),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Handle search icon click */ },
                    modifier = Modifier.size(40.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }

                var text by remember { mutableStateOf("") }

                TextField(
                    value = text,
                    onValueChange = { text = it }, // Enable value change
                    label = { Text("Search for your Products") }, // Use a lambda for label
                    placeholder = { Text("Products") }, // Use a lambda for placeholder
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) // Corrected keyboardType usage
                )
            }
        }
    }
}

@Composable
fun BidCards(image: Int, text: String) {


    Box(modifier = Modifier) {


        Card(
            modifier = Modifier
                .width(200.dp)
                .height(250.dp)
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ) {

                Icon(imageVector = Icons.Default.Favorite, contentDescription = "")

                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = text, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "Rate", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(14.dp))
                    Text(text = "Prod capacity", fontSize = 12.sp)
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Black)
                            .padding(horizontal = 5.dp, vertical = 5.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Bid now", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }


        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
        modifier = Modifier
            .padding(16.dp)
            .height(400.dp)
    ) {
        items(8) { index ->

            Card (  modifier = Modifier
                .padding(8.dp)

                .fillMaxSize()){


                Box(
                    modifier = Modifier
                        .padding(8.dp)

                        .fillMaxSize()
                ) {
                    Text(
                        text = "Item ",
                        style = MaterialTheme.typography.bodyLarge,
                        color = White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
