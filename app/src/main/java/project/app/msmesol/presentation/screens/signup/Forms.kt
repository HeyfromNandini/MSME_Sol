package project.app.msmesol.presentation.screens.signup

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import com.google.firebase.auth.PhoneAuthOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import project.app.msmesol.presentation.viewmodel.LoginViewModel
import project.app.msmesol.ui.theme.appBackground
import kotlin.math.log

@Composable
fun ContactInfo(
    section: String,
    isOtpSent: MutableState<Boolean>,
    isOtpVerified: MutableState<Boolean>,
    loginViewModel: LoginViewModel
) {

    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current
    val currentActivity = context as? Activity

    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Text(
            text = section,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        var name by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var businessAddress by remember { mutableStateOf("") }
        var websiteUrl by remember { mutableStateOf("") }
        var otp by remember { mutableStateOf("") }
        var vfId by remember {
            mutableStateOf(TextFieldValue(""))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(appBackground),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextFieldBox(
                value = loginViewModel.name.value,
                onValueChange = { loginViewModel.name.value = it },
                label = "Enter name",
                placeholder = "Name",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = loginViewModel.phoneNumber.value,
                onValueChange = { loginViewModel.phoneNumber.value = it },
                label = "Enter phone number",
                placeholder = "Phone Number",
                keyboardType = KeyboardType.Number
            )

            Button(onClick = {
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
                        .setPhoneNumber("+91${loginViewModel.phoneNumber.value}") // Phone number to verify
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
            }) {
                Text("Send OTP")
            }
            AnimatedVisibility(visible = isOtpSent.value) {
                Column {
                    OutlinedTextFieldBox(
                        value = otp,
                        onValueChange = { otp = it },
                        label = "Enter OTP",
                        placeholder = "OTP",
                        keyboardType = KeyboardType.Number
                    )
                    Button(onClick = {
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
                                        println("Success")
                                        Toast.makeText(
                                            context,
                                            "Success",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
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
                    }) {
                        Text("Verify OTP")
                    }

                    AnimatedVisibility(visible = isOtpVerified.value) {
                        Column {
                            OutlinedTextFieldBox(
                                value = loginViewModel.businessAddress.value,
                                onValueChange = { loginViewModel.businessAddress.value = it },
                                label = "Enter business address",
                                placeholder = "Business Address",
                                keyboardType = KeyboardType.Text
                            )

                            OutlinedTextFieldBox(
                                value = loginViewModel.websiteUrl.value,
                                onValueChange = { loginViewModel.websiteUrl.value = it },
                                label = "Enter website URL",
                                placeholder = "Website URL (optional)",
                                keyboardType = KeyboardType.Uri
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ContactInfoCard(
    isOtpSent: MutableState<Boolean>,
    isOtpVerified: MutableState<Boolean>,
    loginViewModel: LoginViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = appBackground),
    ) {
        ContactInfo(
            section = "Contact Info",
            isOtpSent = isOtpSent,
            isOtpVerified = isOtpVerified,
            loginViewModel = loginViewModel
        )
    }
}

@Composable
fun BusinessDetails(section: String, loginViewModel: LoginViewModel) {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Text(
            text = section,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        val businessTypes = listOf("Seller", "Buyer")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextFieldBox(
                value = loginViewModel.businessName.value,
                onValueChange = { loginViewModel.businessName.value = it },
                label = "Enter business name",
                placeholder = "Business Name",
                keyboardType = KeyboardType.Text
            )

            DropdownField(
                options = businessTypes,
                selectedOption = loginViewModel.businessType.value,
                onOptionSelected = { loginViewModel.businessType.value = it },
                label = "Select business type"
            )

            OutlinedTextFieldBox(
                value = loginViewModel.registrationNumber.value,
                onValueChange = { loginViewModel.registrationNumber.value = it },
                label = "Enter registration number",
                placeholder = "Registration Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = loginViewModel.yearOfEstablishment.value,
                onValueChange = { loginViewModel.yearOfEstablishment.value = it },
                label = "Enter year of establishment",
                placeholder = "Year of Establishment",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = loginViewModel.companySize.value,
                onValueChange = { loginViewModel.companySize.value = it },
                label = "Enter company size",
                placeholder = "Company Size",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = loginViewModel.annualRevenue.value,
                onValueChange = { loginViewModel.annualRevenue.value = it },
                label = "Enter annual revenue",
                placeholder = "Annual Revenue",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = loginViewModel.gstinNumber.value,
                onValueChange = { loginViewModel.gstinNumber.value = it },
                label = "Enter GSTIN number",
                placeholder = "GSTIN Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = loginViewModel.panNumber.value,
                onValueChange = { loginViewModel.panNumber.value = it },
                label = "Enter PAN number",
                placeholder = "PAN Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = loginViewModel.udyamNumber.value,
                onValueChange = { loginViewModel.udyamNumber.value = it },
                label = "Enter Udyam number",
                placeholder = "Udyam Number",
                keyboardType = KeyboardType.Text
            )
        }
    }
}


@Composable
fun BusinessDetailsCard(loginViewModel: LoginViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = appBackground),
    ) {
        BusinessDetails(section = "Business Details", loginViewModel = loginViewModel)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    label: String
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(selectedOption) }

    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            label = { Text(text = label, color = Color.Gray) },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = option
                    onOptionSelected(option)
                }) {
                    Text(text = option)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadIdentityProof(section: String, loginViewModel: LoginViewModel) {
    val context = LocalContext.current
    var selectedIdentityProof by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var fileUri by remember { mutableStateOf<Uri?>(null) }
    val identityProofOptions: List<IdentityProofOption> = IdentityProofOption.values().toList()

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        fileUri = uri
    }

    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Text(
            text = section,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }) {
                OutlinedTextField(
                    value = loginViewModel.selectedIdentityProof.value,
                    onValueChange = {},
                    label = { Text(text = "Select identity proof", color = Color.Gray) },
                    readOnly = true,
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    identityProofOptions.forEach { option ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            loginViewModel.selectedIdentityProof.value = option.displayName
                        }) {
                            Text(text = option.displayName)
                        }
                    }
                }
            }

            Button(
                onClick = {
                    fileUri?.let {
                        loginViewModel.uploadFile(it, loginViewModel.name.value )
                    } ?: openFilePicker(context, filePickerLauncher)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Upload File")
            }

            fileUri?.let {
                Text("Selected file: ${it.path}", color = Color.White)
            }
        }
    }
}

private fun openFilePicker(context: Context, launcher: ActivityResultLauncher<Array<String>>) {
    val mimeTypes = arrayOf("application/pdf")
    launcher.launch(mimeTypes)
}

@Composable
fun UploadIdentityProofCard(loginViewModel: LoginViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = appBackground)
    ) {
        UploadIdentityProof(section = "Upload Identity Proof", loginViewModel = loginViewModel)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldBox(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 10.dp)
    ) {

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            label = { Text(text = label, color = Color.Gray, fontSize = 15.sp) },
            placeholder = { Text(text = placeholder, fontSize = 10.sp) },
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 15.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.padding(horizontal = 5.dp),
            enabled = enabled
            )
    }
}


fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential, auth: FirebaseAuth) {
    auth.signInWithCredential(credential)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                println("Successful")
            } else {
                println("Failed")
            }
        }
}

enum class IdentityProofOption(val displayName: String) {
    AADHARCARD("Aadhar Card"),
    PASSPORT("Passport"),
    DRIVING_LICENSE("Driving License"),
    VOTER_ID("Voter ID");

    companion object {
        fun fromDisplayName(displayName: String): IdentityProofOption? {
            return values().find { it.displayName == displayName }
        }
    }
}

