package uz.test.kattabozor.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.test.kattabozor.data.model.uistate.OfferUiState

interface OfferViewModel {
    val uiState : StateFlow<OfferUiState>
}