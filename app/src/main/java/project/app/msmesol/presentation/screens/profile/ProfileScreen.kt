package project.app.msmesol.presentation.screens.profile

import android.content.Intent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import project.app.msmesol.MainActivity
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.screens.signup.DropdownField
import project.app.msmesol.screens.profile.ProfileImage

@OptIn(
    ExperimentalComposeUiApi::class
)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    val datastore = UserDatastore(context)
    val pfp = avatarsList.random().imageUrl
    val name = datastore.getName.collectAsState(initial = "")
    val myPhoneNumber = datastore.getNumber.collectAsState(initial = "")
    val type = datastore.getTypeOfUser.collectAsState(initial = "")
    println("Typeeeee: ${type.value}")
    val textColor = Color.White
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, bottom = 7.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ProfileImage(
                imageUrl = pfp,
                modifier = Modifier
                    .size(100.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 7.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = name.value ?: "User Name",
                color = textColor,
                fontSize = 20.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 7.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = myPhoneNumber.value ?: "Phone Number",
                color = textColor,
                fontSize = 12.sp,
                softWrap = true,
                modifier = Modifier.padding(end = 7.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column {

                RepeatedProfileInfo(
                    icon = Icons.Filled.EditNote,
                    text = "Edit Profile"
                )
                RepeatedProfileInfo(
                    icon = Icons.Filled.Notifications,
                    text = "Notifications"
                )
                val businessTypes = listOf("Seller", "Buyer")

                DropdownField(
                    options = businessTypes,
                    selectedOption = type.value ?: "Select business type",
                    onOptionSelected = {
                        coroutineScope.launch {
                            datastore.saveTypeOfUser(it)
                            val refresh = Intent(context, MainActivity::class.java)
                            refresh.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            ContextCompat.startActivity(context, refresh, null)
                        }
                    },
                    label = "Select business type"
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column {

                RepeatedProfileInfo(
                    icon = Icons.Filled.SupportAgent,
                    text = "Help and Support"
                )
                RepeatedProfileInfo(
                    icon = Icons.Filled.ContactPage,
                    text = "Contact Us"
                )
                RepeatedProfileInfo(
                    icon = Icons.Filled.PrivacyTip,
                    text = "Privacy Policy"
                )
            }

        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFD5065),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(35.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        ) {
            Text(
                text = "Logout",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp),
                maxLines = 1,
                softWrap = true
            )
        }

    }
}



@Composable
fun RepeatedProfileInfo(
    icon: ImageVector,
    text: String,
    onClick: (() -> Unit?)? = null
) {
    val textColor = Color.White
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick?.invoke()
            }
            .padding(start = 10.dp, top = 15.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = textColor,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 13.dp)
        )
        Text(
            text = text,
            color = textColor,
            fontSize = 15.sp,
        )
    }
}

data class Avatars(
    val imageUrl: String,
)

val avatarsList = listOf(
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/01863750-4c20-4835-a0da-ce7452c79ce2%201.png?alt=media&token=f14848bb-fa66-48da-b296-46bd1d51244e"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/0e3055a5-1136-4781-8c01-e7e99d21b275%201.png?alt=media&token=8bce6f6f-ed42-4949-ab0c-f5723824d632"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/10f9df6a-df96-4130-b485-753a50d01452%201.png?alt=media&token=2611424d-9d1f-404c-b87b-5d2c08a4c443"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/3b482224-ec18-4900-aaae-00ede26cd37c%201.png?alt=media&token=deb30a5a-6dc1-4a76-8b3d-d4575d898c28"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/57f85310-f68e-49e0-b351-87084c017159%201.png?alt=media&token=e06fe74a-864a-4725-9ae8-0839c5f12efc"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Emoji%20Updates%20for%20Apple’s%20iOS%2014_5%20Revealed%201.png?alt=media&token=d1ce455e-5b3b-423b-86d2-986d66eadd13"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Mask%20group.png?alt=media&token=91951a80-ad1e-4584-aad6-550f5164cbb8"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Memoji%20Ios%20iPhone%201.png?alt=media&token=bc2c8c66-da18-46b3-b232-7fc37a219045"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%201.png?alt=media&token=f1cc4cff-d003-4660-93f3-834575c43112"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2010.png?alt=media&token=036b11c3-7f55-4402-b8e5-b79f611cc355"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2011.png?alt=media&token=79758dc1-e808-425a-bb8a-0d3e0861661e"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2012.png?alt=media&token=8e7afdfa-1758-480c-9aa9-6d3366e1cacd"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2013.png?alt=media&token=8a45ed1b-8932-4281-8347-c83b9ff091ef"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2014.png?alt=media&token=dbf5057d-9508-4824-9e68-22fc45999d62"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2015.png?alt=media&token=94451744-4e13-41b6-8178-6d022ed8bdae"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2016.png?alt=media&token=62af9997-ec97-4870-8f3e-697c80351213"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2017.png?alt=media&token=48337f13-6e89-4415-abaa-195d260b8b99"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2018.png?alt=media&token=b8a0045d-1438-4524-a309-525baa651616"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2019.png?alt=media&token=dfd898e6-643f-4efa-b97d-f526522bb0a5"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%202.png?alt=media&token=da8fec78-02b7-4ae2-aa76-79fc767ebc79"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2020.png?alt=media&token=bdc23a2f-2ed3-4e5d-878f-3f05a56bfb01"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2021.png?alt=media&token=ffbc671c-f84a-41f0-b4bc-e7bf05063f37"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2022.png?alt=media&token=2bf9a9b8-a761-423b-93fd-107d296e0541"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2023.png?alt=media&token=29e02959-5022-4d7a-bff5-1faf96747706"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2024.png?alt=media&token=386d0168-a852-4abe-891b-b77f42f5a500"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2027.png?alt=media&token=77e840a2-4e15-40e8-be4f-a54834bf0ddd"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2029.png?alt=media&token=fa9fcd82-85ff-405a-b972-4d65513cf4ca"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%203.png?alt=media&token=9e59ff1f-f485-4acd-8c5c-d090d88eedc8"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%2031.png?alt=media&token=9ae7c7d7-0ed5-4ec0-87b3-130d0c4d13a9"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%204.png?alt=media&token=1bac7f5a-fc53-4610-b3fb-d106dc618875"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%205.png?alt=media&token=3ed61c3c-37ea-4330-9432-0b408898d600"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/Rectangle%206.png?alt=media&token=e647567f-7789-4422-a560-f676fee8af54"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/aedd1405-ec89-495b-a63a-163d040a94c2%201.png?alt=media&token=6446d272-f586-4c44-8ba0-e15f9e69f398"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/c778db1e-69f1-4e47-a5f9-90f508dea74b%201.png?alt=media&token=087c1f23-b6d0-4f16-92a7-5090e3a7e697"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/d6cc2e7e-f1b6-4273-8861-efc61e623738%201.png?alt=media&token=67a7b729-5433-45c8-b5f1-02518ca8f4b9"),
    Avatars("https://firebasestorage.googleapis.com/v0/b/ai-travel-manager.appspot.com/o/iPhone%20Memoji%20(1)%201.png?alt=media&token=9a2e95d3-fc4c-489f-8580-ce82f71932fd")
)