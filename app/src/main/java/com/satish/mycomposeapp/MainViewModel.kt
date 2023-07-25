package com.satish.mycomposeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satish.mycomposeapp.data.remote.APIService
import com.satish.mycomposeapp.model.Photos
import com.satish.mycomposeapp.model.Todo
import kotlinx.coroutines.launch


/**
 * Created by Satish V on 14/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
class MainViewModel() : ViewModel() {
    private val _todoList = mutableStateListOf<Todo>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<Todo>
        get() = _todoList

    private val _photosList = mutableStateListOf<Photos>()
    val photosList: List<Photos>
        get() = _photosList

    fun getTodoList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService.getTodos())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getPhotosList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _photosList.clear()
                _photosList.addAll(apiService.getPhotos())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}