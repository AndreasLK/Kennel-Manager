package com.example.kennelmanagercompose.maplens.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kennelmanagercompose.domain.enums.MapLens
import com.example.kennelmanagercompose.ui.theme.colorMappers.MapLensLegendMapper

@Composable
fun MapLensMenu(
    currentLens: MapLens,
    onLensSelected: (MapLens) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.End, modifier = modifier) {
        // Hamburger Button
        IconButton(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .background(Color(0xFF2D2D2D), CircleShape)
                .size(48.dp)
        ) {
            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
        }

        // Dropdown Content
        AnimatedVisibility(visible = isExpanded) {
            Card(
                modifier = Modifier
                    .width(220.dp)
                    .padding(top = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D))
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Select Lens", color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))

                    // 1. THE LENS PICKER
                    MapLens.entries.forEach { lens ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onLensSelected(lens) }
                                .padding(vertical = 6.dp)
                        ) {
                            RadioButton(
                                selected = currentLens == lens,
                                onClick = null,
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF4CAF50),
                                    unselectedColor = Color.Gray
                                )
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(lens.displayName, color = Color.White)
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 12.dp),
                        color = Color.Gray.copy(alpha = 0.3f)
                    )

                    Text("Legend", color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))

                    // 2. THE DYNAMIC LEGEND
                    val legendEntries = MapLensLegendMapper.getLegend(currentLens)
                    legendEntries.forEach { entry ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .background(entry.color, CircleShape)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = entry.label,
                                color = Color.LightGray,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}