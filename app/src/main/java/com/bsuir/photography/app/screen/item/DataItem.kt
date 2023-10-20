package com.bsuir.photography.app.screen.item

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bsuir.photography.app.model.Data

@Composable
fun DataItem(data: Data,
             navController: NavController) {
    val expanded = remember {mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow,
        )
    )


    Surface(color = MaterialTheme.colors.onSurface,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        Column(modifier = Modifier
            .clickable { navController.navigate(route = "detail_screen/${data.id}") }
            .padding(3.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Text(text = "ID: ${data.id}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Url: ${data.url}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }

            if (expanded.value) {
                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {
                    data.colors?.forEach {
                        Text(modifier = Modifier
                            .padding(6.dp),
                            text = "Colors: $it",
                            color = Color.DarkGray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }


                }

            }
        }
    }

}

@Composable
@Preview
fun ShipItemPreview() {
    DataItem(
        data = Data(
            id = "0",
            url = "url",
            colors = listOf()
        ),
        navController = rememberNavController()
    )
}
