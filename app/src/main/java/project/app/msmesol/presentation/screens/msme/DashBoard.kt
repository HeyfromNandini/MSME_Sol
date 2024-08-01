package project.app.msmesol.presentation.screens.msme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import project.app.msmesol.R
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.presentation.screens.homescreen.CustomButtons
import project.app.msmesol.presentation.utils.AnimatedCounter
import project.app.msmesol.presentation.viewmodel.MainViewModel


@Composable
fun DashBoard(
    paddingValues: PaddingValues,
    navController: NavController,
    mainViewModel: MainViewModel
) {

    Column(modifier = Modifier.fillMaxSize()) {

        mainViewModel.itemSelected.value.let { item ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalAlignment = Alignment.Start

            ) {
                AsyncImage(
                    model = item?.image ?: "",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().size(300.dp)
                )
                Text(
                    text = "View Contract bidding",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Manage product listings",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Account Aggregation Support",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 5.dp)
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 30.dp)
                )



                Text(
                    text = "Process advance payments",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DashBoardCards(name = "Manage Logistics", icon = Icons.Default.ShoppingCart)
                    DashBoardCards(name = "Contact Us", icon = Icons.Default.Call)
                    DashBoardCards(name = "Track Package", icon = Icons.Default.Backpack) {
                        navController.navigate(Screens.OrderDetails.route)
                    }
                }


            }
        }
    }

}


@Composable
fun DashBoardCards(name: String, icon: ImageVector, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(85.dp)
            .clickable {
                onClick()
            }

    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon, contentDescription = "")
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = name, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White, fontSize = 12.sp, lineHeight = 14.sp,
                modifier = Modifier.padding(2.dp), textAlign = TextAlign.Center
            )
        }
    }

}