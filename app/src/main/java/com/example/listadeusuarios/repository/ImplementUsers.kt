package com.example.listadeusuarios.repository

import com.example.listadeusuarios.api.retrofit.RetrofitHelper
import com.example.listadeusuarios.api.service.UsuarioInterfasService
import com.example.listadeusuarios.models.UsuarioResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplementUsers : InterfasUsers {

    var usuarioServicio= RetrofitHelper.getRetrofit().create(UsuarioInterfasService::class.java)

    override suspend fun traertodoslosusuarios(): MutableList<UsuarioResponse> {
        //esta es una corrutina
        return withContext(Dispatchers.IO) {
            //esta es la corutina que va siempre
            val userlist = usuarioServicio.traertodoslosusuarios()
            userlist

        }
    }

    override suspend fun traerusuarioespecifico(usuarioid: Int): UsuarioResponse {
        return withContext(Dispatchers.IO) {
            val user = usuarioServicio.traerusuarioespecifico(usuarioid)
            user
        }


    }


}