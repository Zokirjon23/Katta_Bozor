package uz.test.kattabozor.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.test.kattabozor.domain.repository.OfferRepository
import uz.test.kattabozor.domain.repository.impl.OfferRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideOfferRepository(impl : OfferRepositoryImpl) : OfferRepository
}