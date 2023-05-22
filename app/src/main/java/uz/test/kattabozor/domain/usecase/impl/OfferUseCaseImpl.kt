package uz.test.kattabozor.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.test.kattabozor.data.model.ResultData
import uz.test.kattabozor.data.model.response.OfferItem
import uz.test.kattabozor.domain.repository.OfferRepository
import uz.test.kattabozor.domain.usecase.OfferUseCase
import javax.inject.Inject

class OfferUseCaseImpl @Inject constructor(private val repository: OfferRepository) : OfferUseCase {

    override fun getOffers(): Flow<ResultData<List<OfferItem>>> {
        return repository.getOffers()
    }
}