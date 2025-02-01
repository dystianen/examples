package example.dev.presentation.feature.example.state


import example.dev.domain.model.ExampleItem

data class ExampleState(
    val isLoading: Boolean = false,
    val data: List<ExampleItem>? = null,
    var error: String = ""
)