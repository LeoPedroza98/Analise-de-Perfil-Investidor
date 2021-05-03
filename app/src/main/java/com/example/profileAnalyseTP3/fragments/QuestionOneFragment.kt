package com.example.profileAnalyseTP3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.example.profileAnalyseTP3.model.Question
import com.example.profileAnalyseTP3.R
import kotlinx.android.synthetic.main.fragment_questionone.*

class QuestionOneFragment : Fragment() {

    var scoreQuestionOne = 0

    lateinit var radioButton: RadioButton

    val questionOne = Question(
            1,
            "1. Por quanto tempo você pretende deixar seu dinheiro investido?",
            //Questions
            "Menos de 6 meses",
            "Entre 6 meses e 1 ano",
            "Entre 1 ano e 3 anos",
            "Acima de 3 anos",
            "*********************",
            //Score
            0,
            2,
            3,
            4,
            0
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questionone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionOne.question
        radioButtonOptionA.text = questionOne.optionOne
        radioButtonOptionB.text = questionOne.optionTwo
        radioButtonOptionC.text = questionOne.optionThree
        radioButtonOptionD.text = questionOne.optionFour

        btnNext.setOnClickListener {

            var bundleScore = Bundle(onRadioButtonClicked())
            bundleScore.putInt("score1", scoreQuestionOne)


            findNavController().navigate(R.id.action_question1Fragment_to_question2Fragment2, bundleScore)
        }
    }

    private fun onRadioButtonClicked(): Int {

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionOne = QuestionOneFragment().questionOne

        if (radioButtonOptionA.isChecked) {
            scoreQuestionOne = _questionOne.optionOneScore
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionOne = _questionOne.optionTwoScore
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionOne = _questionOne.optionThreeScore
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionOne = _questionOne.optionFourScore!!
        }
        return scoreQuestionOne
    }
}