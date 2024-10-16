package com.example.trabajo1modulo6.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(title: String, navController: NavController){
    CenterAlignedTopAppBar(title = { Text(text = "$title",color = androidx.compose.ui.graphics.Color.White)
    },colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary
    ),navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
    })
}



@Composable
fun bottomAppBar(navController: NavController) {
    BottomAppBar(modifier = Modifier.fillMaxWidth(), containerColor = MaterialTheme.colorScheme.primary,) {
        IconButton(onClick = { navController.navigate("home") }, modifier = Modifier.padding(30.dp)) {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }
        Icon(Icons.Filled.Search, contentDescription = "Search", modifier = Modifier.padding(30.dp))
        Icon(Icons.Filled.Call, contentDescription = "Call", modifier = Modifier.padding(30.dp))


    }
}