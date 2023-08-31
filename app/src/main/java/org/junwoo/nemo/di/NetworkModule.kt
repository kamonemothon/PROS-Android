package org.junwoo.nemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.junwoo.nemo.data.service.DiaryService
import org.junwoo.nemo.data.service.PlaceService
import org.junwoo.nemo.data.service.PlanService
import org.junwoo.nemo.data.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(1000, TimeUnit.SECONDS)
        .connectTimeout(1000, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(okhttp: OkHttpClient): Retrofit = Retrofit.Builder(
    )
        .baseUrl("http://192.168.1.103:8080/")
        .client(okhttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun createDiaryService(retrofit: Retrofit): DiaryService = retrofit.create()

    @Provides
    @Singleton
    fun createPlaceService(retrofit: Retrofit): PlaceService = retrofit.create()

    @Provides
    @Singleton
    fun createPlanService(retrofit: Retrofit): PlanService = retrofit.create()

    @Provides
    @Singleton
    fun createUserService(retrofit: Retrofit): UserService = retrofit.create()
}