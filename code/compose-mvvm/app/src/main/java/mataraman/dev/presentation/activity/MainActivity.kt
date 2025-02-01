package mataraman.dev.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mataraman.dev.presentation.navigation.NavigationMain
import mataraman.dev.presentation.theme.ui.ComposemvvmTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigation = rememberNavController()
            ComposemvvmTheme {
                NavigationMain(
                    navController = navigation
                )
            }
        }
    }
}