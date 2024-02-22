package com.thethtooaung.jetpackcomposetest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

data class User(
    val id:Int
)


@Composable
fun Home(navController: NavHostController? = null) {

    val user = User(1)
    val users = remember { mutableStateListOf(user)}
    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users = users,navController)
        Button(modifier = Modifier
            .padding(12.dp)
            .align(Alignment.BottomCenter),
            onClick = {
                users.add(User(1))
            }) {
            Text(text = "Add More")
        }
    }
}

@Composable
fun UserList(users:List<User>,navController: NavHostController? = null){
    LazyColumn{
        items(users){user->
            UserCard(navController)
        }
    }
}
@Composable
fun UserCard(navController: NavHostController? = null){

    val context = LocalContext.current
   Card(
       modifier = Modifier
           .padding(12.dp)
           .fillMaxWidth()
           .wrapContentHeight()
           .background(color = Color(android.R.attr.selectableItemBackground))
           .clickable {
               navController?.navigate("detail")
           }
   ) {
       Row(modifier = Modifier
           .fillMaxWidth()
           .wrapContentHeight()
           .padding(12.dp)
       ){
           Image(
               painter = painterResource(id = R.drawable.dammy_image),
               contentDescription = "",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .size(120.dp)
                   .clip(CircleShape))

           Column {
               Text(text = stringResource(id = R.string.about),
                   modifier = Modifier.padding(start = 12.dp))
               Button(onClick = { }) {
                   Text(text = "View Profile",
                       modifier = Modifier.clickable {
                           Toast.makeText(context,"Click on View Profile",Toast.LENGTH_LONG).show()
                       })
               }
           }
       }
   }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(Modifier.fillMaxSize()) {
        MainContent()
    }
}
