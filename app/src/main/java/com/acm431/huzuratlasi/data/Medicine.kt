package com.acm431.huzuratlasi.data

data class Medicine(
    val id: Int,
    val name: String,
    val dosage: String,
    val frequency: String,
    val time: String
)

// Sample data
val sampleMedicines = listOf(
    Medicine(1, "Aspirin", "500mg", "Günde 2 kez", "Sabah-Akşam"),
    Medicine(2, "Parol", "500mg", "Günde 3 kez", "Sabah-Öğle-Akşam"),
    Medicine(3, "Vitamin D", "1000IU", "Günde 1 kez", "Sabah")
) 