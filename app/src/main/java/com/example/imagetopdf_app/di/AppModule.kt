package com.example.imagetopdf_app.di

import android.content.Context
import com.example.imagetopdf_app.data.repository.ImageToPdfRepositoryImpl
import com.example.imagetopdf_app.domain.repository.ImageToPdfRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesImageToPdfRepository(@ApplicationContext context: Context): ImageToPdfRepository {
        return ImageToPdfRepositoryImpl(context)
    }


}