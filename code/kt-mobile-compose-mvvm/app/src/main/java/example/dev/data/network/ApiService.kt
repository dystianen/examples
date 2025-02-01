package example.dev.data.network

import example.dev.data.model.ExampleDTO
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI() : List<ExampleDTO>
}