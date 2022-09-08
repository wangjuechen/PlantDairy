package com.jc.android.plantdairy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jc.android.plantdairy.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}