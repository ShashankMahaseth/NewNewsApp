package com.example.newnewsapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newnewsapp.presenttion.CountryScreen
import com.example.newnewsapp.presenttion.NewsScreen
import com.example.newnewsapp.viewModel.NewsViewModel


@Composable
fun NewsNavigation(){
    val viewModel: NewsViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Routes.CountryScreen) {
        composable<Routes.CountryScreen>{
            CountryScreen(navController,viewModel)
        }
        composable<Routes.NewsScreen>{
            NewsScreen(viewModel)
        }
    }
}