package com.example.profileAnalyseTP3.model

data class Question (
        val index: Int,
        val question: String,
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String?,
        val optionFive: String?,
        val optionOneScore: Int,
        val optionTwoScore: Int,
        val optionThreeScore: Int,
        val optionFourScore: Int?,
        val optionFiveScore: Int?
)