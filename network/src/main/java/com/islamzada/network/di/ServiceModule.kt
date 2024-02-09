package com.islamzada.network.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.islamzada.network.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    @HotelsAnnotation
    fun provideApiClient(gson: Gson, @HotelsAnnotation client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://65a7624794c2c5762da692dd.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(@HotelsAnnotation retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideFireStore() : FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Singleton
    @HotelsAnnotation
    fun provideOkHttpsClient(): OkHttpClient {
        val client = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        client
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

        return client.build()
    }

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class HotelsAnnotation
