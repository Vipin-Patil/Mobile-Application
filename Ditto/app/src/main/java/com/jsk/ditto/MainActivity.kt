package com.jsk.ditto

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val delay = 1500;
        val actionButton = findViewById<Button>(R.id.actionButton)

        // Optional: animate the button when clicked
        val scaleUp = ScaleAnimation(
            0.95f, 1f,
            0.95f, 1f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f
        )
        scaleUp.duration = delay.toLong();
        scaleUp.fillAfter = true

        actionButton.setOnClickListener { view ->
            view.startAnimation(scaleUp)

            // 👇 Action here: showing a toast
            Toast.makeText(this, "Ditto says Hiii 👋", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, Startup::class.java)
            startActivity(intent)


        }
    }
}