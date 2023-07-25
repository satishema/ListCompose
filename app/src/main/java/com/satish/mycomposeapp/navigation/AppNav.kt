package com.satish.mycomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.satish.mycomposeapp.MainViewModel
import com.satish.mycomposeapp.ui.detail.PhotoDetailScreen
import com.satish.mycomposeapp.ui.list.PhotosScreen


/**
 * Created by Satish V on 13/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */


@Composable
fun AppNav(
    mainViewModel: MainViewModel, startDestination: String = Screen.PhotosList.route
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        composable(route = Screen.PhotosList.route) {
            PhotosScreen(vm = mainViewModel, onItemClick = { photo ->
                navController.navigate(Screen.PhotoDetails.createRoute(photo.id))
            })
        }

        composable(
            route = Screen.PhotoDetails.route,
            arguments = listOf(navArgument("photoId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val photoId =
                navBackStackEntry.arguments?.getInt(Screen.PhotoDetails.PHOTO_DETAIL_ID_KEY)
            val photo = mainViewModel.photosList.find { it.id == photoId }
            photo?.let {
                PhotoDetailScreen(photo = it, navigateUp = { navController.navigateUp() })
            }
        }
    }
}




