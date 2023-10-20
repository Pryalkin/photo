package com.bsuir.photography.app.screen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bsuir.photography.Singletons
import com.bsuir.photography.app.screen.item.DataItem

@Composable
fun HomeContext(
    navController: NavController
) {
    val viewModel = Singletons.appViewModel
    val search = viewModel.search.observeAsState()
    LaunchedEffect(Unit) {
        viewModel.search()
    }
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        search.value?.let {
            items(items = it.data) { s ->
                DataItem(data = s, navController = navController)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeContextPreview() {
    HomeContext(navController = rememberNavController())
}