package com.example.uf2_activitatfinal_part1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ActivityFormulari : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulari)

        val botoAgregar: Button = findViewById(R.id.botoGuardar)
        val spinnerPoblacio: Spinner = findViewById(R.id.spinnerPoblacio)
        val editAdreca: EditText = findViewById(R.id.editAdrecaForm)
        val editPreu: EditText = findViewById(R.id.editPreuForm)
        val editLat: EditText = findViewById(R.id.editLatForm)
        val editLong: EditText = findViewById(R.id.editLongForm)
        var poblacioSeleccionada: String = ""

        val poblacionsArray = resources.getStringArray(R.array.poblacions_array)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.colors_spinner, poblacionsArray)

        // Asignar el adapter al spinner
        spinnerPoblacio.adapter = adapter

        botoAgregar.setOnClickListener {
            // Crear una nueva casa
            var textLat = editLat.text.toString()
            var numLat = textLat.toDoubleOrNull()

            var textLong = editLong.text.toString()
            var numLong = textLong.toDoubleOrNull()


            // Validar que las coordenadas no sean nulas
            if (numLat == null || numLong == null) {
                // Mostrar un mensaje de error si alguna de las coordenadas es inválida
                Toast.makeText(this, "Les coordenades no són correctes", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Crear una nueva casa solo si las coordenadas son válidas
                val nuevaCasa = Casa(
                    poblacioSeleccionada,
                    editAdreca.text.toString(),
                    editPreu.text.toString() + "€",
                    numLat,
                    numLong,
                    "casa0"
                )

                // Agregar la casa al ArrayList global de casas
                ArrayCases.casas.add(nuevaCasa)



                /*
                // Afegim la casa a les shareds
                val sp = getSharedPreferences("informacio_cases", Context.MODE_PRIVATE)
                val editor = sp.edit()

                // Recuperar la lista de casas almacenada anteriormente (si existe)
                val gson = Gson()
                val json = sp.getString("casesList", null)
                val casesListType = object : TypeToken<ArrayList<Casa>>() {}.type
                val casesList: ArrayList<Casa> = if (json != null) {
                    gson.fromJson(json, casesListType)  // Convertir el JSON a ArrayList<Casa> si existe
                } else {
                    ArrayList()  // Si no existe, crear una nueva lista vacía
                }

                // Agregar la nueva casa a la lista
                casesList.add(nuevaCasa)

                // Convertir de nuevo la lista a JSON
                val updatedJson = gson.toJson(casesList)

                // Guardar la lista actualizada en SharedPreferences
                editor.putString("casesList", updatedJson)
                editor.apply()
                */
                Toast.makeText(this, "Casa guardada amb èxit!", Toast.LENGTH_SHORT)
                    .show()


            }


            spinnerPoblacio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // Ignorar el primer ítem
                    if (position != 0) {
                        // Obtener el nombre de la población seleccionada
                        poblacioSeleccionada = parent?.getItemAtPosition(position).toString()

                        (parent!!.getChildAt(0) as TextView).setTextColor(Color.WHITE)


                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // No hacer nada si no se selecciona ningún ítem
                }
            }



        }

        val navView: BottomNavigationView = findViewById(R.id.barraNave)
        navView.menu.findItem(R.id.menuAdd).isChecked = true
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    val intent = Intent(this, MainActivity::class.java).apply {
                    }
                    startActivity(intent)
                    true
                }

                R.id.menuAdd -> {
                    Toast.makeText(this, "Ja estàs en aquesta pestanya", Toast.LENGTH_SHORT)
                        .show()
                    true
                }

                R.id.menuFotos -> {
                    val intent = Intent(this, ActivityLlista::class.java).apply {
                    }
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}