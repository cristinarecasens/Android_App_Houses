package com.example.uf2_activitatfinal_part1

import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class InfoActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


       var imatgeCasa : ImageView =findViewById(R.id.imatgeCasaInfo)
        var textAdreca : TextView = findViewById(R.id.textAdrecaInfo)
        var textPreu: TextView = findViewById(R.id.textPreuInfo)

        //recollo els intents per posar la foto
        val adreca = intent.getStringExtra("adreca").toString()
        var preu= intent.getStringExtra("preu").toString()
        val foto = intent.getStringExtra("imatge").toString()


        textAdreca.text=adreca
        textPreu.text=preu
        // Obtener el identificador del recurso drawable utilizando el nombre de la imagen
        val resourceId = this.resources.getIdentifier(foto, "drawable", this.packageName)

        // Si se encuentra el recurso, cargar la imagen desde los recursos
        if (resourceId != 0) {
            imatgeCasa.setImageResource(resourceId)
        } else {
            // Maneja el caso en el que no se encuentre la imagen (opcional)
            imatgeCasa.setImageResource(R.drawable.house_icon)  // Una imagen predeterminada
        }


        mapView=findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }




    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val adreca = intent.getStringExtra("adreca").toString()
        val lat = intent.getDoubleExtra("lat",0.0)
        val long = intent.getDoubleExtra("long",0.0)
        val marcador = LatLng (lat, long)

        mMap.addMarker(MarkerOptions().position(marcador).title(adreca))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marcador, 15f))
    }

}