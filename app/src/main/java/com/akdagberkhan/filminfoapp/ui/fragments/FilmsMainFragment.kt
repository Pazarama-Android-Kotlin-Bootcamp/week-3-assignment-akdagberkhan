package com.akdagberkhan.filminfoapp.ui.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.akdagberkhan.filminfoapp.R
import com.akdagberkhan.filminfoapp.adapter.FilmAdapter
import com.akdagberkhan.filminfoapp.adapter.FilmsListener
import com.akdagberkhan.filminfoapp.data.FilmModel
import com.akdagberkhan.filminfoapp.data.mockFilmData

class FilmsMainFragment : Fragment(), FilmsListener {
    private lateinit var rvFilmList: RecyclerView
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        rvFilmList = view.findViewById(R.id.rvFilmList)
        setupAdapter()
    }

    private fun setupAdapter() {
        rvFilmList.adapter = FilmAdapter(mockFilmData, this@FilmsMainFragment)

    }

    override fun onClicked(film: FilmModel) {
        navController.navigate(R.id.action_filmListToDetail, Bundle().apply {
            putString("filmModel", film.toJson())
        })
    }
}