package com.test.application.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.application.MyApplication
import com.test.application.R.layout
import com.test.application.adapter.RecyclerViewAdapter
import com.test.application.data.MovieDetail
import com.test.application.databinding.FragmentFirstBinding
import com.test.application.ui.factory.FirstFragmentModelFactory
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment()
{

    lateinit var binding: FragmentFirstBinding

//    private val viewModel: FirstFragmentViewModel by viewModels { FirstFragmentModelFactory(requireActivity().application as MyApplication) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, layout.fragment_first, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //creating an arraylist to store movies list
        val moviesList = ArrayList<MovieDetail>()

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            activity, RecyclerView.VERTICAL, false
        )
        recyclerview!!.layoutManager = linearLayoutManager
        recyclerview!!.setHasFixedSize(true)
        var adapter = RecyclerViewAdapter(moviesList)
        recyclerview.adapter = adapter
        ///init the View Model
//        val viewModel: FirstFragmentViewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)
        val viewModel: FirstFragmentViewModel =
            ViewModelProvider(this, FirstFragmentModelFactory(application = MyApplication())).get(
                FirstFragmentViewModel::class.java
            )

        /* binding.buttonFirst.setOnClickListener {
             findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
         }*/

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val progressDialog = ProgressDialog(activity)
                progressDialog.setTitle("Please Wait")
                progressDialog.show()
                //Performs search when user hit the search button on the keyboard
                // Observe the model
                activity?.let {
                    if (query != null) {
                        viewModel.getMovieDetails(query).observe(it, Observer { movieDetail ->
                            // Data bind the recycler view
                            moviesList.clear()
                            moviesList.add(movieDetail)
                            recyclerview.adapter = RecyclerViewAdapter(moviesList)
                            adapter.notifyDataSetChanged()
                            progressDialog.dismiss()
                        })
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    companion object
    {
        private const val TAG = "FirstFragment"
    }
}