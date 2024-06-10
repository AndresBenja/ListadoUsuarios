package com.example.listadeusuarios.api.service

import com.example.listadeusuarios.models.UsuarioResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuarioInterfasService {
    //aqui se trae al listado de usuario de la API
    @GET("users")
suspend fun traertodoslosusuarios():MutableList<UsuarioResponse>

// aqui se trae a un usuario especifico

    @GET("users/{id}")
  suspend fun traerusuarioespecifico(@Path("id")idusuario:Int):UsuarioResponse

}