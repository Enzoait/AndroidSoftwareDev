package com.example.coursapplication


data class Product(
    val name: String,
    val publisher: String,
    val episodes: String,
    val date: String,

    val nutriScore: NutriScore,
    val barcode:String,
    val thumbnail: String,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>,
)

enum class NutriScore(val label: String){
    A("A"), B("B"), C("C"), D("D"), E("E")
}

fun generateFakeProduct()=Product(
    name = "Agents of Shield",
    publisher = "Marvel",
    episodes = "136 épisodes",
    date = "2013",
    nutriScore = NutriScore.E,
    barcode = "323155122",
    thumbnail = "https://m.media-amazon.com/images/I/71bTc9F1q+L._AC_UF1000,1000_QL80_.jpg",
    quantity = "400g",
    countries = listOf("France", "Japon", "Suisse"),
    ingredients = listOf(
        "Petis poids 66%",
        "Eau",
        "Garniture 2,8% (salade oignon grelots)",
        "Sucre",
        "Sel",
        "Arôme naturel"
    ),
    allergens = emptyList(),
    additives = emptyList(),
)