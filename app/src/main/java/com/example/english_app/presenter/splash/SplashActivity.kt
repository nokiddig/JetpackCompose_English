package com.example.english_app.presenter.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.english_app.R
import com.example.english_app.presenter.login.view.LoginActivity
import com.example.english_app.ui.theme.English_appTheme
import kotlinx.coroutines.delay

//@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            English_appTheme {
                SplashScreen()
            }
        }
        
    }

    @Composable
    fun SplashScreen() {
        val alpha = remember {
            Animatable(0f)

        }
        LaunchedEffect(key1 = true, block = {
            alpha.animateTo(1f,
                animationSpec = tween(1000)
                )
            delay(1000)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        })
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White), contentAlignment = Alignment.Center){
            Image(modifier = Modifier.alpha(alpha.value),
                painter = painterResource(id = R.drawable.logo), contentDescription = "Login")
        }
    }
}

