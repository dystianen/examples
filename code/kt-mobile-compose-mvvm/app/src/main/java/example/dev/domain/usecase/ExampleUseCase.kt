package example.dev.domain.usecase

import example.dev.base.UiState
import example.dev.data.repository.ExampleRepositoryImpl
import example.dev.domain.model.ExampleItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repositoryImpl: ExampleRepositoryImpl
) {

    operator fun invoke() : Flow<UiState<List<ExampleItem>>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repositoryImpl.getProductList()))
        }catch (e : Exception){
            emit(UiState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}