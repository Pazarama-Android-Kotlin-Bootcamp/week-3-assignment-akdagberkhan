package com.akdagberkhan.filminfoapp.data

import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmModel(
    val id: String,
    val filmName: String,
    val imdb: String,
    val studio: String,
    val info: String,
    val filmImg: String,
) : Parcelable {
    fun toJson(): String {
        return Gson().toJson(this)
    }
    companion object {
        fun fromJson(jsonValue: String): FilmModel {
            return Gson().fromJson(jsonValue, FilmModel::class.java)
        }
    }
}
val mockFilmData = mutableListOf<FilmModel>(
    FilmModel(
        "1",
        "Captain Marvel",
        "Imdb : 6,8",
        "Marvel",
        "Film, Carol Danvers'ın Captain Marvel'a dönüşümünden değil, Carol Danvers'ın Captain Marvel olarak dünyaya düşüşünden ilerliyor. Süper güçlere sahip, güzel bir kadın olarak dünyaya düşen Carol Danvers, gezegeni keşfettikçe kimi görüntüler hatırlamaya başlar.",
        "https://i.hizliresim.com/6dqa1l5.jpg"
    ),
    FilmModel(
        "2",
        "Jurassic World",
        "Imdb : 6,9",
        "Universal Studio",
        "Jurassic World, Colin Trevorrow tarafından yönetilen 2015 yapımı ABD bilimkurgu macera filmi. Jurassic Park serisinin dördüncü filmidir. Senaryosu Rick Jaffa, Amanda Silver, Derek Connolly ve Trevorrow tarafından yazıld",
        "https://i.hizliresim.com/ila42zt.jpg"
    ),
    FilmModel(
        "3",
        "Aquaman",
        "Imdb : 6,8",
        "Warner Bros. Pictures",
        "Amfibi süper kahraman Arthur Curry, Atlantis kralının yüzeydeki dünyaya savaş açmasını engellemek zorunda kaldığında Aquaman olmanın anlamını öğrenir. Canınız neyi isterse izleyin. Jason Momoa, üç uçlu mızrağıyla bu çıkış öyküsünün dünya genelinde 1 milyar doları aşkın hasılat elde etmesini sağladı.",
        "https://i.hizliresim.com/nzd850i.jpg"
    ),
    FilmModel(
        "4",
        "Test Film",
        "Imdb : 5,5",
        "asdfghj Studio",
        "This is the mobile app design for buying Movie tickets in advance.\n" +
                "\n" +
                "Booking tickets are now an effortless, fun and exciting experience.\n" +
                "\n" +
                "\n",
        "https://www.hizliresim.com/upload-success"
    ),
    FilmModel(
        "5",
        "Test Film 2",
        "Imdb : 7,5",
        "asdf Films",
        "Made for Figma design\n" +
                "Last updated 4 months ago\n" +
                "Licensed under ",
        "https://i.hizliresim.com/nzd850i.jpg"
    ),
)