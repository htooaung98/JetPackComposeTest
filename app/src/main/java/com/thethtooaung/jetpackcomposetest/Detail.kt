package com.thethtooaung.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.KeyEventDispatcher.Component

class Detail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DetailContent()
        }
    }
}
@Composable
fun DetailContent(){
    Box (modifier = Modifier.fillMaxSize()){

    }
}

@Preview
@Composable
fun PreviewDetail(){
    Surface {
        DetailContent()
    }
}