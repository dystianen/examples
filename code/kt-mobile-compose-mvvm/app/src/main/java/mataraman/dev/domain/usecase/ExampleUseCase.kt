package mataraman.dev.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mataraman.dev.base.UiState
import mataraman.dev.data.repository.ExampleRepositoryImpl
import mataraman.dev.domain.model.ProductItem
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repositoryImpl: ExampleRepositoryImpl
) {

    operator fun invoke() : Flow<UiState<List<ProductItem>>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repositoryImpl.getProductList()))
        }catch (e : Exception){
            emit(UiState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}