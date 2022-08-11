package com.example.ecommerce_app

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.ecommerce_app.ui.theme.ECommerceAppTheme
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceAppTheme {
                val message:String ="Hello"
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
              //  val intent = Intent(this, ProfileActivity::class.java)
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "profile",
                                    title = "Profile",
                                    contentDescription = "Go to profile",
                                    icon = Icons.Default.Person
                                ),
                                MenuItem(
                                    id = "favorite",
                                    title = "Favorite",
                                    contentDescription = "Go to favorite screen",
                                    icon = Icons.Default.Favorite
                                ),
                                MenuItem(
                                    id = "cart",
                                    title = "Cart",
                                    contentDescription = "Go to carts",
                                    icon = Icons.Default.ShoppingCart
                                ),
                                MenuItem(
                                    id = "logout",
                                    title = "LogOut",
                                    contentDescription = "logout",
                                    icon = Icons.Default.ExitToApp
                            )
                            ),
                            onItemClick = {
                                when(it.id){
                                  //  "profile" ->  startActivity(intent)
//                                    "favorite" -> startActivity(Intent(this, ProfileActivity::class.java))
//                                    "cart" -> println("This is blue")
//                                    "logout" ->
                                }
                                println("Click on ${it.title}")
                            })
                    }
                ) {
                }
            }
        }
    }
}