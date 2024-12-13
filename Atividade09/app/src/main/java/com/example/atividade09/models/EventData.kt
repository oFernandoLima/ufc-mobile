package com.example.atividade09.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.atividade09.R


data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Conferência de Tecnologia 2024",
        description = "Tendências em tecnologia.",
        date = "2024-12-15",
        location = "Parque Tecnológico",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.event_tech
    ),
    Event(
        id = 2,
        title = "Workshop de Inteligência Artificial",
        description = "Explorando o futuro da IA aplicada.",
        date = "2024-12-20",
        location = "Auditório Central",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.event_ia
    ),
    Event(
        id = 3,
        title = "Hackathon Inovação 2024",
        description = "Desenvolva soluções criativas em 48 horas.",
        date = "2025-01-10",
        location = "Centro de Inovação",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.event_hack
    ),
    Event(
        id = 4,
        title = "Palestra sobre Segurança Cibernética",
        description = "Protegendo dados em um mundo conectado.",
        date = "2025-01-25",
        location = "Sala de Conferências 1",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.event_sec
    )
)

