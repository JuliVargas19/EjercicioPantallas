package com.example.sreens.Items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenB(navController: NavController, userList: List<Triple<String, String, String>>) {
    val cardColors = listOf(
        Color(0xFFF7B1CE),
        Color(0xFFA5D6A7),
        Color(0xFFFFF59D),
        Color(0xFF81D4FA),
        Color(0xFFD1C4E9),
        Color(0xFFFFCCBC)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFCE4EC),
                        Color(0xFFB3E5FC),
                        Color(0xFFC8E6C9)
                    )
                )
            )
            .padding(16.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenidos", style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold),
            )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            itemsIndexed(userList) { index, user ->
                val color = cardColors[index % cardColors.size]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = color),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nombre: ${user.first}", style = MaterialTheme.typography.titleMedium)
                        Text("Correo: ${user.second}")
                        Text("Profesión: ${user.third}")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
