package com.example.practicanavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicanavegacion.viewModels.LoteriaViewModels
import com.example.practicanavegacion.views.DescuentoView
import com.example.practicanavegacion.views.HomeView
import com.example.practicanavegacion.views.LoteriaView
import com.example.practicanavegacion.views.PerrunosView


@Composable
fun NavManager(viewModels: LoteriaViewModels){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Perrunos"){
//            PerrunosView(navController, id, opcional)
            PerrunosView(navController)
        }
        composable("Descuento") {
            DescuentoView(navController)
        }
        composable("Loteria"){
            LoteriaView(navController, viewModels )
        }
    }
}