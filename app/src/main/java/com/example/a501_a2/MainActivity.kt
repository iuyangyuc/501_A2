package com.example.a501_a2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a501_a2.ui.theme._501_A2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _501_A2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ColorCard(color: Color, label: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ColorCard(
            color = Color.Red,
            label = "Red",
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(Color.Red)
                .padding(16.dp)
        )
        
        ColorCard(
            color = Color.Green,
            label = "Green",
            modifier = Modifier
                .size(180.dp, 120.dp)
                .background(Color.Green)
                .border(3.dp, Color.Black)
        )
        
        ColorCard(
            color = Color.Blue,
            label = "Blue",
            modifier = Modifier
                .size(220.dp, 80.dp)
                .background(Color.Blue)
                .padding(12.dp)
                .border(2.dp, Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _501_A2Theme {
        Greeting("Android")
    }
}