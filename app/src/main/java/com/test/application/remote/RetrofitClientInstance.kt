package com.test.application.remote

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance
{
    private var retrofit: Retrofit? = null
    private val BASE_URL = "http://www.omdbapi.com/"

    fun getRetrofitInstance(): Retrofit
    {
        if(retrofit == null)
            retrofit = Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit!!
    }

}