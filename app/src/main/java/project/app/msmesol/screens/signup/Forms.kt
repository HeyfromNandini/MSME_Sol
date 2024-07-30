package project.app.msmesol.screens.signup

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import project.app.msmesol.ui.theme.SecondaryBlue

@Composable
fun ContactInfo(section: String) {
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextFieldBox(
                value = name,
                onValueChange = { name = it },
                label = "Enter name",
                placeholder = "Name",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Enter phone number",
                placeholder = "Phone Number",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = otp,
                onValueChange = { otp = it },
                label = "Enter OTP",
                placeholder = "OTP",
                keyboardType = KeyboardType.Number
            )
            Button(onClick = { /* Handle OTP verification */ }) {
                Text("Verify OTP")
            }

            OutlinedTextFieldBox(
                value = businessAddress,
                onValueChange = { businessAddress = it },
                label = "Enter business address",
                placeholder = "Business Address",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = websiteUrl,
                onValueChange = { websiteUrl = it },
                label = "Enter website URL",
                placeholder = "Website URL (optional)",
                keyboardType = KeyboardType.Uri
            )
        }
    }
}

@Composable
fun ContactInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = SecondaryBlue),
    ) {
        ContactInfo(section = "Contact Info")
    }
}

@Composable
fun BusinessDetails(section: String) {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
        Text(
            text = section,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        var businessName by remember { mutableStateOf("") }
        var businessType by remember { mutableStateOf("") }
        var registrationNumber by remember { mutableStateOf("") }
        var yearOfEstablishment by remember { mutableStateOf("") }
        var companySize by remember { mutableStateOf("") }
        var annualRevenue by remember { mutableStateOf("") }
        var gstinNumber by remember { mutableStateOf("") }
        var panNumber by remember { mutableStateOf("") }
        var udyamNumber by remember { mutableStateOf("") }

        val businessTypes = listOf("MSME", "Retailer", "Seller", "Electronics")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextFieldBox(
                value = businessName,
                onValueChange = { businessName = it },
                label = "Enter business name",
                placeholder = "Business Name",
                keyboardType = KeyboardType.Text
            )

            DropdownField(
                options = businessTypes,
                selectedOption = businessType,
                onOptionSelected = { businessType = it },
                label = "Select business type"
            )

            OutlinedTextFieldBox(
                value = registrationNumber,
                onValueChange = { registrationNumber = it },
                label = "Enter registration number",
                placeholder = "Registration Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = yearOfEstablishment,
                onValueChange = { yearOfEstablishment = it },
                label = "Enter year of establishment",
                placeholder = "Year of Establishment",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = companySize,
                onValueChange = { companySize = it },
                label = "Enter company size",
                placeholder = "Company Size",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = annualRevenue,
                onValueChange = { annualRevenue = it },
                label = "Enter annual revenue",
                placeholder = "Annual Revenue",
                keyboardType = KeyboardType.Number
            )

            OutlinedTextFieldBox(
                value = gstinNumber,
                onValueChange = { gstinNumber = it },
                label = "Enter GSTIN number",
                placeholder = "GSTIN Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = panNumber,
                onValueChange = { panNumber = it },
                label = "Enter PAN number",
                placeholder = "PAN Number",
                keyboardType = KeyboardType.Text
            )

            OutlinedTextFieldBox(
                value = udyamNumber,
                onValueChange = { udyamNumber = it },
                label = "Enter Udyam number",
                placeholder = "Udyam Number",
                keyboardType = KeyboardType.Text
            )
        }
    }
}


@Composable
fun BusinessDetailsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = SecondaryBlue),
    ) {
        BusinessDetails(section = "Business Details")
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

    Column(modifier = Modifier.fillMaxWidth(0.9f).padding(16.dp)) {
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
fun UploadIdentityProof(section: String) {
    val context = LocalContext.current
    var selectedIdentityProof by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var fileUri by remember { mutableStateOf<Uri?>(null) }
    val identityProofOptions = listOf("Aadhar Card", "Passport", "Driving License", "Voter ID")

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
            Box(modifier = Modifier.fillMaxWidth().clickable { expanded = true }) {
                OutlinedTextField(
                    value = selectedIdentityProof,
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
                            selectedIdentityProof = option
                        }) {
                            Text(text = option)
                        }
                    }
                }
            }

            Button(
                onClick = {
                    openFilePicker(context, filePickerLauncher)
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
    val mimeTypes = arrayOf("application/pdf", "image/*")
    launcher.launch(mimeTypes)
}

@Composable
fun UploadIdentityProofCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 10.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = SecondaryBlue)
    ) {
        UploadIdentityProof(section = "Upload Identity Proof")
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldBox(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label, color = Color.Gray) },
        placeholder = { Text(text = placeholder, fontSize = 14.sp) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .size(60.dp)
    )
}
