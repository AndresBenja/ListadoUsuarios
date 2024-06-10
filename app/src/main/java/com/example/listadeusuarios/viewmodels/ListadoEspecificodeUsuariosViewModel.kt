package com.example.listadeusuarios.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeusuarios.models.UsuarioResponse
import com.example.listadeusuarios.repository.ImplementUsers
import kotlinx.coroutines.launch

    class ListadodeUsuariosEspecificoViewModel: ViewModel() {
        private val repositoryUsuario = ImplementUsers()
        private val usuarioespecifico = MutableLiveData<UsuarioResponse>()
        val usuarioespecifico_ld: LiveData<UsuarioResponse>
            get() = usuarioespecifico


        fun traerusuarioespecifico(idusuarioespecifico: Int) {

            viewModelScope.launch {
                var usuarioespecial = repositoryUsuario.traerusuarioespecifico(idusuarioespecifico)
                usuarioespecifico.value=usuarioespecial
            }

        }

    }






