package com.gomi.android_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gomi.android_compose.screens.Home
import com.gomi.android_compose.screens.Profile
import com.gomi.android_compose.screens.Welcome

class TabDemo {
    val pages = listOf("#1","#2","#3")
    object TabDemo {
        @Composable
        fun tabRow() {
            var tabIndex by remember { mutableStateOf(0)}
            val tabs = listOf("Home","About","Settings")

            Column(modifier = Modifier.fillMaxSize()) {
                TabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed {
                        index,title->
                        Tab(text={Text(title)},
                            selected = tabIndex == index,
                            onClick = {tabIndex = index})
                    }
                }
                when(tabIndex) {
                    0-> println("### Tab 1")
                    1-> println("### Tab 2")
                    2-> println("### Tab 3")
                }
            }
        }
    }
}