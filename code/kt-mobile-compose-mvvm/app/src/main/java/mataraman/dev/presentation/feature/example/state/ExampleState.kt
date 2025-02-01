package mataraman.dev.presentation.feature.example.state


import mataraman.dev.domain.model.ProductItem

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductItem>? = null,
    var error: String = ""
)