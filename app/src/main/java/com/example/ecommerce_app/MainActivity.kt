 package com.example.ecommerce_app


 import android.os.Bundle
 import androidx.activity.ComponentActivity
 import androidx.activity.compose.setContent
 import androidx.compose.runtime.Composable
 import androidx.compose.runtime.rememberCompositionContext
 import androidx.navigation.NavHost
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.compose.rememberNavController
 import com.example.ecommerce_app.ui.theme.ECommerceAppTheme
 import com.example.ecommerce_app.ui.theme.LoginPage


 class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContent {
             ECommerceAppTheme {
                 navigatepage()
             }
         }
     }@Composable
     fun navigatepage(){
         val navController= rememberNavController()
         NavHost(navController = navController, startDestination = "Login_Page",
             builder = {
                 composable("Login_Page", content = { LoginPage(navController = navController)})
             }
         )
     }
 }




