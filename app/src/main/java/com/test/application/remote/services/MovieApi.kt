package com.test.application.remote.services

import com.test.application.data.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi
{
    @GET(".")
    fun getMovieDetails(@Query("t") title: String, @Query("apikey") apikey: String = "141f8d20"): Call<MovieDetail>?
}