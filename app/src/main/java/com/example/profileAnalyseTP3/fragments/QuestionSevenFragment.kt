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

class QuestionSevenFragment : Fragment() {

    var scoreQuestionSeven : Int = 0


    lateinit var radioButton: RadioButton

    val questionSeven = Question(
        7,
        "7.Em relação as aplicações e rendimentos, em qual dessas situações você\n" +
                "se enquadra?",
            //Questions
        "Conto com o rendimento dessas aplicações para complementar minha\n" +
                "renda mensal",
        "Eventualmente posso resgatar parte das aplicações para fazer frente aos\n" +
                "meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e\n" +
                "pretendo fazer aplicações regulares",
        "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar\n" +
                "novas aplicações",
        "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer\n" +
                "aplicações regulares",
        "********************************",
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
        return inflater.inflate(R.layout.fragment_questionseven, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionSeven.question
        radioButtonOptionA.text = questionSeven.optionOne
        radioButtonOptionB.text = questionSeven.optionTwo
        radioButtonOptionC.text = questionSeven.optionThree
        radioButtonOptionD.text = questionSeven.optionFour

        btnNext.setOnClickListener {

            var bundleNewScore7 = Bundle(onRadioButtonClicked())
            bundleNewScore7.putInt("score7", scoreQuestionSeven)

            findNavController().navigate(R.id.action_question7Fragment_to_question8Fragment, bundleNewScore7)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionSix: Int = arguments?.get("score6") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionSeven = QuestionSevenFragment().questionSeven

        if (radioButtonOptionA.isChecked) {
            scoreQuestionSeven = _questionSeven.optionOneScore + scoreQuestionSix
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionSeven = _questionSeven.optionTwoScore + scoreQuestionSix
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionSeven = _questionSeven.optionThreeScore + scoreQuestionSix
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionSeven = _questionSeven.optionFourScore!! + scoreQuestionSix
        }
        return scoreQuestionSeven
    }
}