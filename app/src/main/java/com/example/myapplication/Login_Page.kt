package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityLoginBinding

class Login_Page : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    companion object{
        const val LOGIN = "login_page"
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if (result.resultCode == Activity.RESULT_OK){
                binding.passwordEditTxt.text.clear()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
//            Mengambil data login


            toSecondPage.setOnClickListener{
                val name = nameEditTxt.text.toString()
                val number = numberEditTxt.text.toString()
                val email = emailEditTxt.text.toString()
                val password = passwordEditTxt.text.toString()

                if (name.isEmpty() || number.isEmpty() || email.isEmpty() || password.isEmpty() || !ToC.isChecked){
                    Toast.makeText(this@Login_Page, "login failed, please fill in the form and agree to our ToC", Toast.LENGTH_SHORT).show()
                }
                else{
                    val data_login = Bundle()
                    data_login.putString("NAME", name)
                    data_login.putString("NUMBER", number)
                    data_login.putString("EMAIL", email)
                    data_login.putString("PASSWORD", password)

                    val intentToSecondActivity = Intent(this@Login_Page, Home_Page::class.java).apply { putExtras(data_login
                    ) }
                    launcher.launch(intentToSecondActivity)
                }

            }

            terms.setOnClickListener{
                Toast.makeText(this@Login_Page, "Coming soon", Toast.LENGTH_SHORT).show()
            }
            conditions.setOnClickListener{
                Toast.makeText(this@Login_Page, "Coming soon", Toast.LENGTH_SHORT).show()
            }
            logIn.setOnClickListener{
                Toast.makeText(this@Login_Page, "Coming soon", Toast.LENGTH_SHORT).show()
            }
        }
    }
}