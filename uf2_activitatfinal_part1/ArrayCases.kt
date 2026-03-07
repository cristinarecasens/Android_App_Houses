package com.example.uf2_activitatfinal_part1

object ArrayCases {
    var casas: ArrayList<Casa> = ArrayList()
    var inicializado: Boolean = false

    // Mètode per inicialitzar les cases només al principi
    fun inicializarCasas() {
        if (!inicializado) {
            val casa1 = Casa("Palamós", "Carrer Blau, 1", "600.000€", 41.853, 3.118, "casa1")
            val casa2 = Casa("Palamós", "Avinguda Palamós, 6", "450.000€", 41.854, 3.102, "casa2")
            val casa3 = Casa("Palamós", "Passeig del Sol, 14", "250.000€", 41.8561, 3.1128, "casa3")
            val casa4 = Casa("Palamós", "Carrer Lila, 32", "290.000€", 41.861, 3.121, "casa4")
            val casa5 = Casa("Palamós", "Carrer Blanc, 102", "380.000€", 41.86002, 3.119, "casa5")
            val casa6 = Casa("Palamós", "Avinguda del Mar, 10", "190.000€", 41.859, 3.1113, "casa6")

            // Agregar las casas a la lista
            casas.add(casa1)
            casas.add(casa2)
            casas.add(casa3)
            casas.add(casa4)
            casas.add(casa5)
            casas.add(casa6)

            // Marcar como inicializado
            inicializado = true
        }
    }
}