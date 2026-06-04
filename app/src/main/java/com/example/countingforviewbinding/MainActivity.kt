package com.example.countingforviewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.countingforviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIncrease.setOnClickListener {
            count++
            binding.tvCount.text = "Count: $count"
        }

        binding.btnReset.setOnClickListener {
            count = 0
            binding.tvCount.text = "Count: $count"
        }
    }
}