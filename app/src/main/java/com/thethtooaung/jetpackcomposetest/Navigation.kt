package com.thethtooaung.jetpackcomposetest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainContent() {
    val navController  = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ){
            composable("home"){
                Home(navController)
            }
            composable("detail"){
                DetailContent()
            }
        }
    }
}

@Preview
@Composable
fun NavigationPreview(){
    MainContent()
}