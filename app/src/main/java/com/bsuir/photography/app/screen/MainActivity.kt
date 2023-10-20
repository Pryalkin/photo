package com.bsuir.photography.app.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bsuir.photography.Singletons
import com.bsuir.photography.app.screen.graphs.RootNavigationGraph
import com.bsuir.photography.app.utils.observeEvent
import com.bsuir.photography.ui.theme.PhotographyTheme
import com.bsuir.photography.app.views.AppViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AppViewModel>()
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        Singletons.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            PhotographyTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
        observeShowAuthMessageEvent()
    }

    private fun observeShowAuthMessageEvent() = viewModel.message.observeEvent(lifecycleOwner = this) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }


}

