package com.publicsafety.echoapplication

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.publicsafety.echoapplication.databinding.ActivityClassBinding
import com.publicsafety.echoapplication.databinding.ActivityEntryBinding
import com.publicsafety.echoapplication.databinding.ActivityMainBinding
import com.publicsafety.echoapplication.databinding.ActivityOutlookBinding
import com.publicsafety.echoapplication.databinding.ActivityResultBinding
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize the binding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.entry)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navigationHandler()
        //startProgress()
    }

   /* private  fun startProgress() {

        val animation = ObjectAnimator.ofInt(binding.progressBar, "progress", 0, 500) // animate towards max value
        animation.duration = 5000 // in milliseconds
        animation.interpolator = DecelerateInterpolator()
        animation.start()

    }*/


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
        val intent = Intent(applicationContext, HazardsActivity::class.java)
        //startActivity(intent)
    }


}