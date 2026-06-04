package com.example.countingforviewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.countingforviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val counter = Counter(
            count = 0,
            username = "siddu"
        )

        binding.counter = counter;

        binding.btnIncrease.setOnClickListener {
            count++
            counter.count = count
            binding.invalidateAll()
        }

        binding.btnDecrease.setOnClickListener {
            count--
            counter.count = count
            binding.invalidateAll()
        }
        binding.btnReset.setOnClickListener {

            count = 0

            counter.count = 0

            binding.invalidateAll()
        }
    }
}