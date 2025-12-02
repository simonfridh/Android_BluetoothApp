package com.example.bluetooth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bluetooth.ui.components.TopBar
import com.example.bluetooth.ui.screens.HomeScreen
import com.example.bluetooth.ui.screens.MeasurementScreen
import com.example.bluetooth.ui.theme.BluetoothTheme
import com.example.bluetooth.ui.viewmodels.BluetoothVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BluetoothTheme {

                val vm = hiltViewModel<BluetoothVM>()
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar(navController = navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "HomeScreen"
                    ) {
                        composable("HomeScreen") {
                            HomeScreen(
                                vm = vm,
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        composable("MeasurementScreen") {
                            MeasurementScreen(
                                vm = vm,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BluetoothTheme {
        Greeting("Android")
    }
}