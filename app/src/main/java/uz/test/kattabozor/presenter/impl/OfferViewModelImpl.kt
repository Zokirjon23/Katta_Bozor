package uz.test.kattabozor.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import uz.test.kattabozor.data.model.ResultData
import uz.test.kattabozor.data.model.uistate.OfferUiState
import uz.test.kattabozor.domain.usecase.OfferUseCase
import uz.test.kattabozor.presenter.OfferViewModel
import javax.inject.Inject

@HiltViewModel
class OfferViewModelImpl @Inject constructor(useCase : OfferUseCase)  : ViewModel(),OfferViewModel {

    override val uiState = MutableStateFlow(OfferUiState())

    init {
        uiState.update { state -> state.copy(loading = true) }
        useCase.getOffers().onEach {
            uiState.update { state -> state.copy(loading = false) }
            when(it){
                is ResultData.Success ->{
                    uiState.update { state -> state.copy(offers = it.data) }
                }
                is ResultData.Message ->{
                    uiState.update { state -> state.copy(messageId = it.stringId) }
                }
                is ResultData.OnFail ->{
                    uiState.update { state -> state.copy(error = it.message.message) }
                }
            }
        }.launchIn(viewModelScope)
    }
}