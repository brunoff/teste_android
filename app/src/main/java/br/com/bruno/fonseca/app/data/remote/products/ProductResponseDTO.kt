package br.com.bruno.fonseca.app.data.remote.products

data class ProductResponseDTO(
    val spotlight: List<ProductResponseSpotlightDTO>,
    val products: List<ProductResponseSkuDTO>,
    val cash: ProductResponseCashDTO
)

data class ProductResponseSpotlightDTO(
    val name: String,
    val bannerURL: String,
    val description: String
)

data class ProductResponseSkuDTO(
    val name: String,
    val imageURL: String,
    val description: String
)


data class ProductResponseCashDTO(
    val title: String,
    val bannerURL: String,
    val description: String
)
