package com.example.sreens.Items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController, userList: MutableList<Triple<String, String, String>>) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }

    var errorNombre by remember { mutableStateOf(false) }
    var errorCorreo by remember { mutableStateOf(false) }
    var errorProfesion by remember { mutableStateOf(false) }
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
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Formulario", style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                    errorNombre = false
                },
                label = { Text("Nombre") },
                isError = errorNombre,
                modifier = Modifier.fillMaxWidth()
            )
            if (errorNombre) {
                Text("El nombre no puede estar vacío", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = {
                    correo = it
                    errorCorreo = false
                },
                label = { Text("Correo") },
                isError = errorCorreo,
                modifier = Modifier.fillMaxWidth()
            )
            if (errorCorreo) {
                Text("El correo no puede estar vacío", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = profesion,
                onValueChange = {
                    profesion = it
                    errorProfesion = false
                },
                label = { Text("Profesión") },
                isError = errorProfesion,
                modifier = Modifier.fillMaxWidth()
            )
            if (errorProfesion) {
                Text("La profesión no puede estar vacía", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    errorNombre = nombre.isBlank()
                    errorCorreo = correo.isBlank()
                    errorProfesion = profesion.isBlank()

                    if (!errorNombre && !errorCorreo && !errorProfesion) {
                        userList.add(Triple(nombre, correo, profesion))
                        navController.navigate("screenB")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar")
            }
        }
    }
}