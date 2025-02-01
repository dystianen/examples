package example.dev.data.repository


import example.dev.data.mappers.toProductList
import example.dev.data.network.ApiService
import example.dev.domain.model.ExampleItem
import example.dev.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ExampleRepository {
    override suspend fun getProductList(): List<ExampleItem> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }

}