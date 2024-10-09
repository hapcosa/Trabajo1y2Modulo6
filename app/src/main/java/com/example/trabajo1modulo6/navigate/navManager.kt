package com.example.trabajo1modulo6.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trabajo1modulo6.view.addContactoView
import com.example.trabajo1modulo6.view.editContactoView
import com.example.trabajo1modulo6.view.homeView
import com.example.trabajo1modulo6.viewModel.contactoViewModel

@Composable
fun navManager(viewModel:contactoViewModel){
    val navController= rememberNavController()
    NavHost(navController , startDestination = "home"){
        composable("home"){
            homeView(navController,viewModel)

        }
        composable("add"){
            addContactoView(navController,viewModel)

        }
        composable("edit/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {
            val id = it.arguments!!.getInt("id")
            editContactoView(navController, viewModel, id)
        }
    }
}