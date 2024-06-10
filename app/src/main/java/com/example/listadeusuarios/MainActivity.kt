package com.example.listadeusuarios

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listadeusuarios.api.retrofit.RetrofitHelper
import com.example.listadeusuarios.api.service.UsuarioInterfasService
import com.example.listadeusuarios.viewmodels.ListadodeUsuariosGeneralViewModel

class MainActivity : AppCompatActivity() {

    lateinit var listadoGeneralViewmodel:ListadodeUsuariosGeneralViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listadoGeneralViewmodel=ViewModelProvider(this).get(ListadodeUsuariosGeneralViewModel::class.java)
        listadoGeneralViewmodel.listadousuario_ld.observe(this){
            Log.i("Main Activity", it.toString())
        }

    }
}