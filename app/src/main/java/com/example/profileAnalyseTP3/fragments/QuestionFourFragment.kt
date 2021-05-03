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

class QuestionFourFragment : Fragment() {

    var scoreQuestionFour: Int = 0

    lateinit var radioButton: RadioButton

    val questionFour = Question(
        4,
        "4. Considerando seus rendimentos regulares, qual a porcentagem você " +
                "pretende reservar para aplicações Financeiras?",
            //Questions
        "No máximo 25%",
        "Entre 25,01 e 50%",
        "Acima de 50% ",
        "***************",
        "****************",
            //Score
        0,
        2,
        4,
        0,
        0
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questionfour, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionFour.question
        radioButtonOptionA.text = questionFour.optionOne
        radioButtonOptionB.text = questionFour.optionTwo
        radioButtonOptionC.text = questionFour.optionThree

        btnNext.setOnClickListener {

            var bundleNewScore4 = Bundle(onRadioButtonClicked())
            bundleNewScore4.putInt("score4", scoreQuestionFour)

            findNavController().navigate(R.id.action_question4Fragment_to_question5Fragment, bundleNewScore4)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionThree: Int = arguments?.getInt("score3") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionFour = QuestionFourFragment().questionFour

        if (radioButtonOptionA.isChecked) {
            scoreQuestionFour = _questionFour.optionOneScore + scoreQuestionThree
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionFour = _questionFour.optionTwoScore + scoreQuestionThree
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionFour = _questionFour.optionThreeScore + scoreQuestionThree
        }
        return scoreQuestionFour
    }
}
