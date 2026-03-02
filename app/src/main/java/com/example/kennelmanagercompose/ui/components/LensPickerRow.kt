package com.example.kennelmanagercompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kennelmanagercompose.domain.enums.MapLens

@Composable
fun LensPickerRow(
    currentLens: MapLens,
    onLensSelected: (MapLens) -> Unit,
    modifier: Modifier = Modifier
) {
    // LazyRow automatically handles scrolling if you add a ton of lenses later
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp) // Keeps the ends from hugging the screen edge
    ) {
        // THIS IS THE DYNAMIC MAGIC! It loops through your Enum automatically.
        items(MapLens.entries) { lens ->
            val isSelected = (lens == currentLens)

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(if (isSelected) Color(0xFF4CAF50) else Color.Transparent) // Green accent if active
                    .border(
                        width = 1.dp,
                        color = if (isSelected) Color(0xFF4CAF50) else Color.Gray.copy(alpha = 0.5f),
                        shape = CircleShape
                    )
                    .clickable { onLensSelected(lens) }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = lens.displayName,
                    color = if (isSelected) Color.Black else Color.White,
                    fontSize = 14.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}