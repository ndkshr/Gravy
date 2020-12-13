package com.instance.gravy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.instance.gravy.R
import com.instance.gravy.databinding.ActivityMainBinding
import com.instance.gravy.utils.ViewModelFactory
import com.instance.gravy.viewmodel.GravyMainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class GravyMainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(GravyMainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        with (binding) {
            learningCard.setOnClickListener { showLearningProgress() }

            financialCard.setOnClickListener { showFinancialProgress() }

            mentalCard.setOnClickListener { showMentalProgress() }

            physicalCard.setOnClickListener { showPhysicalProgress() }

            leisureCard.setOnClickListener { showLeisureActivity() }
        }
    }

    private fun showLearningProgress() {

    }

    private fun showFinancialProgress() {

    }

    private fun showMentalProgress() {

    }

    private fun showPhysicalProgress() {

    }

    private fun showLeisureActivity() {

    }
}
