package project.app.msmesol.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import project.app.msmesol.domain.FileUploader
import project.app.msmesol.domain.FireStoreUploader
import project.app.msmesol.domain.FireStoreUploaderImpl
import project.app.msmesol.domain.FirebaseFileUploader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideFileUploader(firebaseFileUploader: FirebaseFileUploader): FileUploader =
        firebaseFileUploader

    @Provides
    @Singleton
    fun provideFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFireStoreUploader(
        firestore: FirebaseFirestore
    ): FireStoreUploader = FireStoreUploaderImpl(firestore)

}
