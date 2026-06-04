package com.example.countingforviewbinding

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.countingforviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        sharedPreferences = getSharedPreferences("counterPrefs",MODE_PRIVATE)

        val savedCount = sharedPreferences.getInt("count",0)

        val savedUsername = sharedPreferences.getString("username","siddu")

        val counter = Counter()

        counter.count = savedCount
        counter.username = savedUsername ?:"Siddu"

        binding.counter = counter;

        binding.btnIncrease.setOnClickListener {
            counter.count++
            binding.invalidateAll()
            saveData(counter)
        }

        binding.btnDecrease.setOnClickListener {
            counter.count--
            binding.invalidateAll()
            saveData(counter)
        }
        binding.btnReset.setOnClickListener {
            counter.count = 0
            binding.invalidateAll()
        }
    }

    override fun onPause() {
        super.onPause()

        saveData(binding.counter!!)
    }

    private  fun saveData(counter: Counter) {
        sharedPreferences.edit()
            .putInt("count", counter.count)
            .putString("username", counter.username)
            .apply()
    }
}