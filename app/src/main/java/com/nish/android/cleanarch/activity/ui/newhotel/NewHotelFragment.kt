package com.nish.android.cleanarch.activity.ui.newhotel

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.databinding.NewHotelFragmentBinding
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.viewmodel.HotelViewModel

class NewHotelFragment : Fragment() {

    private lateinit var viewModel: NewHotelViewModel
    private lateinit var sharedViewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(NewHotelViewModel::class.java)

        val binding = DataBindingUtil.inflate<NewHotelFragmentBinding>(
            inflater, R.layout.comment_fragment, container, false
        )
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(HotelViewModel::class.java)
        }
        observeComments()
    }

    private fun observeComments() {
        sharedViewModel.fetchComments().observe(this, Observer {
            it?.let {
                populateComment(it)
            }
        })
    }

    private fun populateComment(list: List<Comment>) {
        //TODO
    }
}
