package example.dev.presentation.feature.example.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import example.dev.base.UiState
import example.dev.domain.usecase.ExampleUseCase
import example.dev.presentation.feature.example.state.ExampleState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScreenExampleViewModel @Inject constructor(useCase: ExampleUseCase) :
    ViewModel() {

    private val _productList = mutableStateOf(ExampleState())
    val productList : State<ExampleState> get() = _productList

    init {
        useCase.invoke().onEach {
            when(it){
                is UiState.Loading->{
                    _productList.value = ExampleState(isLoading = true)
                }
                is UiState.Success->{
                    _productList.value = ExampleState(data = it.data)
                }
                is UiState.Error->{
                    _productList.value = ExampleState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}