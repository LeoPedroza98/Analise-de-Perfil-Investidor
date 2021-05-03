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

class QuestionSixFragment : Fragment() {

    var scoreQuestionSix :Int = 0


    lateinit var radioButton: RadioButton

    val questionSix = Question(
        6,
        "6. Como está distribuído o seu patrimônio?",
            //Questions
        "Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou\n" +
                "imóveis",
        "Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis",
        "Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa\n" +
                "e/ou imóveis",
        "Acima de 50% em renda variável",
        "*******************************",
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
        return inflater.inflate(R.layout.fragment_questionsix, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionSix.question
        radioButtonOptionA.text = questionSix.optionOne
        radioButtonOptionB.text = questionSix.optionTwo
        radioButtonOptionC.text = questionSix.optionThree
        radioButtonOptionD.text = questionSix.optionFour

        btnNext.setOnClickListener {

            var bundleNewScore6 = Bundle(onRadioButtonClicked())
            bundleNewScore6.putInt("score6", scoreQuestionSix)

            findNavController().navigate(R.id.action_question6Fragment_to_question7Fragment, bundleNewScore6)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionFive : Int = arguments?.get("score5") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionSix = QuestionSixFragment().questionSix

        if (radioButtonOptionA.isChecked) {
            scoreQuestionSix = _questionSix.optionOneScore + scoreQuestionFive
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionSix = _questionSix.optionTwoScore + scoreQuestionFive
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionSix = _questionSix.optionThreeScore + scoreQuestionFive
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionSix = _questionSix.optionFourScore!! + scoreQuestionFive
        }
        return scoreQuestionSix
    }
}