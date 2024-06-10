package com.example.listadeusuarios.repository

import com.example.listadeusuarios.models.UsuarioResponse


interface InterfasUsers {
    suspend fun traertodoslosusuarios(): MutableList<UsuarioResponse>

    //los dos puntos son el retorno cuando esta afuera
    suspend fun traerusuarioespecifico(usuarioid: Int): UsuarioResponse

}