package br.com.bruno.fonseca.app.features.product

import br.com.bruno.fonseca.app.data.remote.products.ProductsApiService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


class ProductRepository(private val productsApiService: ProductsApiService) {

    suspend fun get() = withContext(IO) {
        productsApiService.get()
    }
}