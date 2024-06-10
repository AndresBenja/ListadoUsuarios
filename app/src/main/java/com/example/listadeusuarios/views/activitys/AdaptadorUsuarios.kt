package com.example.listadeusuarios.views.activitys

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadeusuarios.databinding.ItemlistadousuariosBinding
import com.example.listadeusuarios.models.UsuarioResponse
import com.squareup.picasso.Picasso

//aqui se crea una lista o colecciones
class AdaptadorUsuarios:RecyclerView.Adapter <AdaptadorUsuarios.ViewHolder>() {
    //esta es una funcion que no devuelve nada va a detectar el click
    lateinit var onItemClickListener:(UsuarioResponse) ->Unit

    //aqui se declara
    var usuarioslist= mutableListOf<UsuarioResponse>()
        //aqui se llena la lista
        set(value) {
            field=value
            this.notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorUsuarios.ViewHolder {
        //aqui se crea el binding para poder pintar la fila conexion del xml con el code
        val binding=ItemlistadousuariosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AdaptadorUsuarios.ViewHolder, position: Int) {
        //Aqui envio la posicion del perro u objeto del listado
        val usuario:UsuarioResponse=usuarioslist[position]
        holder.binusuario(usuario)
    }

    override fun getItemCount(): Int {
        //aqui se devuelve el tamaño de la lista
        return usuarioslist.size
    }
    //un adaptador siempre va acompañado de un viewholder
    //se declara una clase y se crea dentro un viewHolder y le pasamos el bindig
    inner class ViewHolder(private val binding: ItemlistadousuariosBinding):RecyclerView.ViewHolder(binding.root){
        //aqui se hace referncia al XML para pintar
        fun binusuario(usuario:UsuarioResponse) {
            //aqui se hace la referencia al binding de el xml
            binding.idusuario.text=usuario.id.toString()
            binding.nombreusuario.text= usuario.name
            binding.direccion.text= usuario.address.street
            //se limpia el fondo por defecto
            binding.website.text= usuario.website


            //quiero que toda la fila sea clickeable
            binding.root.setOnClickListener{
                //si la funcion esta inicializada
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(usuario)

            }


        }
    }

}