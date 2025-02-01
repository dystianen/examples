package example.dev.data.mappers

import example.dev.data.model.ExampleDTO
import example.dev.domain.model.ExampleItem

fun ExampleDTO.toProductList() : ExampleItem {
    return ExampleItem(id = this.id, image= this.image, title = this.title, description= this.description)
}
