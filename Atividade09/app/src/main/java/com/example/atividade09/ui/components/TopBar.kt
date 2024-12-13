package com.example.atividade09.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    onThemeToggle: () -> Unit,
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        title = { Text("EventsApp") },
        navigationIcon = {
            IconButton(onClick = onOpenDrawer) { // Abrir o menu ao clicar no ícone
                Icon(Icons.Default.Menu, contentDescription = "Open Menu")
            }
        },
        actions = {
            IconButton(onClick = onThemeToggle) {
                Icon(Icons.Default.BrightnessHigh, contentDescription = "Toggle Theme")
            }
        }
    )
}
