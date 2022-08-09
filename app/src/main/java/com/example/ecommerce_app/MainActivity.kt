 package com.example.ecommerce_app

import android.os.Bundle
import android.widget.TableLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.accompanist.pager.ExperimentalPagerApi

 class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // To show product Item
//            val productItem = ProductItem()
//            productItem.ProductItemDesign()

            // To show Tap Layout
//            val tapLayout = TapLayout()
//            tapLayout.TabScreen()

            // To show Sign Up Screen
            val signUp = SignUp()
            signUp.DisplayListOfEditTexts()


        }
    }
}