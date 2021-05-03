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
import kotlinx.android.synthetic.main.fragment_questiontwo.*

class QuestionEightFragment : Fragment() {

    var scoreQuestionEight : Int = 0

    lateinit var radioButton: RadioButton

    val questionEight = Question(
        8,
        "8. Qual sua faixa de renda mensal média?",
            //Questions
        "Até R$ 1.000",
        "De R$ 1.001 até R$ 5.000",
        "De R$ 5.001 até R$ 10.000",
        "Acima de R$ 10.000",
        "**************************",
            //Score
        0,
        1,
        2,
        4,
        0
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questioneight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionEight.question
        radioButtonOptionA.text = questionEight.optionOne
        radioButtonOptionB.text = questionEight.optionTwo
        radioButtonOptionC.text = questionEight.optionThree
        radioButtonOptionD.text = questionEight.optionFour

        btnNext.setOnClickListener {

            var bundleNewScore8 = Bundle(onRadioButtonClicked())
            bundleNewScore8.putInt("score8", scoreQuestionEight)

            findNavController().navigate(R.id.action_question8Fragment_to_question9Fragment, bundleNewScore8)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionSeven : Int = arguments?.get("score7") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionEight = QuestionEightFragment().questionEight

        if (radioButtonOptionA.isChecked) {
            scoreQuestionEight = _questionEight.optionOneScore + scoreQuestionSeven
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionEight = _questionEight.optionTwoScore + scoreQuestionSeven
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionEight = _questionEight.optionThreeScore + scoreQuestionSeven
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionEight = _questionEight.optionFourScore!! + scoreQuestionSeven
        }
        return scoreQuestionEight
    }
}