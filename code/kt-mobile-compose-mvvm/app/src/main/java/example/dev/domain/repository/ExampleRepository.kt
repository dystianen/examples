package example.dev.domain.repository

import example.dev.domain.model.ExampleItem

interface ExampleRepository {
    suspend fun getProductList() : List<ExampleItem>
}