package com.test.application.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.application.MyApplication
import com.test.application.ui.FirstFragmentViewModel

class FirstFragmentModelFactory(private val application: MyApplication) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(FirstFragmentViewModel::class.java))
        {
            return FirstFragmentViewModel(application) as T
        }
        throw IllegalArgumentException("UnknownViewModel")
    }
}