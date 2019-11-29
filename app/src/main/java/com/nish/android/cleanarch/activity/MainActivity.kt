package com.nish.android.cleanarch.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.databinding.ActivityMainBinding
import com.nish.android.cleanarch.viewmodel.MainViewModel
import dagger.android.AndroidInjection

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = mainViewModel
    }

}
