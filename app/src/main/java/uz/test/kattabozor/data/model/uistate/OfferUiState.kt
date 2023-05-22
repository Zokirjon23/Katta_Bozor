package uz.test.kattabozor.data.model.uistate

import uz.test.kattabozor.data.model.response.OfferItem

data class OfferUiState(
    val loading : Boolean = false,
    val offers : List<OfferItem> = listOf(),
    val error : String? = null,
    val messageId : Int? = null
)