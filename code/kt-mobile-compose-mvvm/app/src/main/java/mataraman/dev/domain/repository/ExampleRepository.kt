package mataraman.dev.domain.repository

import mataraman.dev.domain.model.ProductItem

interface ExampleRepository {
    suspend fun getProductList() : List<ProductItem>
}