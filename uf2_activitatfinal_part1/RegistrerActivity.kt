package com.example.uf2_activitatfinal_part1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RegistrerActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    private lateinit var textNomUsuari: EditText
    private lateinit var textContrasenya: EditText
    private lateinit var nomUsuari: String
    private lateinit var contrasenya: String
    var usuaris= ArrayList<Usuari>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrer)

        textNomUsuari = findViewById(R.id.editNomRegistre)
        textContrasenya = findViewById(R.id.editContraRegistre)
        val botoRegistre: Button = findViewById(R.id.botoGuardar)

        // Iniciem la base de dades
        database = FirebaseDatabase.getInstance().getReference("usuaris")

        // Mètode per agafar les dades del firebase
        fetchContacts()

        // Botó per afegir un contacte a la base de dades i comprovar
        botoRegistre.setOnClickListener {
            nomUsuari = textNomUsuari.text.toString()
            var trobat = false
            var aux = 0

            while (!trobat && aux < usuaris.size) {
                if (usuaris[aux].nom == nomUsuari) {
                    trobat = true
                } else {
                    aux++
                }
            }

            if(trobat) {
                Toast.makeText(this@RegistrerActivity, "Aquest usuari ja existeix", Toast.LENGTH_SHORT).show()
            }else if(!trobat&&textContrasenya.text.toString().isNotEmpty()) {
                Toast.makeText(this@RegistrerActivity, "Usuari creat amb èxit", Toast.LENGTH_SHORT).show()
                //SI S'ENVIEN SENSE HABER LLEGIT ABANS:  (Activitat 5)
                val sharedPreferences: SharedPreferences = getSharedPreferences("sharedRegistre", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                editor.putBoolean("registrat", true)
                editor.putString("nomUsuari",nomUsuari)
                editor.apply()

                val intent = Intent(this,MainActivity::class.java).apply{
                }
                startActivity(intent)

            }else if(!trobat&&textContrasenya.text.toString().isEmpty()){
                Toast.makeText(this@RegistrerActivity, "La contrasenya està buida", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun fetchContacts() {
        // Obtenim les dades
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            // Es retornen dades
            override fun onDataChange(snapshot: DataSnapshot) {
                // Recorrem cada document "registre" dintre de la "taula"
                for (contactSnapshot in snapshot.children) {
                    // Convertim el "registre" actual a un objecte Contact
                    val usuari = contactSnapshot.getValue(Usuari::class.java)
                    if (usuari != null) {
                        usuaris.add(usuari)
                    }
                }
            }
            // Si error
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RegistrerActivity, "No connexió", Toast.LENGTH_SHORT).show()
            }
        })
    }


}