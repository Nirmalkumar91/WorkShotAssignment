package com.nish.android.cleanarch.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.databinding.ActivityMainBinding
import com.nish.android.cleanarch.viewmodel.CommentsAdapter
import com.nish.android.core.BaseActivity
import com.nish.android.cleanarch.viewmodel.MainViewModel
import dagger.android.AndroidInjection

import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        lifecycle.addObserver(mainViewModel)
        binding.viewmodel = mainViewModel
        CommentsAdapter().let {
            mainViewModel.adapter = it
            binding.commentList.adapter = it
        }

        registerEvents(mainViewModel)
    }

    private fun registerEvents(viewModel: MainViewModel) {
        registerNavigationEvent(viewModel)
    }
}
