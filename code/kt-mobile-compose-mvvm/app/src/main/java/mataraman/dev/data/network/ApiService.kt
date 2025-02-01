package mataraman.dev.data.network

import mataraman.dev.data.model.ProductListDTO
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI() : List<ProductListDTO>
}