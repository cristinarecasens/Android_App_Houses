package com.example.uf2_activitatfinal_part1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {

    var registrat : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //LLEGIR LES SHARED
        val sharedPref = getSharedPreferences("sharedRegistre", Context.MODE_PRIVATE)
        registrat=sharedPref.getBoolean("registrat",false)

        if(!registrat) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, RegistrerActivity::class.java))
                finish()
            }, 5000)
        }else{
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 5000)
        }

    }
}