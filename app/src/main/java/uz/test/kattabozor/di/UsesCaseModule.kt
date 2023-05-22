package uz.test.kattabozor.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.test.kattabozor.domain.usecase.OfferUseCase
import uz.test.kattabozor.domain.usecase.impl.OfferUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UsesCaseModule {

    @Binds
    fun provideOfferUseCase(impl : OfferUseCaseImpl) : OfferUseCase
}