package com.example.ecommerce_app.view

import android.os.strictmode.NonSdkApiUsedViolation
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.ecommerce_app.R
import com.example.ecommerce_app.ui.theme.Purple500

@Composable
fun loginpage(navController: NavController){
    val context= LocalContext.current
    val scaffoldState= rememberScaffoldState()
   val emailval= remember { mutableStateOf("")}
    val passwordval= remember { mutableStateOf("") }
    val passwordvisibality= remember { mutableStateOf(false)}

    Scaffold(modifier = Modifier.fillMaxSize(),scaffoldState=scaffoldState) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                text = "Sign in",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(20.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
           OutlinedTextField(value = emailval.value,
               onValueChange ={emailval.value=it},
               label = { Text(text = "Email Address", color = Black) },
               placeholder = { Text(text = "Email Address", color = Black)},
               singleLine = true,
               modifier = Modifier.fillMaxWidth(0.8f),
               colors = TextFieldDefaults.outlinedTextFieldColors(
                 unfocusedBorderColor = Black,
                 textColor = Black
               )
               )
         OutlinedTextField(value = passwordval.value,
             onValueChange ={passwordval.value=it},
             colors = TextFieldDefaults.outlinedTextFieldColors(
                 unfocusedBorderColor = Black, textColor = Black
             ),
             trailingIcon = {
                 IconButton(onClick = {
                     passwordvisibality.value=!passwordvisibality.value

                     }){
                     Icon(painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                         contentDescription ="password",
                         tint = if (passwordvisibality.value) Purple500 else Gray

                     )
                 }

             },
             label = { Text(text = "password", color = Black)},
             placeholder = { Text(text = "password", color = Black) },
             singleLine = true,
             visualTransformation = if (passwordvisibality.value) VisualTransformation .None else PasswordVisualTransformation(),
             modifier = Modifier.fillMaxWidth(0.8f)
             )
            Spacer(modifier =Modifier.padding(20.dp))
            
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = White), 
            onClick = { when{ 
                emailval.value.isEmpty() ->{
                    Toast.makeText(context,"Please Enter your email!",Toast.LENGTH_LONG).show()
                    
                }passwordval.value.isEmpty() ->{
                    Toast.makeText(context,"Please Enter your password",Toast.LENGTH_LONG).show()

                }else->{
                    Toast.makeText(context,"log in sucessed",Toast.LENGTH_LONG).show()
                }
            }
                
            },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)){
                Text(text = "Sign in", fontSize = 20.sp, color = Black)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Create an account?",
                color = Black,
                modifier = Modifier.clickable { navController.navigate("Sign up") })
            
            Spacer(modifier = Modifier.padding(20.dp))
                }
         
           



        }


        }

    }


