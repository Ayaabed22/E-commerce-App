package com.example.ecommerce_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

class TapLayout {

    @ExperimentalPagerApi
    @Composable
    fun TabScreen() {
        val pagerState = rememberPagerState(pageCount = 4)
        Column(modifier = Modifier.background(Color.White)
        ) {
            Tabs(pagerState = pagerState)
            TabsContent(pagerState = pagerState)
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun Tabs(pagerState: PagerState) {

        val list = listOf("women","men","jewelery","electronics")
        val scope = rememberCoroutineScope()
        TabRow(selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.Black,
            contentColor = Color.White,
            divider = {
                TabRowDefaults.Divider(
                    thickness = 4.dp,
                    color = Color.White
                )
            },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 4.dp,
                    color = Color.Red
                )}
        ) {
            list.forEachIndexed { index, _ ->
                Tab(text = {
                    Text(
                        text = list[index],
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }

        }
    }

    @ExperimentalPagerApi
    @Composable
    fun TabsContent(pagerState: PagerState) {
        HorizontalPager(state = pagerState) {page ->
            when (page) {
                0 -> TabScreen(tabName = "this is a women's clothing tab layout")
                1 -> TabScreen(tabName = "this is a men's clothing tab layout")
                2 -> TabScreen(tabName = "this is a jewelery  tab layout")
                3 -> TabScreen(tabName =  "this is electronics Layout")
            }

        }
    }

    @Composable
    fun TabScreen(tabName:String) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            Arrangement.Center,

        ) {
            Text(
                text = tabName,
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold)
        }
    }


}
