package example.dev.presentation.feature.example.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import example.dev.domain.model.ExampleItem
import example.dev.presentation.feature.example.viewmodel.ScreenExampleViewModel

@Composable
fun ExampleScreenOne(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ScreenExampleViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val result = viewModel.productList.value

    Column(modifier = modifier.fillMaxSize()) {
        when {
            result.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                }
            }

            result.error.isNotEmpty() -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = result.error)
                }
            }

            result.data != null -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(result.data) { item ->
                        ListItem(item) { product ->
                            Toast.makeText(context, product.title, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ListItem(category: ExampleItem, onItemClick : (ExampleItem) -> Unit) {
    Card (modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(5.dp).clickable {
            onItemClick(category)
        }) {
            Image(
                modifier = Modifier.size(200.dp).padding(8.dp).weight(0.4f),
                painter = rememberAsyncImagePainter(category.image),
                contentDescription = ""
            )
            UserDescription(category, Modifier.weight(0.6f))
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(1.dp))
    }
}

@Composable
fun UserDescription(category: ExampleItem, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(category.title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text(category.description, fontSize = 12.sp, maxLines = 4, overflow = TextOverflow.Ellipsis)
    }
}