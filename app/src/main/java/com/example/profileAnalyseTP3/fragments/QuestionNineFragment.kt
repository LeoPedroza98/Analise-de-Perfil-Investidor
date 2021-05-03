package com.example.profileAnalyseTP3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.example.profileAnalyseTP3.model.Question
import com.example.profileAnalyseTP3.activities.QuestionsActivity
import com.example.profileAnalyseTP3.R
import kotlinx.android.synthetic.main.fragment_questiontwo.btnNext
import kotlinx.android.synthetic.main.fragment_questiontwo.radioButtonOptionA
import kotlinx.android.synthetic.main.fragment_questiontwo.radioButtonOptionB
import kotlinx.android.synthetic.main.fragment_questiontwo.radioButtonOptionC
import kotlinx.android.synthetic.main.fragment_questiontwo.radioButtonOptionD
import kotlinx.android.synthetic.main.fragment_questiontwo.radioGroupOptions
import kotlinx.android.synthetic.main.fragment_questiontwo.textViewQuestion
import kotlinx.android.synthetic.main.fragment_questionnine.*

class QuestionNineFragment : Fragment() {

    var scoreQuestionNine: Int = 0

    lateinit var radioButton: RadioButton

    val questionNine = Question(
            9,
            "9. Qual o valor aproximado do seu patrimônio?",
            //Questions
            "Até R$ 10.000",
            "De R$ 10.001 até R$ 100.00",
            "De R$ 100.001 até R$ 500.000",
            "De R$ 500.001 até R$ 1.000.000",
            "Acima de R$ 1.000.001",
            //Score
            0,
            1,
            2,
            4,
            5
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_questionnine, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = questionNine.question
        radioButtonOptionA.text = questionNine.optionOne
        radioButtonOptionB.text = questionNine.optionTwo
        radioButtonOptionC.text = questionNine.optionThree
        radioButtonOptionD.text = questionNine.optionFour
        radioButtonOptionE.text = questionNine.optionFive

        btnNext.setOnClickListener {

            val usuarioNome = (requireActivity() as QuestionsActivity).nameUser
            Log.i("UsuarioNome", "Question9Fragment onViewCreated $usuarioNome")

            var bundleNewScore9 = Bundle(onRadioButtonClicked())
            bundleNewScore9.putInt("score9", scoreQuestionNine)
            bundleNewScore9.putString("userName", usuarioNome)

            findNavController().navigate(R.id.action_question9Fragment_to_resultActivity, bundleNewScore9)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestionEight: Int = arguments?.getInt("score8") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _questionNine = QuestionNineFragment().questionNine

        if (radioButtonOptionA.isChecked) {
            scoreQuestionNine = _questionNine.optionOneScore + scoreQuestionEight
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestionNine = _questionNine.optionTwoScore + scoreQuestionEight
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestionNine = _questionNine.optionThreeScore + scoreQuestionEight
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestionNine = _questionNine.optionFourScore!! + scoreQuestionEight
        } else if (radioButtonOptionE.isChecked) {
            scoreQuestionNine = _questionNine.optionFiveScore!! + scoreQuestionEight
        }

        return scoreQuestionNine
    }
}
