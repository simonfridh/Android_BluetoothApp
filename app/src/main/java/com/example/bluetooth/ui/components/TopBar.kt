package com.example.bluetooth.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun TopBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navStack by navController.currentBackStackEntryAsState()
    val currentRoute = navStack?.destination?.route

    if(currentRoute != "HomeScreen") { //Only shows the topbar if not on homescreen
        Row(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.padding(8.dp, 4.dp),
                onClick = {
                    navController.navigate("HomeScreen")
                }
            ) {
                Text("Back")
            }
        }
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(rememberNavController())
}