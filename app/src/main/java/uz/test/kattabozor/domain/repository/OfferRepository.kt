package uz.test.kattabozor.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.test.kattabozor.data.model.ResultData
import uz.test.kattabozor.data.model.response.OfferItem

interface OfferRepository {
    fun getOffers(): Flow<ResultData<List<OfferItem>>>
}