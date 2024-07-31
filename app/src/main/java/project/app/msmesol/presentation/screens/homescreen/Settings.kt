package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun SettingsScreen(paddingValues: PaddingValues, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        AppName()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start

        ) {


        }
    }
}