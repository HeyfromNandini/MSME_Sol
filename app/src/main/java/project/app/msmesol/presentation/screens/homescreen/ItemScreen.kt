package project.app.msmesol.presentation.screens.homescreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import project.app.msmesol.R
import project.app.msmesol.data.Groups
import project.app.msmesol.data.Tag
import project.app.msmesol.data.categories
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.presentation.screens.signup.OutlinedTextFieldBox
import project.app.msmesol.presentation.viewmodel.MainViewModel
import project.app.msmesol.ui.theme.appBackground
import project.app.msmesol.ui.theme.lightText
import project.app.msmesol.ui.theme.textColor

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    mainViewModel: MainViewModel
) {

    val searchText by mainViewModel.searchText.collectAsState()
    val tags by mainViewModel.tags.collectAsState()
    val isSearching by mainViewModel.isSearching.collectAsState()
    val seconds by mainViewModel.tagsSearch.collectAsState(initial = "")
    var isTyping by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues).clickable(interactionSource = interactionSource, indication = null, onClick = {
                focusManager.clearFocus()
                isTyping = false
            })

            ) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


                    AppName()


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    ) {
                        var search by remember { mutableStateOf("") }

                        TextField(
                            value = searchText,
                            onValueChange = {
                                mainViewModel.onSearchTextChange(it)
                                isTyping = true
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = textColor,
                                unfocusedIndicatorColor = textColor,
                                disabledIndicatorColor = textColor,
                                errorIndicatorColor = textColor,
                                textColor = textColor
                            ),
                            label = {
                                if (!isTyping && searchText == "") {
                                    AnimatedContent(
                                        targetState = seconds,
                                        transitionSpec = {
                                            (slideIntoContainer(
                                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                                animationSpec = tween(durationMillis = 500)
                                            ) + fadeIn()).togetherWith(
                                                slideOutOfContainer(
                                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                                    animationSpec = tween(durationMillis = 500)
                                                ) + fadeOut()
                                            )
                                        }, label = ""
                                    ) { targetCount ->
                                        androidx.compose.material.Text(
                                            text = "Search $targetCount",
                                            color = textColor,
                                            fontSize = 20.sp,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        )

                                    }
                                }
                            },
                            leadingIcon = {
                                androidx.compose.material.Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "Search",
                                    tint = lightText
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester)
                                .height(50.dp)
                                .padding(horizontal = 10.dp)
                                .shadow(50.dp, shape = RoundedCornerShape(10.dp)),
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Search
                            )
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        FilterCards(text = "All", icon = Icons.Default.Image)
                        FilterCards(text = "Domestic", icon = Icons.Default.Image)
                        FilterCards(text = "International", icon = Icons.Default.Image)

                    }
                    ItemsGrid(
                        groups = tags,
                        navController = navController,
                        mainViewModel = mainViewModel
                    )


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

@Composable
fun ItemsGrid(
    groups: List<Groups>,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(1000.dp)
    ) {
        items(groups) { group ->
            // Group Header
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Group Icon
                    group.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = textColor
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Group Name
                    Text(
                        text = group.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Tag List
                LazyRow(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    items(group.tags) { tag ->
                        TagCard(tag = tag, navController = navController, mainViewModel = mainViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun TagCard(
    tag: Tag,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    val context = LocalContext.current
    val datastore = UserDatastore(context)
    val userType = datastore.getTypeOfUser.collectAsState(initial = "")
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(150.dp)
            .clickable {
                if (userType.value == "Buyer") {
                    mainViewModel.itemSelected.value = tag
                    navController.navigate(Screens.ItemDetails.route)
                } else {
                    mainViewModel.itemSelected.value = tag
                    navController.navigate(Screens.DashBoard.route)
                }
            }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Tag Image
            AsyncImage(
                model = tag.image, // Placeholder
                contentDescription = tag.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxWidth()
            )

            // Tag Name
            Text(
                text = tag.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Placeholder for Price or Other Information
            Text(
                text = "$25.00",
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Placeholder for Rating
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

            // Bid Button
            Button(
                onClick = { /* Handle Bid Click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Bid now",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}



//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun ItemsGrid() {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
//        modifier = Modifier
//            .padding(16.dp)
//            .height(1000.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        items(8) { index ->
//
//            Box(modifier = Modifier) {
//
//
//                Card(
//                    modifier = Modifier
//                        .width(190.dp)
//
//                        .padding(horizontal = 5.dp, vertical = 10.dp)
//
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(vertical = 7.dp, horizontal = 6.dp),
//                        verticalArrangement = Arrangement.SpaceBetween
//
//                    ) {
//
//                        Image(
//                            painter = painterResource(id = R.drawable.onboarding1),
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        Text(
//                            text = "Handede hjnshujn uhcnuid hux",
//                            fontSize = 17.sp,
//                            fontWeight = FontWeight.Bold, color = Color.White
//                        )
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(
//                            text = "$25.00",
//                            fontSize = 16.sp,
//                        )
//
//
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 4.dp),
//                            horizontalArrangement = Arrangement.Start
//                        ) {
//                            Text(text = "4.5", fontSize = 15.sp)
//                            Spacer(modifier = Modifier.width(14.dp))
//                            LazyRow {
//                                items(count = 5) {
//
//
//                                    Icon(
//                                        imageVector = Icons.Default.Star,
//                                        contentDescription = "",
//                                        tint = Color.Yellow,
//                                        modifier = Modifier.size(16.dp)
//                                    )
//                                }
//
//                            }
//                        }
//                        Card(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 10.dp, vertical = 5.dp)
//                        ) {
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .background(color = Color.Black)
//                                    .padding(horizontal = 10.dp, vertical = 5.dp),
//                                horizontalArrangement = Arrangement.Center
//                            ) {
//                                Text(
//                                    text = "Bid now", fontSize = 14.sp, fontWeight = FontWeight.Bold
//                                )
//                            }
//                        }
//                    }
//
//
//                }
//            }
//        }
//    }
//}



