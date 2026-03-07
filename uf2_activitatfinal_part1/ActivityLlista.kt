package com.example.uf2_activitatfinal_part1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ActivityLlista : AppCompatActivity() {
    var cases = ArrayCases.casas
    // inicialitzem l'adaptor
    var casesAdaptador : Adaptador = Adaptador(cases)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llista)
/*
        // Recuperar la llista de cases de les Shared
        val sharedPreferences = getSharedPreferences("informacio_cases", Context.MODE_PRIVATE)
        var gson = Gson()
        val json = sharedPreferences.getString("casesList", null)
        val type : Type = object : TypeToken<ArrayList<Casa>>() {}.type
        cases = if (json != null) {
            gson.fromJson(json, type)
        } else {
            ArrayList()
        }
*/

/*
        val casa1 = Casa("palamos","Carrer Blau,1","600.000€",41.45,3.12,"casa1")
        val casa2 = Casa("palamos","Avinguda Palamós,6","450.000€",42.1,3.16,"casa2")
        val casa3 = Casa("palamos","Passeig del Sol,14","250.000€",41.78,3.2,"casa3")
        val casa4 = Casa("palamos","Carrer Lila,32","290.000€",41.36,3.14,"casa4")

        cases.add(casa1)
        cases.add(casa2)
        cases.add(casa3)
        cases.add(casa4)
*/

        // Asegurarse de inicializar las casas antes de mostrar la lista
        ArrayCases.inicializarCasas()
        // Actualiza el adaptador con las casas recuperadas
        casesAdaptador = Adaptador(cases)  // Crear un nuevo adaptador con la lista de casas recuperadas

// Configurar el RecyclerView
        val llista: RecyclerView = findViewById(R.id.llista)
        llista.layoutManager = LinearLayoutManager(this)
        llista.adapter = casesAdaptador


        val navView: BottomNavigationView =findViewById(R.id.barraNave)
        navView.menu.findItem(R.id.menuFotos).isChecked = true
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    val intent = Intent(this,MainActivity::class.java).apply{
                    }
                    startActivity(intent)
                    true
                }
                R.id.menuAdd -> {
                    val intent = Intent(this,ActivityFormulari::class.java).apply{
                    }
                    startActivity(intent)
                    true
                }
                R.id.menuFotos -> {
                    Toast.makeText(this, "Ja estàs en aquesta pestanya", Toast.LENGTH_SHORT).show()

                    true
                }

                else -> false
            }
        }

    }
}