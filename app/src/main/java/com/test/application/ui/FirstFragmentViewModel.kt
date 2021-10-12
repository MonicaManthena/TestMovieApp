package com.test.application.ui

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.test.application.MyApplication
import com.test.application.data.MovieDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.LiveData

import android.app.Application

import androidx.annotation.NonNull
import com.test.application.remote.repo.MovieDetailRepository


class FirstFragmentViewModel(private val application: MyApplication) : AndroidViewModel(application) {
    private val mMovieDetailRepository : MovieDetailRepository

/*    val allMovieDetails: LiveData<List<MovieDetail>>
        get() = mMovieDetailRepository.getMovieDetails("car")*/

    init {
        mMovieDetailRepository = MovieDetailRepository(application.getMovieApi())
    }
    fun getMovieDetails(query : String): LiveData<MovieDetail> {
        return mMovieDetailRepository.getMovieDetails(query)
    }
}