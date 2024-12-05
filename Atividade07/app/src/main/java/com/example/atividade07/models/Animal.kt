package com.example.atividade07.models

import com.example.atividade07.R


data class Animal (
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val animalList = listOf(
    Animal(
        id = 1,
        name = "Siamês",
        species = "Felis catus (Siamês)",
        imageRes = R.drawable.siamese_cat, // Substitua pelo recurso correto
        description = "O gato siamês é conhecido por sua pelagem curta, elegante e olhos azuis intensos.",
        curiosities = "Os siameses são muito vocais e adoram atenção humana."
    ),
    Animal(
        id = 2,
        name = "Rajado",
        species = "Felis catus (Rajado)",
        imageRes = R.drawable.striped_cat, // Substitua pelo recurso correto
        description = "O gato rajado, também conhecido como tabby, tem uma pelagem com listras e manchas.",
        curiosities = "A maioria dos gatos rajados tem uma marca em forma de 'M' na testa."
    ),
    Animal(
        id = 3,
        name = "Frajola",
        species = "Felis catus (Padrão Preto e Branco)",
        imageRes = R.drawable.tuxedo_cat, // Substitua pelo recurso correto
        description = "O gato frajola, ou tuxedo, é caracterizado pela pelagem preta e branca, parecendo usar um smoking.",
        curiosities = "Gatos frajola são conhecidos por sua personalidade afetuosa e curiosa."
    )
)