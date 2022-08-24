package com.example.paises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.paises.databinding.ActivityMainBinding
import com.example.paises.models.PaisModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val lAdapter = ItemLinhaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecylcer()
    }

    private fun setupRecylcer() {
        binding.rvPaises.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val paises = mutableListOf<PaisModel>()
        paises.add(PaisModel("Brasil", "Ámerica"))
        paises.add(PaisModel("Estados Unidos", "Ámerica"))
        paises.add(PaisModel("China", "Ásia"))
        paises.add(PaisModel("China", "Ásia"))
        paises.add(PaisModel("Reino Unido", "Europa"))
        lAdapter.setLista(paises)
        binding.rvPaises.adapter = lAdapter
    }
}