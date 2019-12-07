package com.nish.android.cleanarch.activity.ui.newhotel

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nish.android.cleanarch.R
import androidx.databinding.DataBindingUtil
import com.nish.android.cleanarch.databinding.CommentFragmentBinding
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.viewmodel.HotelViewModel
import kotlinx.android.synthetic.main.comment_fragment.view.*

class CommentFragment : Fragment() {

    private lateinit var viewModel: CommentViewModel
    private lateinit var sharedViewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)

        val binding = DataBindingUtil.inflate<CommentFragmentBinding>(
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
    }
}
