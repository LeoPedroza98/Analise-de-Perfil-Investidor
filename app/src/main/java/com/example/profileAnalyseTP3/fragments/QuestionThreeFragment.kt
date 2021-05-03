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

class QuestionThreeFragment : Fragment() {

    var scoreQuestionThree : Int = 0

    lateinit var radioButton: RadioButton

    val questionThree = Question(
        3,
        "3. Qual das alternativas melhor classifica sua formação e experiência " +
                "com o mercado Financeiro?",
            //Questions
        "Não possuo formação acadêmica ou conhecimento do mercado Financeiro ",
        "Possuo formação acadêmica na área financeira, mas não tenho experiência\n" +
                "com o mercado financeiro",
        "Possuo formação acadêmica em outra área, mas possuo conhecimento do\n" +
                "mercado financeiro ",
        "Possuo formação acadêmica na área financeira ou pleno conhecimento do\n" +
                "mercado financeiro",
        "*********************",
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
        return inflater.inflate(R.layout.fragment_questionthree, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionThree.question
        radioButtonOptionA.text = questionThree.optionOne
        radioButtonOptionB.text = questionThree.optionTwo
        radioButtonOptionC.text = questionThree.optionThree
        radioButtonOptionD.text = questionThree.optionFour

        btnNext.setOnClickListener {

            var bundleNewScore3 = Bundle(onRadioButtonClicked())
            bundleNewScore3.putInt("score3", scoreQuestionThree)

            findNavController().navigate(R.id.action_question3Fragment_to_question4Fragment, bundleNewScore3)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionTwo = arguments?.getInt("score2") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionThree = QuestionThreeFragment().questionThree

        if (radioButtonOptionA.isChecked) {
            scoreQuestionThree = _questionThree.optionOneScore + scoreQuestionTwo
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionThree = _questionThree.optionTwoScore + scoreQuestionTwo
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionThree = _questionThree.optionThreeScore + scoreQuestionTwo
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionThree = _questionThree.optionFourScore!! + scoreQuestionTwo
        }
        return scoreQuestionThree
    }
}