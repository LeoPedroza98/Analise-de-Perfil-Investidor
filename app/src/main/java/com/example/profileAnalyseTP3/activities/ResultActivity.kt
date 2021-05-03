package com.example.profileAnalyseTP3.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profileAnalyseTP3.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var usualName: String? = intent!!.getStringExtra("userName").toString()
        textViewNomeUsuario.text = "Usuário: $usualName"


        var finalScore: Int = intent!!.getIntExtra("score9", 0)

        typeIvestor(finalScore)
    }

    private fun typeIvestor(finalScore: Int) {
        textViewInvestidorPerfil.text =  if (finalScore <= 12) {
            "Investidor: Conservador"
        } else if (finalScore <= 29) {
             "Investidor: Moderado"
        } else {
            "Investidor: Arrojado"
        }
    }
}