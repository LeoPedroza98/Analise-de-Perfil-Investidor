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

class QuestionFiveFragment : Fragment() {

    var scoreQuestionFive : Int = 0

    lateinit var radioButton: RadioButton

    val questionFive = Question(
        5,
        "5. Caso as suas aplicações sofressem uma queda superior a 30%,\n" +
                "o que você faria?",
            //Questions
        "Resgataria toda a aplicação e aplicaria na poupança",
        "Manteria aplicação aguardando uma melhora do mercado",
        "Aumentaria a aplicação para aproveitar as oportunidades do mercado",
        "*********************",
        "**********************",
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
        return inflater.inflate(R.layout.fragment_questionfive, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionFive.question
        radioButtonOptionA.text = questionFive.optionOne
        radioButtonOptionB.text = questionFive.optionTwo
        radioButtonOptionC.text = questionFive.optionThree

        btnNext.setOnClickListener {

            var bundleNewScore5 = Bundle(onRadioButtonClicked())
            bundleNewScore5.putInt("score5", scoreQuestionFive)

            findNavController().navigate(R.id.action_question5Fragment_to_question6Fragment, bundleNewScore5)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionFour: Int = requireArguments().getInt("score4")

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionFive = QuestionFiveFragment().questionFive

        if (radioButtonOptionA.isChecked) {
            scoreQuestionFive = _questionFive.optionOneScore + scoreQuestionFour
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionFive = _questionFive.optionTwoScore + scoreQuestionFour
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionFive = _questionFive.optionThreeScore + scoreQuestionFour
        }
        return scoreQuestionFive
    }
}