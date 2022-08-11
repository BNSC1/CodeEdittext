package com.bn.codeedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bn.codeedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btn.setOnClickListener {
                codeEdit.codeLength+=1
            }
        }
    }
}