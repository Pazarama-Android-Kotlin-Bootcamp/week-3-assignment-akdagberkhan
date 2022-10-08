package com.akdagberkhan.filminfoapp.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akdagberkhan.filminfoapp.R
import com.akdagberkhan.filminfoapp.data.FilmModel
import com.akdagberkhan.filminfoapp.ui.fragments.FilmsMainFragment
import com.squareup.picasso.Picasso

class FilmAdapter(
    private val filmList: MutableList<FilmModel>,
    private val listener: FilmsMainFragment
) :
    RecyclerView.Adapter<FilmAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(filmList[position], listener)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvFilmName = view.findViewById<TextView>(R.id.tvFilmName)
        private val tvImdb = view.findViewById<TextView>(R.id.tvImdb)
        private val ivImg = view.findViewById<ImageView>(R.id.ivFilmImage)
        fun bind(film: FilmModel, listener: FilmsListener) {

            tvFilmName.text = film.filmName
            tvImdb.text = film.imdb
            Picasso.get().load(film.filmImg).into(ivImg);


            itemView.setOnClickListener {
                listener.onClicked(film)
            }

        }
    }
}

interface FilmsListener {
    fun onClicked(film: FilmModel)
}
