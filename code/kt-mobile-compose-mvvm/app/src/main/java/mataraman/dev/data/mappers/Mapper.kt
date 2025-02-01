package mataraman.dev.data.mappers

import mataraman.dev.data.model.ProductListDTO
import mataraman.dev.domain.model.ProductItem

fun ProductListDTO.toProductList() : ProductItem {
    return ProductItem(id = this.id, image= this.image, title = this.title, description= this.description)
}
