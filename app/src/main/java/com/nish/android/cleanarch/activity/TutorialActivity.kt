package com.nish.android.cleanarch.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.databinding.ActivityTutorialBinding
import com.nish.android.cleanarch.viewmodel.TutorialViewModel
import com.nish.android.core.BaseActivity
import dagger.android.AndroidInjection

class TutorialActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding : ActivityTutorialBinding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial)
        val tutorialViewModel = ViewModelProviders.of(this).get(TutorialViewModel::class.java)
        binding.viewmodel = tutorialViewModel
    }

}
