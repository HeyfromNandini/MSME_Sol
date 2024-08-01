package project.app.msmesol.domain

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface FireStoreUploader {
    suspend fun <T: Any> uploadDataToFireStore(
        collection: String,
        documentId: String,
        data: T
    ): Result<Unit>
}

class FireStoreUploaderImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FireStoreUploader {

    override suspend fun <T : Any> uploadDataToFireStore(
        collection: String,
        documentId: String,
        data: T
    ): Result<Unit> {
        return try {
            firestore.collection(collection).document(documentId).set(data).await()
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

