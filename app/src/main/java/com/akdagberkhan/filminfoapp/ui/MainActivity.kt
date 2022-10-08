package com.akdagberkhan.filminfoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.akdagberkhan.filminfoapp.R
import com.akdagberkhan.filminfoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //MainActivty'de ViewBinding kullanmak için
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // binding içerisine layoutInflater ın statik bir örneğini alıyoruz
        setContentView(binding.root) //top level view ögesine erişmek için binding.root ekliyoruz.

        setNavController()
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
    }

}