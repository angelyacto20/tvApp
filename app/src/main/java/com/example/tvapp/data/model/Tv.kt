package com.example.tvapp.data.model

data class Tv(
    val poster_path : String = "",
    val backdrop_path : String = "",
    val first_air_date : String = "",
    val genre_ids : List<Int> = listOf(),
    val popularity : Double = -1.0,
    val id : Int  = -1,
    val vote_average : Double = -1.0 ,
    val overview : String = "",
    val origin_country : List<String> = listOf(),
    val original_language : String = "",
    val vote_count : Int = -1 ,
    val name : String = "",
    val original_name : String = ""


)

data class TvList(val results : List<Tv> = listOf())
