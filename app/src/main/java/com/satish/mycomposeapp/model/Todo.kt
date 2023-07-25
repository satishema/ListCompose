package com.satish.mycomposeapp.model


/**
 * Created by Satish V on 14/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
