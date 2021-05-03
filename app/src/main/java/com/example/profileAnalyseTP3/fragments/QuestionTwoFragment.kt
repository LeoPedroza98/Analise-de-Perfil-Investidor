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

class QuestionTwoFragment : Fragment() {

    var scoreQuestionTwo: Int = 0

    lateinit var radioButton: RadioButton

    val questionTwo = Question(
            2,
            "2. Qual o objetivo desse investimento?",
            //Questions
            "Preservação do capital para não perder valor ao longo do tempo,\n" +
                    "assumindo baixos riscos de perdas",

            "Aumento gradual do capital ao longo do tempo, assumindo riscos\n" +
                    "moderados",

            "Aumento do capital acima da taxa de retorno média do mercado, mesmo\n" +
                    "que isso implique assumir riscos de perdas elevadas",

            "Obter no curto prazo retornos elevados e significativamente acima da taxa\n" +
                    "de retorno média do mercado, assumindo riscos elevados",
            "*************************",
            //Score
            0,
            2,
            4,
            5,
            0
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questiontwo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionTwo.question
        radioButtonOptionA.text = questionTwo.optionOne
        radioButtonOptionB.text = questionTwo.optionTwo
        radioButtonOptionC.text = questionTwo.optionThree
        radioButtonOptionD.text = questionTwo.optionFour

        btnNext.setOnClickListener {

            var bundleNewScore2 = Bundle(onRadioButtonClicked())
            bundleNewScore2.putInt("score2", scoreQuestionTwo)

            findNavController().navigate(R.id.action_question2Fragment2_to_question3Fragment, bundleNewScore2)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionOne: Int = arguments?.get("score1") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionTwo = QuestionTwoFragment().questionTwo

        if (radioButtonOptionA.isChecked) {
            scoreQuestionTwo = _questionTwo.optionOneScore + scoreQuestionOne
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionTwo = _questionTwo.optionTwoScore + scoreQuestionOne
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionTwo = _questionTwo.optionThreeScore + scoreQuestionOne
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionTwo = _questionTwo.optionFourScore!! + scoreQuestionOne
        }
        return scoreQuestionTwo
    }
}