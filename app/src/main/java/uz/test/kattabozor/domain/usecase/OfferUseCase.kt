package uz.test.kattabozor.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.test.kattabozor.data.model.ResultData
import uz.test.kattabozor.data.model.response.OfferItem

interface OfferUseCase {

    fun getOffers() : Flow<ResultData<List<OfferItem>>>
}