package com.satish.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.satish.mycomposeapp.navigation.AppNav
import com.satish.mycomposeapp.ui.theme.PuppyTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyTheme {
                AppNav(mainViewModel)
            }
        }
    }
}
