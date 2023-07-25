package com.satish.mycomposeapp.navigation


/**
 * Created by Satish V on 13/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
sealed class Screen(val route: String) {
    object PhotosList : Screen("photos")
    object PhotoDetails : Screen("photo/{photoId}") {
        const val PHOTO_DETAIL_ID_KEY = "photoId"
        fun createRoute(photoId: Int) = "photo/$photoId"
    }
}
