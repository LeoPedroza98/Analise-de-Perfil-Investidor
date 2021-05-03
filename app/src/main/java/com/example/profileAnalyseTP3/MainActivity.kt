package com.example.profileAnalyseTP3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profileAnalyseTP3.activities.QuestionsActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnIniciarQuestionario: Button
    lateinit var editTextUsuarioNome: TextView
    lateinit var textViewCreditoCriadorPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciarQuestionario = findViewById(R.id.btnIniciarQuestionario)
        editTextUsuarioNome = findViewById(R.id.editTextUsuarioNome)

        btnIniciarQuestionario.setOnClickListener {

            var nameUser = editTextUsuarioNome.text.toString()

            if (nameUser.isEmpty()) {
                Toast.makeText(this, "Informe seu nome", Toast.LENGTH_LONG
                ).show()
            } else {
                val alterActivity = Intent(
                        this,
                        QuestionsActivity::class.java)
                alterActivity.putExtra("userName", nameUser)
                startActivity(alterActivity)
            }
        }
    }
}