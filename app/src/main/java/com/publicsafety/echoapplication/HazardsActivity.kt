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
import com.publicsafety.echoapplication.databinding.ActivityHazardsBinding
import com.publicsafety.echoapplication.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class HazardsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHazardsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize the binding
        binding = ActivityHazardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.entry)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Adding a listener to handle snap-to-nearest-point
        binding.flowSpeedSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // No action required during dragging
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No action required when touch starts
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.let {
                    val progress = it.progress
                    // Snap to the nearest point (0-6)
                    val nearestPoint = (progress / 1.0).roundToInt()
                    it.progress = nearestPoint
                }
            }
        })

        navigationHandler()
    }


    //handle click event
    private fun navigationHandler() {
        binding.backButton.setOnClickListener {
            finish();
        }

        binding.nextButton.setOnClickListener {
            navigateToHazards()
        }
    }



    //handle navigation event
    private fun navigateToHazards() {
        val intent = Intent(applicationContext, HazardsActivity::class.java)
        //
    // startActivity(intent)
    }


}