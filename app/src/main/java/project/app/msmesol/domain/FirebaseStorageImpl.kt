package project.app.msmesol.domain

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface FileUploader {
    suspend fun uploadFileToFirebaseStorage(
        fileUri: Uri,
        email: String,
        filenameWithExtension: String
    ): String?
}


class FirebaseFileUploader @Inject constructor(
    private val firebaseStorage: FirebaseStorage
) : FileUploader {

    override suspend fun uploadFileToFirebaseStorage(
        fileUri: Uri,
        email: String,
        filenameWithExtension: String
    ): String? {
        return try {
            val storagePath = "Documents/$email/$filenameWithExtension"
            val fileReference: StorageReference = firebaseStorage.reference.child(storagePath)
            fileReference.putFile(fileUri).await()
            fileReference.downloadUrl.await().toString()
        } catch (e: Exception) {
            // Handle exceptions
            null
        }
    }
}
