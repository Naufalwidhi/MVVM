package com.naufal.mvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.mvvm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}