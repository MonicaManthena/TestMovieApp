package com.test.application.remote.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.application.data.MovieDetail
import com.test.application.remote.services.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MovieDetailRepository"

class MovieDetailRepository(private val api: MovieApi)
{
    private val movieDetail = MutableLiveData<MovieDetail>()

    fun getMovieDetails(title: String): LiveData<MovieDetail>
    {
        api.getMovieDetails(title)?.enqueue(object : Callback<MovieDetail>
        {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>)
            {
                Log.d(TAG, "onResponse")
                when (response.isSuccessful)
                {
                    true ->
                    {
                        Log.d(TAG, "onResponse:: Success")
                        movieDetail.value = response.body()
                    }
                    false ->
                    {
                        Log.d(TAG, "onResponse:: fail")
                    }
                }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable)
            {
                Log.e(TAG, "onFailure", t)
            }
        })
        return movieDetail
    }
}