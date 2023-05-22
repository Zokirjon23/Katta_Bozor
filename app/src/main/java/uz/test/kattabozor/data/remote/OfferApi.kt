package uz.test.kattabozor.data.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.test.kattabozor.data.model.response.OfferResponse

interface OfferApi {

    @GET("offers")
    suspend fun getOffers() : Response<OfferResponse>
}