
package com.maya.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MayaDashboard() }
    }
}

@Composable
fun MayaDashboard() {
    var message by remember { mutableStateOf("Hello! I am MAYA.") }
    val purple = Color(0xFFAA70FF)
    val gold = Color(0xFFFFD58A)

    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF080812), Color(0xFF211338))
                )
            )
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text("M A Y A", color = gold, fontSize = 34.sp,
            fontWeight = FontWeight.Bold)
        Text("YOUR PERSONAL AI ASSISTANT",
            color = Color.LightGray, fontSize = 11.sp)
        Spacer(modifier = Modifier.height(65.dp))

        Box(
            modifier = Modifier.size(190.dp).background(
                Brush.linearGradient(listOf(purple, Color(0xFF422078), gold)),
                CircleShape
            ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(165.dp)
                    .background(Color(0xFF100D20), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("M", color = gold, fontSize = 85.sp,
                    fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(35.dp))
        Text("Hello, I'm MAYA", color = Color.White,
            fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(message, color = Color.LightGray, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = { message = "Voice assistant coming soon!" },
            colors = ButtonDefaults.buttonColors(containerColor = purple),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.fillMaxWidth().height(55.dp)
        ) {
            Text("TALK TO MAYA", color = Color.White)
        }

        Spacer(modifier = Modifier.height(18.dp))
        OutlinedButton(
            onClick = { message = "MAYA is ready to help!" },
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) {
            Text("ACTIVATE MAYA", color = gold)
        }

        Spacer(modifier = Modifier.weight(1f))
        Text("POWERED BY MAYA AI", color = Color.Gray, fontSize = 11.sp)
    }
}
