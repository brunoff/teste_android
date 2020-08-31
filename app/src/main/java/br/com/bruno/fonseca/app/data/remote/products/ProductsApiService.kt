package br.com.bruno.fonseca.app.data.remote.products

import retrofit2.http.GET

interface ProductsApiService {
    @GET("products")
    suspend fun get(): ProductResponseDTO
}
