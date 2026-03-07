package com.example.uf2_activitatfinal_part1

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textSalutacio)

        // Recollim el nom
        val sharedPref = getSharedPreferences("sharedRegistre", Context.MODE_PRIVATE)
        val nomUsuari=sharedPref.getString("nomUsuari","Usuari")

        // posem el nom al text
        textView.text = "Hola $nomUsuari!"

        var barcelona: ImageView = findViewById(R.id.imatgeBcn)
        var besalu: ImageView = findViewById(R.id.imatgeBesalu)
        var cadaques: ImageView = findViewById(R.id.imatgeCadaques)
        var calonge: ImageView = findViewById(R.id.imatgeCalonge)
        var girona: ImageView = findViewById(R.id.imatgeGirona)
        var palamos: ImageView = findViewById(R.id.imatgePalamos)

        barcelona.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        besalu.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        cadaques.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        calonge.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        girona.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        palamos.setOnClickListener {
            val intent = Intent(this,ActivityLlista::class.java).apply{
            }
            startActivity(intent)
        }

        var botoLloguer : Button = findViewById(R.id.botoLloguer)
        var botoComprar : Button = findViewById(R.id.botoComprar)
        var botoNovetats : Button = findViewById(R.id.botoNovetats)
        var botoPreuBaix : Button = findViewById(R.id.botoPreuBaix)

        botoLloguer.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        botoComprar.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        botoNovetats.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }
        botoPreuBaix.setOnClickListener {
            Toast.makeText(this,"Opció no implementada", Toast.LENGTH_SHORT).show()
        }

        val navView: BottomNavigationView =findViewById(R.id.barraNave)
        navView.menu.findItem(R.id.menuHome).isChecked = true
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    Toast.makeText(this, "Ja estàs en aquesta pestanya", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menuAdd -> {
                    val intent = Intent(this,ActivityFormulari::class.java).apply{
                    }
                    startActivity(intent)
                    true
                }
                R.id.menuFotos -> {
                    val intent = Intent(this,ActivityLlista::class.java).apply{
                    }
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }


    }
}