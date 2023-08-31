package org.junwoo.nemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.junwoo.nemo.data.repository.DiaryRepositoryImpl
import org.junwoo.nemo.data.repository.PlaceRepositoryImpl
import org.junwoo.nemo.data.repository.PlanRepositoryImpl
import org.junwoo.nemo.data.repository.UserRepositoryImpl
import org.junwoo.nemo.domain.repository.DiaryRepository
import org.junwoo.nemo.domain.repository.PlaceRepository
import org.junwoo.nemo.domain.repository.PlanRepository
import org.junwoo.nemo.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsDiaryRepository(impl: DiaryRepositoryImpl): DiaryRepository

    @Binds
    @Singleton
    fun bindsPlaceRepository(impl: PlaceRepositoryImpl): PlaceRepository

    @Binds
    @Singleton
    fun bindsPlanRepository(impl: PlanRepositoryImpl): PlanRepository

    @Binds
    @Singleton
    fun bindsUserRepository(impl: UserRepositoryImpl): UserRepository
}