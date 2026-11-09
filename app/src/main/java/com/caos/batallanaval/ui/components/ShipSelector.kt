package com.caos.batallanaval.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.caos.batallanaval.domain.model.Orientation
import com.caos.batallanaval.domain.model.ShipType

@Composable
fun ShipSelector(
    selectedType: ShipType?,
    placedTypes: Set<ShipType>,
    currentOrientation: Orientation,
    onSelectType: (ShipType) -> Unit,
    onToggleOrientation: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Selecciona Barco:", color = Color.White)
            Button(onClick = onToggleOrientation) {
                Text("Rotar: ${currentOrientation.name}")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ShipType.values().forEach { type ->
                val isPlaced = placedTypes.contains(type)
                val isSelected = selectedType == type
                FilterChip(
                    selected = isSelected,
                    enabled = !isPlaced,
                    onClick = { onSelectType(type) },
                    label = { Text("${type.displayName[0]} (${type.size})") }
                )
            }
        }
    }
}