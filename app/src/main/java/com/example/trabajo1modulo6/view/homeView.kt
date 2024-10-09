package com.example.trabajo1modulo6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trabajo1modulo6.component.bottomAppBar
import com.example.trabajo1modulo6.component.contactCard
import com.example.trabajo1modulo6.component.topBar
import com.example.trabajo1modulo6.viewModel.contactoViewModel

@Composable
fun homeView(navController: NavController, viewModel: contactoViewModel) {
    Scaffold(
        topBar = { topBar("Contactos", navController) },
        content = { ContentHomeView(it, navController, viewModel) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
               Icon(Icons.Filled.AddCircle , contentDescription = "add")
            }
        },
        bottomBar = { bottomAppBar(navController) },
    )



}

@Composable
fun ContentHomeView(it: PaddingValues, navController: NavController, viewModel: contactoViewModel) {
    val state by viewModel.contactos.collectAsState()
    Column(
        modifier = androidx.compose.ui.Modifier.padding(it)
    ) {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalItemSpacing = 6.dp,
            modifier = androidx.compose.ui.Modifier.padding(6.dp),
            content = {
                items(state.contactos)
                {
                    contactCard(navController, it,viewModel)
                }
            }
        )

    }
}
