package project.app.msmesol.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.net.toFile
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import project.app.msmesol.data.UserInfo
import project.app.msmesol.domain.FileUploader
import project.app.msmesol.domain.FireStoreUploader
import project.app.msmesol.domain.FirebaseFileUploader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private var fileUploader: FirebaseFileUploader,
    private val firestoreUploader: FireStoreUploader
) : AndroidViewModel(application = application) {

    val applications = application
    var name = mutableStateOf("")
    var phoneNumber = mutableStateOf("")
    var businessAddress = mutableStateOf("")
    var websiteUrl = mutableStateOf("")
    var businessName = mutableStateOf("")
    var businessType = mutableStateOf("")
    var registrationNumber = mutableStateOf("")
    var yearOfEstablishment = mutableStateOf("")
    var companySize = mutableStateOf("")
    var annualRevenue = mutableStateOf("")
    var gstinNumber = mutableStateOf("")
    var panNumber = mutableStateOf("")
    var udyamNumber = mutableStateOf("")
    var selectedIdentityProof = mutableStateOf("")
    var fileAddress = mutableStateOf<String?>(null)

    fun uploadFile(
        fileUri: Uri,
        email: String,
    ) {
        viewModelScope.launch {
            fileAddress.value = fileUploader.uploadFileToFirebaseStorage(
                fileUri,
                email,
                generateRandomFileName()
            )
            if (fileAddress.value == null) {
                Toast.makeText(
                    applications.applicationContext,
                    "File upload failed",
                    Toast.LENGTH_SHORT
                ).show()
                return@launch
            } else {
                Toast.makeText(
                    applications.applicationContext,
                    "File uploaded successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun generateRandomFileName(): String {
        val uuid = UUID.randomUUID().toString()
        val randomString = (1..10)
            .map { ('a'..'z').random() }
            .joinToString("")
        return "${randomString}_$uuid.pdf"
    }

    fun uploadDataToFireStore() {
        viewModelScope.launch {
            val result = firestoreUploader.uploadDataToFireStore(
                "UserInfo",
                phoneNumber.value,
                UserInfo(
                    name = name.value,
                    phoneNumber = phoneNumber.value,
                    businessAddress = businessAddress.value,
                    websiteUrl = websiteUrl.value,
                    businessName = businessName.value,
                    businessType = businessType.value,
                    registrationNumber = registrationNumber.value,
                    yearOfEstablishment = yearOfEstablishment.value,
                    companySize = companySize.value,
                    annualRevenue = annualRevenue.value,
                    gstinNumber = gstinNumber.value,
                    panNumber = panNumber.value,
                    udyamNumber = udyamNumber.value,
                    selectedIdentityProof = selectedIdentityProof.value,
                )
            )
            if (result.isSuccess) {
                Toast.makeText(
                    applications.applicationContext,
                    "Data uploaded successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applications.applicationContext,
                    "Data upload failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

