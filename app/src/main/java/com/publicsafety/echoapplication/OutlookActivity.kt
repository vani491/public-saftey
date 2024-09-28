package com.publicsafety.echoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.publicsafety.echoapplication.databinding.ActivityClassBinding
import com.publicsafety.echoapplication.databinding.ActivityEntryBinding
import com.publicsafety.echoapplication.databinding.ActivityMainBinding
import com.publicsafety.echoapplication.databinding.ActivityOutlookBinding
import kotlin.math.roundToInt

class OutlookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutlookBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize the binding
        binding = ActivityOutlookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.entry)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        navigationHandler()
    }


    //handle click event
    private fun navigationHandler() {
        binding.backButton.setOnClickListener {
            navigateHandler()
        }
        binding.nextButton.setOnClickListener {
            navigateToResult()
        }
    }

    //handle navigation event
    private fun navigateHandler() {
        finish();
    }

    private fun navigateToResult() {
        val intent = Intent(applicationContext, ResultActivity::class.java)
        startActivity(intent)
    }


}