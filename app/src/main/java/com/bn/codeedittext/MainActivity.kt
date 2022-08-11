package com.bn.codeedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bn.codeedittext.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            addDigitBtn.setOnClickListener {
                codeEdit.codeLength+=1
            }
            getInputBtn.setOnClickListener {
                Snackbar.make(root,codeEdit.getInput(),Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}