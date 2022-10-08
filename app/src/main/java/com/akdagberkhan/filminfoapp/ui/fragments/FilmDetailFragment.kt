package com.akdagberkhan.filminfoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.akdagberkhan.filminfoapp.R
import com.akdagberkhan.filminfoapp.data.FilmModel
import com.squareup.picasso.Picasso

class FilmDetailFragment : Fragment() {

    private lateinit var tvFilmName: TextView
    private lateinit var tvImdb: TextView
    private lateinit var tvStudio: TextView
    private lateinit var tvInfo: TextView
    private lateinit var ivImage: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(view)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_detail, container, false)
    }


    private fun setupViews(view: View) {
        tvFilmName = view.findViewById(R.id.tvFilmName)
        tvImdb = view.findViewById(R.id.tvImdb)
        tvStudio = view.findViewById(R.id.tvStudio)
        tvInfo = view.findViewById(R.id.tvInfo)
        ivImage = view.findViewById(R.id.ivFilmImage)
        arguments?.let {
            val filmData = it.getString("filmModel")

            filmData?.let { safeFilmData ->
                val film = FilmModel.fromJson(safeFilmData)

                tvFilmName.text = film.filmName
                tvImdb.text = film.imdb
                tvStudio.text = film.studio
                tvInfo.text = film.info
                Picasso.get().load(film.filmImg).into(ivImage);

            }
        }
    }
}