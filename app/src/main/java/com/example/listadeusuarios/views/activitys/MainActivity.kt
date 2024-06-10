package com.example.listadeusuarios.views.activitys

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadeusuarios.R
import com.example.listadeusuarios.databinding.ActivityMainBinding
import com.example.listadeusuarios.databinding.ItemlistadousuariosBinding
import com.example.listadeusuarios.viewmodels.ListadodeUsuariosGeneralViewModel

class MainActivity : AppCompatActivity() {

    lateinit var listadoGeneralViewmodel:ListadodeUsuariosGeneralViewModel
lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val  usuario1 = AdaptadorUsuarios()


        binding.mainRecyclerView.adapter= usuario1

        listadoGeneralViewmodel=ViewModelProvider(this).get(ListadodeUsuariosGeneralViewModel::class.java)
        listadoGeneralViewmodel.listadousuario_ld.observe(this){
          usuario1.usuarioslist = it






            Log.i("Main Activity", it.toString())
        }

    }
}