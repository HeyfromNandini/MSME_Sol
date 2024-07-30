package project.app.msmesol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import project.app.msmesol.presentation.bottombar.BottomBarUI
import project.app.msmesol.presentation.navigation.MainNavController
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.ui.theme.MSMESolTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSMESolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomBarState = rememberSaveable { mutableStateOf(true) }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    navBackStackEntry?.destination?.route?.let { route ->
                        bottomBarState.value = when (route) {
                            Screens.HomeScreen.route,
                            Screens.MarketPlace.route,
                            Screens.ProfileScreen.route ->true
                            else -> false
                        }
                    }

                    Scaffold(
                        bottomBar = {
                            BottomBarUI(
                                navController = navController,
                                bottomBarState = bottomBarState
                            )
                        }
                    ) {

                        MainNavController(
                            it,
                            navController
                        )
                    }
                }
            }
        }
    }
}