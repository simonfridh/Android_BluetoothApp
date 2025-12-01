package com.example.bluetooth.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.bluetooth.ui.viewmodels.IBlueToothVM
import com.example.bluetooth.ui.viewmodels.FakeVM

@Composable
fun HomeScreen(
    vm: IBlueToothVM,
    modifier: Modifier = Modifier
) {
    val orientation = LocalConfiguration.current.orientation

    LaunchedEffect(Unit) {
        vm.doTest()
    }

    //Portrait mode
    if(orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center,

            ){
                Text("PORTRAIT MODE")
            }

        }
    }

    //LANDSCAPE MODE
    else if(orientation == Configuration.ORIENTATION_LANDSCAPE){
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ){
                Text("LANDSCAPE MODE")
            }


        }
    }
}

@Preview
@Composable
private fun PortraitPreview() {
    HomeScreen(FakeVM())
}

@Preview(widthDp = 915, heightDp = 412)
@Composable
private fun LandscapePreview() {
    HomeScreen(FakeVM())
}