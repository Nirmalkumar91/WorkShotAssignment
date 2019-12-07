package com.nish.android.cleanarch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.activity.ui.newhotel.HotelPagerAdapter
import com.nish.android.cleanarch.activity.ui.newhotel.NewHotelFragment
import com.nish.android.cleanarch.databinding.NewHotelActivityBinding
import com.nish.android.cleanarch.viewmodel.HotelViewModel
import com.nish.android.core.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class NewHotelActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: HotelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding : NewHotelActivityBinding = DataBindingUtil.setContentView(this, R.layout.new_hotel_activity)
        lifecycle.addObserver(viewModel)
        binding.viewmodel = viewModel

        HotelPagerAdapter(this.supportFragmentManager).let {
            binding.pager.adapter = it
        }
        binding.tabLayout.setupWithViewPager(binding.pager)
    }
}
