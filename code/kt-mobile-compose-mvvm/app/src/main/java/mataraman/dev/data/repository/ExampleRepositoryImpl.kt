package mataraman.dev.data.repository


import mataraman.dev.data.mappers.toProductList
import mataraman.dev.data.network.ApiService
import mataraman.dev.domain.model.ProductItem
import mataraman.dev.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ExampleRepository {
    override suspend fun getProductList(): List<ProductItem> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }

}