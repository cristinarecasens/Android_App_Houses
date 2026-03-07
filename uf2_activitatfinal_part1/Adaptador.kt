package com.example.uf2_activitatfinal_part1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adaptador(private val cases: ArrayList<Casa>) : RecyclerView.Adapter<Adaptador.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyrcle_view_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val casa = cases[position]
        holder.adrecaTextView.text = casa.adreca
        holder.preuTextView.text= casa.preu

        // Obtener el nombre de la imagen almacenada como String (por ejemplo, "casa1")
        val imageName: String = casa.imatge  // "casa1"

        // Obtener el contexto desde el itemView
        val context = holder.itemView.context

        // Obtener el identificador del recurso drawable utilizando el nombre de la imagen
        val resourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)

        // Si se encuentra el recurso, cargar la imagen desde los recursos
        if (resourceId != 0) {
            holder.imageView.setImageResource(resourceId)
        } else {
            // Maneja el caso en el que no se encuentre la imagen (opcional)
            holder.imageView.setImageResource(R.drawable.house_icon)  // Una imagen predeterminada
        }

        // Establecer el click listener en el itemView para abrir la actividad
        holder.itemView.setOnClickListener {
            // Crear un Intent para abrir la actividad ActivityInfo
            val intent = Intent(context, InfoActivity::class.java)

            // Pasar los datos de la casa seleccionada a la nueva actividad
            intent.putExtra("adreca", casa.adreca)
            intent.putExtra("preu", casa.preu)
            intent.putExtra("lat", casa.lat)
            intent.putExtra("long", casa.long)
            intent.putExtra("imatge", casa.imatge)

            // Iniciar la actividad
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = cases.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imatgeRV)
        val preuTextView: TextView = itemView.findViewById(R.id.textPreuRV)
        val adrecaTextView: TextView = itemView.findViewById(R.id.textAdressRV)
    }
}