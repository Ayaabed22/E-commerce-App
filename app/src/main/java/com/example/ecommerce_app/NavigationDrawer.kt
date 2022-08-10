package com.example.ecommerce_app

import android.content.ClipData
import android.graphics.Paint
import android.widget.AdapterView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp, horizontal = 20.dp) ,

    )
    {
        Text(modifier = Modifier
            .fillMaxWidth(15f),
            text ="Name")
        Text(modifier = Modifier
            .fillMaxWidth(15f)
            .padding(vertical = 50.dp) ,
            text ="email@")

    }
    
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
){
    LazyColumn(Modifier){
        items(items) {item ->
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)
        
        ){
            Icon(
                imageVector =item.icon ,
                contentDescription = item.contentDescription
            )

         Spacer(modifier = Modifier.width(16.dp))
            Text(text = item.title,
                style=itemTextStyle,
                 modifier =Modifier
            )
        }
    }}}
