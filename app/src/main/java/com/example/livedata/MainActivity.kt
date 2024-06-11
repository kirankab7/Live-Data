package com.example.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Observe the LiveData object
        viewModel.myLiveData.observe(this, Observer { data ->
            // Update UI with the new data
            binding.textView.text = data
        })
        binding.button.setOnClickListener {
            // Update the LiveData (this could be triggered by user interaction, network response, etc.)
            viewModel.updateData("New Data updated")
        }

    }
}