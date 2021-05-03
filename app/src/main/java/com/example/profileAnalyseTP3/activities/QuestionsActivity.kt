package com.example.profileAnalyseTP3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profileAnalyseTP3.R

class QuestionsActivity : AppCompatActivity() {

    var nameUser : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        nameUser = intent.getStringExtra("userName").toString()
    }
}