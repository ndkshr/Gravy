package com.instance.gravy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.instance.gravy.R
import com.instance.gravy.databinding.ActivityAddNotesBinding

class AddNotesActivity: AppCompatActivity() {

    lateinit var binding: ActivityAddNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_notes)
    }
}
