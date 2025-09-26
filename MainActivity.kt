package com.example.project4_4

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var switchStart: Switch
    private lateinit var textView2: TextView
    private lateinit var rGroup1: RadioGroup
    private lateinit var imgAndroid: ImageView
    private lateinit var btnEnd: Button
    private lateinit var btnInit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        switchStart = findViewById(R.id.switchStart)
        textView2 = findViewById(R.id.textView2)
        rGroup1 = findViewById(R.id.rGroup1)
        imgAndroid = findViewById(R.id.imgAndroid)
        btnEnd = findViewById(R.id.btnEnd)
        btnInit = findViewById(R.id.btnInit)

        textView2.visibility = View.INVISIBLE
        rGroup1.visibility = View.INVISIBLE
        imgAndroid.visibility = View.INVISIBLE

        switchStart.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                imgAndroid.visibility = View.VISIBLE
            } else {
                textView2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                imgAndroid.visibility = View.INVISIBLE
                rGroup1.clearCheck()
            }
        }

        rGroup1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdoOreo -> imgAndroid.setImageResource(R.drawable.oreo)
                R.id.rdoPie -> imgAndroid.setImageResource(R.drawable.pie)
                R.id.rdoQ -> imgAndroid.setImageResource(R.drawable.q10)
            }
            imgAndroid.visibility = View.VISIBLE
        }

        btnEnd.setOnClickListener {
            finish()
        }

        btnInit.setOnClickListener {
            switchStart.isChecked = false
            textView2.visibility = View.INVISIBLE
            rGroup1.visibility = View.INVISIBLE
            imgAndroid.visibility = View.INVISIBLE
            rGroup1.clearCheck()
        }
    }
}
