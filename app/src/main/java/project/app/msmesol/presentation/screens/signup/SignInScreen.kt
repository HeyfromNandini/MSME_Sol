package project.app.msmesol.presentation.screens.signup

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.jet.firestore.JetFirestore
import kotlinx.coroutines.launch
import project.app.msmesol.R
import project.app.msmesol.data.UserInfo
import project.app.msmesol.domain.UserDatastore
import project.app.msmesol.presentation.navigation.Screens
import project.app.msmesol.ui.theme.OffWhite
import project.app.msmesol.ui.theme.PrimaryBlue
import project.app.msmesol.ui.theme.PrimeSecBlue
import project.app.msmesol.ui.theme.SecondaryBlue
import project.app.msmesol.ui.theme.appBackground

@Composable
fun SignInScreen(navController: NavController) {
    var otp by remember { mutableStateOf("") }
    var vfId by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current
    val currentActivity = context as? Activity
    val isOtpSent = remember { mutableStateOf(false) }
    val isOtpVerified = remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }

    var profileList by remember {
        mutableStateOf<List<UserInfo>?>(null)
    }
    val coroutineScope = rememberCoroutineScope()

    JetFirestore(path = {
        collection("UserInfo")
    }, onRealtimeCollectionFetch = { value, _ ->
        try {
            profileList = value?.toObjects(UserInfo::class.java)
            println("ProfileList: $profileList")
        } catch (e: Exception) {
            println("Errorrrrrrr: ${e.message}")
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = appBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(color = appBackground)
            ) {

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clickable { navController.navigate(Screens.SignUpScreen.route) }

                        .background(color = SecondaryBlue),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SignUp",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(Screens.SignInScreen.route) },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SignIn",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }

            }


            Column(modifier = Modifier.fillMaxSize()) {


                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Your Identity, Our Responsibility",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    val compnotify by rememberLottieComposition(
                        spec = LottieCompositionSpec.Asset("signin.json")
                    )
                    LottieAnimation(
                        composition = compnotify,
                        iterations = Int.MAX_VALUE,
                        isPlaying = true,
                        contentScale = ContentScale.Crop,
                        speed = 1.45f,
                        modifier = Modifier
                            .size(220.dp)
                            .padding(vertical = 15.dp)
                    )


                    OutlinedTextFieldBox(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = "Enter phone number",
                        placeholder = "Phone Number",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )


                    OutlinedTextFieldBox(
                        value = otp,
                        onValueChange = { otp = it },
                        label = "Enter OTP",
                        placeholder = "One Time Password",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        enabled = isOtpSent.value
                    )

                    Button(
                        onClick = {
                            if (!isOtpSent.value) {
                                currentActivity?.let {
                                    val callbacks =
                                        object :
                                            PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                                                // Verification successful, automatically sign in the user
                                                signInWithPhoneAuthCredential(
                                                    credential,
                                                    auth
                                                )
                                            }

                                            override fun onVerificationFailed(exception: FirebaseException) {
                                                // Verification failed, show error message to the user
                                                Toast.makeText(
                                                    context,
                                                    "exception: ${exception.message}",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }

                                            override fun onCodeSent(
                                                verificationId: String,
                                                token: PhoneAuthProvider.ForceResendingToken,
                                            ) {
                                                vfId = vfId.copy(verificationId)
                                            }
                                        }


                                    val options = PhoneAuthOptions.newBuilder(auth)
                                        .setPhoneNumber("+91${phoneNumber}") // Phone number to verify
                                        .setTimeout(
                                            0L,
                                            java.util.concurrent.TimeUnit.SECONDS
                                        ) // Timeout and unit
                                        .setCallbacks(callbacks)
                                        .setActivity(currentActivity)// OnVerificationStateChangedCallbacks
                                        .build()
                                    PhoneAuthProvider.verifyPhoneNumber(options)
                                    isOtpSent.value = true
                                }
                            } else {
                                try {
                                    val credential =
                                        PhoneAuthProvider.getCredential(
                                            vfId.text,
                                            otp
                                        )
                                    FirebaseAuth.getInstance()
                                        .signInWithCredential(credential)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                // Sign in success
                                                val users = task.result?.user
                                                isOtpVerified.value = true
                                                if (profileList != null) {
                                                    val user = profileList?.find {
                                                        it.phoneNumber == phoneNumber
                                                    }
                                                    if (user != null) {
                                                        coroutineScope.launch {
                                                            val userDatastore =
                                                                UserDatastore(context)
                                                            userDatastore.saveLoginStatus(true)
                                                            userDatastore.saveName(user.name)
                                                            userDatastore.saveNumber(user.phoneNumber)
                                                            navController.navigate(Screens.HomeScreen.route)
                                                            Toast.makeText(
                                                                context,
                                                                "Welcome ${user.name}",
                                                                Toast.LENGTH_SHORT
                                                            )
                                                                .show()
                                                        }
                                                    } else {
                                                        navController.navigate(Screens.SignUpScreen.route)
                                                        Toast.makeText(
                                                            context,
                                                            "User not found, Please sign up",
                                                            Toast.LENGTH_SHORT
                                                        )
                                                            .show()
                                                    }
                                                } else {
                                                    navController.navigate(Screens.SignUpScreen.route)
                                                    Toast.makeText(
                                                        context,
                                                        "User not found, Please sign up",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                                println("Success")
                                                // Do something with user
                                            } else {
                                                isOtpVerified.value = false
                                                // Sign in failed
                                                val message = task.exception?.message
                                                // Handle error
                                                Toast.makeText(
                                                    context,
                                                    "Error: $message",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                } catch (e: Exception) {
                                    println("Error: ${e.message}")
                                    Toast.makeText(
                                        context,
                                        "Error: ${e.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(150.dp)
                    ) {
                        Text(
                            text = if (isOtpSent.value) "Login" else "Send OTP",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

        }
    }

}