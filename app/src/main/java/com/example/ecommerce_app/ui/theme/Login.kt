package com.example.ecommerce_app.ui.theme

import android.util.Log.d
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun LoginPage(navController: NavController) {
    val context = LocalContext.current
    val emailval = remember { mutableStateOf("") }
    val passwordval = remember { mutableStateOf("") }
    val passwordvisability = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = rememberScaffoldState()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black,
                text = "Sign In"
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = emailval.value,
                    onValueChange = { emailval.value = it },
                    label = { Text(text = "Email Address", color = Color.Black) },
                    placeholder = { Text(text = "Email Address", color = Color.Black) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    )

                )

                OutlinedTextField(
                    value = passwordval.value,
                    onValueChange = { passwordval.value = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    ),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordvisability.value = !passwordvisability.value
                        }) {
                            Icon(
                              painter = painterResource(id = com.example.ecommerce_app.R.drawable.ic_baseline_visibility_24),
                                contentDescription = "password",
                                tint = if (passwordvisability.value) Purple500 else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Password", color = Color.Black) },
                    placeholder = { Text(text = "password", color = Color.Black) },
                    singleLine = true,
                    visualTransformation = if (passwordvisability.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)

                )
                Spacer(modifier = Modifier.padding(20.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = {
                        when {
                            emailval.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter email address!",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                            passwordval.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter password !",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                            else -> {
                                Toast.makeText(context, "logged sucesssfully", Toast.LENGTH_LONG)
                                    .show()
                            }

                        }
                    }, modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(
                        text = "sign in",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = "Create an Account? ",
                    color = Color.Black,
                    modifier = Modifier.clickable { navController.navigate("sign_up") })

                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}

