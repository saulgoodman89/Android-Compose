package com.gomi.android_compose

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter

class ListDemo {
    object ListDemoEx {
        @OptIn(ExperimentalFoundationApi::class)
        @Composable
        fun mainScreen(context : Context, itemArray: Array<out String>) {
            val groupedItems = itemArray.groupBy { it.substringBefore((' ')) }
            val onListItemClick = { text: String ->
                Toast.makeText(context, text, Toast.LENGTH_LONG)
                    .show()
            }
            LazyColumn {
                groupedItems.forEach { (manufacture, models) ->
                    stickyHeader {
                        Text(text=manufacture,
                            color = Color.White,
                            modifier = Modifier.background(Color.Gray)
                                .padding(5.dp)
                                .fillMaxWidth())
                    }
                    items(models) { model ->
                        myListItem(item = model, onListItemClick)
                    }
                }
            }
        }

        @Composable
        fun imageLoader(item: String) {
            val url = "https://www.ebookfrenzy.com/book_examples/car_logos/" + item.substringBefore(" ") + "_logo.png"
            Image(
                painter = rememberImagePainter(url),
                contentDescription="car image",
                contentScale = ContentScale.Fit,
                modifier= Modifier.size(75.dp)
            )
        }

        @Composable
        fun myListItem(item:String , onItemClick: (String) -> Unit) {
            Card(Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    ,shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    imageLoader(item = item)
                    Spacer(modifier=Modifier.width(8.dp))
                    Text(
                        text=item,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}