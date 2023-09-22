package dev.pastukhov.waharoster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.pastukhov.waharoster.ui.components.BottomNavigation
import dev.pastukhov.waharoster.ui.theme.WaharosterTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaharosterTheme {
                var currentScreen: WaharosterDestination by remember { mutableStateOf(Overview) }
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            allScreens = tabRowScreens,
                            onTabSelected = { screen -> currentScreen = screen },
                            currentScreen = currentScreen
                        )
                    }
                ) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        currentScreen.screen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Text("Android")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WaharosterTheme {
        Text("Android")
    }
}