package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityHomePageBinding

class Home_Page : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val data_login = intent.extras

1
        with(binding){
            name.text = data_login?.getString("NAME")
            number.text = data_login?.getString("NUMBER")
            email.text = data_login?.getString("EMAIL")

            goBack.setOnClickListener(){
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}