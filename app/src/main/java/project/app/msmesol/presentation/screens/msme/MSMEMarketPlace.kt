package project.app.msmesol.presentation.screens.msme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import project.app.msmesol.presentation.screens.homescreen.AppName
import project.app.msmesol.presentation.screens.homescreen.FilterCards
import project.app.msmesol.presentation.screens.homescreen.ItemsGrid
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox


@Composable
fun MSMEMarketPlace(paddingValues: PaddingValues, navController: NavController){


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