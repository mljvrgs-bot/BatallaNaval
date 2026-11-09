package com.caos.batallanaval.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameControls(onSurrender: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Button(onClick = onSurrender, modifier = Modifier.fillMaxWidth()) {
            Text("Rendirse")
        }
    }
}