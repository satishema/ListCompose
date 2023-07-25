package com.satish.mycomposeapp.utils


/**
 * Created by Satish V on 14/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?, message: String? = null) : NetworkResult<T>(data, message)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()
}