package uz.test.kattabozor.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.test.kattabozor.R
import uz.test.kattabozor.data.model.ResultData
import uz.test.kattabozor.data.remote.OfferApi
import uz.test.kattabozor.domain.repository.OfferRepository
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(private val offerApi : OfferApi) : OfferRepository{

    override fun getOffers() = flow {
       val response = offerApi.getOffers()
        if (response.isSuccessful && response.body() != null){
            emit(ResultData.Success(response.body()!!.offers))
        }else{
            emit(ResultData.Message(R.string.errorConnection))
        }

    }.catch {
        emit(ResultData.OnFail(it))
    }.flowOn(Dispatchers.IO)
}