package com.example.ecommerce_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProductItem {

    @Composable
     fun ProductItemDesign() {

        Card(elevation = 4.dp, modifier = Modifier.padding(all = 10.dp)) {

            Column(modifier = Modifier.padding(all = 10.dp)) {
                Box(modifier = Modifier.size(170.dp,200.dp)){
                    Image(
                        painter = painterResource(R.drawable.bag),
                        contentDescription = "Contact profile picture",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .size(150.dp,200.dp)
                    )

                    Image(painter = painterResource(id = R.drawable.ic_favorite_border),
                        contentDescription = "favourite icon",
                        modifier = Modifier
                            .align(Alignment.BottomStart))
                }


                // Add a vertical space between the Image and Title text
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                    modifier = Modifier.width(170.dp),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                )
                // Add a vertical space between the Title and Price texts
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "EGP $109.95",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                // Add a vertical space between the texts and Button
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {  /* Add item to the cart */ },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color(R.color.orange),
                        contentColor = Color(R.color.white)
                    ),
                    modifier = Modifier.width(170.dp)
                ) {
                    Text(text = "Add To Cart" )
                }
            }
        }

    }
}