package com.example.ecommerce_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

class SignUp {

    //Label List of each TextField
    private val labels = listOf(
        "First Name", "Last Name", "User Name", "Email", " Password", "Phone", "City", "Address")


    @OptIn(ExperimentalUnitApi::class)
    @Composable
    fun DisplayListOfEditTexts() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // view for displaying heading for our application
            Text(
                text = "SIGN UP",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
                ), fontWeight = FontWeight.Black
            )
            // for displaying listview.
            LazyColumn {
                // items for listview.
                items(labels){ label->
                    CreateTextFiled(label = label)
                }
            }

            Row( horizontalArrangement = Arrangement.SpaceEvenly,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(8.dp))
            {
                //Sign IN Button
                CreateButton(text = "SIGN IN")

                //Sign Up Button
                CreateButton(text = "SIGN UP")
            }
        }
    }

    @Composable
    fun CreateButton(text:String){
        Button(onClick = {  /* Add item to the cart */ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color(R.color.orange),
                contentColor = Color(R.color.white)
            ),
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        ) {
            Text(text = text )
        }
    }

    @Composable
    fun CreateTextFiled(label:String){
        var textFieldState by remember{ mutableStateOf("") }
        TextField(
            value = textFieldState,
            label = { Text(text = label) },
            isError = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            onValueChange = { it ->
                textFieldState = it
            }
        )
    }


}