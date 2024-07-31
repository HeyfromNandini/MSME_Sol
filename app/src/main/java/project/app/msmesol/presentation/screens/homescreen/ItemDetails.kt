package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.app.msmesol.R
import project.app.msmesol.presentation.utils.AnimatedCounter

@Composable
fun ItemDetails(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding1),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Product Name",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold, color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ",
                fontSize = 15.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, end = 10.dp)
                    .padding(vertical = 15.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$99.99 ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )


                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Qty.",
                        fontSize = 18.sp,

                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    var count by remember { mutableIntStateOf(100) }
                    Icon(imageVector = Icons.Default.Add, contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 5.dp)
                            .clickable {
                                count++
                            }

                    )
                    AnimatedCounter(count = count)
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(start = 5.dp)
                            .clickable {
                                count--
                            }

                    )
                }


            }

            Text(
                text = "Seller Information ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Text(
                text = "Seller Name",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {

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
                Spacer(modifier = Modifier.width(14.dp))
                Text(text = "(200 reviews)", fontSize = 15.sp)

            }

            CustomButtons(text = "Add to cart", color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            CustomButtons(text = "Back to Search Results", color = Color.Transparent)


        }
    }

}

@Composable
fun CustomButtons(text: String, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Gray)
                .background(color = color)
                .padding(horizontal = 5.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}



