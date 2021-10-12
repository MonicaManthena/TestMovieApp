package com.test.application

import android.app.Application
import com.test.application.remote.RetrofitClientInstance
import com.test.application.remote.services.MovieApi

class MyApplication: Application()
{

    private var apiClient = RetrofitClientInstance()
    private var movieApi: MovieApi? = null

    override fun onCreate()
    {
        super.onCreate()
    }

    fun getMovieApi(): MovieApi
    {
        if (movieApi == null)
        {
            movieApi = apiClient.getRetrofitInstance().create(MovieApi::class.java)
        }
        return movieApi!!
    }
}