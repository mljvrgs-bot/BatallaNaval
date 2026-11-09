package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InviteCodeScreen(onConnected: () -> Unit) {
    var code by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("SALA DE ESPERA ONLINE", fontSize = 20.sp, color = Color(0xFF38BDF8))
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = code,
            onValueChange = { if (it.length <= 6) code = it },
            label = { Text("Código de 6 dígitos") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onConnected,
            enabled = code.length == 6,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("UNIRSE A SALA")
        }
    }
}