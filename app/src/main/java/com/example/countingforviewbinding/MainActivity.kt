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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val counter = Counter()

        binding.counter = counter;

        binding.btnIncrease.setOnClickListener {
            counter.count++
        }

        binding.btnDecrease.setOnClickListener {
            counter.count--
        }
        binding.btnReset.setOnClickListener {
            counter.count = 0
        }
    }
}