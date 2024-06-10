package com.example.listadeusuarios.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeusuarios.api.retrofit.RetrofitHelper
import com.example.listadeusuarios.api.service.UsuarioInterfasService
import com.example.listadeusuarios.models.UsuarioResponse
import com.example.listadeusuarios.repository.ImplementUsers
import kotlinx.coroutines.launch

class ListadodeUsuariosGeneralViewModel:ViewModel() {
    private val repositoryUsuario=ImplementUsers()

    private val mutablelistusuarios= MutableLiveData<MutableList<UsuarioResponse>>()
    val listadousuario_ld: LiveData<MutableList<UsuarioResponse>>
        get()=mutablelistusuarios

    init {
        viewModelScope.launch {
            mutablelistusuarios.value=repositoryUsuario.traertodoslosusuarios()
        }

    }


}