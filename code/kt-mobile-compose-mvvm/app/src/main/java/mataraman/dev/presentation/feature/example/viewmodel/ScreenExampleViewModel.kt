package mataraman.dev.presentation.feature.example.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mataraman.dev.base.UiState
import mataraman.dev.domain.usecase.ExampleUseCase
import mataraman.dev.presentation.feature.example.state.ProductListState
import javax.inject.Inject

@HiltViewModel
class ScreenExampleViewModel @Inject constructor(useCase: ExampleUseCase) :
    ViewModel() {

    private val _productList = mutableStateOf(ProductListState())
    val productList : State<ProductListState> get() = _productList

    init {
        useCase.invoke().onEach {
            when(it){
                is UiState.Loading->{
                    _productList.value = ProductListState(isLoading = true)
                }
                is UiState.Success->{
                    _productList.value = ProductListState(data = it.data)
                }
                is UiState.Error->{
                    _productList.value = ProductListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}