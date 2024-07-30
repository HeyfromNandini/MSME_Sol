package project.app.msmesol.screens.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.app.msmesol.R
import project.app.msmesol.screens.signup.OutlinedTextFieldBox

@Composable
fun ItemScreen(paddingValues: PaddingValues, navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


            AppName()


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                var search by remember { mutableStateOf("") }
                OutlinedTextFieldBox(
                    value = search,
                    onValueChange = { search = it },
                    label = "Search for Products",
                    placeholder = "Products",
                    keyboardType = KeyboardType.Text
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                FilterCards(text = "All", icon = Icons.Default.Image)
                FilterCards(text = "Domestic", icon = Icons.Default.Image)
                FilterCards(text = "International", icon = Icons.Default.Image)

            }





            ItemsGrid()


        }
    }


}


@Composable
fun FilterCards(text: String, icon: ImageVector) {

    Card(
        modifier = Modifier.padding(5.dp)

    ) {


        Box(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)

        ) {
            Row(
                modifier = Modifier.padding(horizontal = 2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = icon, contentDescription = "", modifier = Modifier.size(20.dp))
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
        modifier = Modifier
            .padding(16.dp)
            .height(1000.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(8) { index ->

            Box(modifier = Modifier) {


                Card(
                    modifier = Modifier
                        .width(190.dp)

                        .padding(horizontal = 5.dp, vertical = 10.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 7.dp, horizontal = 6.dp),
                        verticalArrangement = Arrangement.SpaceBetween

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.onboarding1),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "Handede hjnshujn uhcnuid hux",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold, color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$25.00",
                            fontSize = 16.sp,
                        )


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(text = "4.5", fontSize = 15.sp)
                            Spacer(modifier = Modifier.width(14.dp))
                            LazyRow {
                                items(count = 5) {


                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "",
                                        tint = Color.Yellow,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }

                            }
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
                                    .padding(horizontal = 10.dp, vertical = 5.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Bid now", fontSize = 14.sp, fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }


                }
            }
        }
    }
}
