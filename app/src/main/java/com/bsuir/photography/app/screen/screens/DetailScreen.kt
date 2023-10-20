package com.bsuir.photography.app.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.photography.app.model.Data
import com.bsuir.photography.app.model.W

@Composable
fun DetailScreen(
    w: W
){
    Surface(
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ){
        Column(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp),
                ) {
                    Text(text = "ID: ${w.data.id}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Url: ${w.data.url}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    w.data.colors.forEach {
                        Text(text = "Colors: $it",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    w.tags?.forEach {
                        Text(text = "Tag (name): ${it.name}",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                        )
                        Text(text = "Tag (category): ${it.category}",
                            color = Color.Black,
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
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(
        w = W(
            data = Data(
                id = "id",
                url = "url",
                colors = listOf()
            ),
            tags = emptyArray()
        )
    )
}