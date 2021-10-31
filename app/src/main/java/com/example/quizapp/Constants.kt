package com.example.quizapp

object Constants{
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(1, "What color is this?",
        R.drawable.chocolate,
        "Chocolate",
        "Peru",
        "Sienna",
        "Brown",
        1)

        questionsList.add(que1)

        val que2 = Question(2, "What color is this?",
            R.drawable.sky_blue,
            "DeepSkyBlue",
            "LightBlue",
            "SkyBlue",
            "DodgeBlue",
            3)

        questionsList.add(que2)

        val que3 = Question(3, "What color is this?",
            R.drawable.crimson,
            "DarkSalmon",
            "lightSalon",
            "Crimson",
            "Red",
            3)

        questionsList.add(que3)

        val que4 = Question(4, "What color is this?",
            R.drawable.hot_pink,
            "LightPink",
            "DeepPink",
            "HotPink",
            "MediumVioletRed",
            3)

        questionsList.add(que4)

        val que5 = Question(5, "What color is this?",
            R.drawable.orange_red,
            "Tomato",
            "Coral",
            "DarkOrange",
            "OrangeRed",
            4)

        questionsList.add(que5)

        val que6 = Question(6, "What color is this?",
            R.drawable.indigo,
            "Purple",
            "Indigo",
            "SlateBlue",
            "DarkMagenta",
            2)

        questionsList.add(que6)

        val que7 = Question(7, "What color is this?",
            R.drawable.lime,
            "Chartreuse",
            "GreenYellow",
            "Lime",
            "LawnGreen",
            3)

        questionsList.add(que7)

        val que8 = Question(8, "What color is this?",
            R.drawable.teal,
            "Teal",
            "DarkCyan",
            "Olive",
            "LightSeaGreen",
            1)

        questionsList.add(que8)

        val que9 = Question(9, "What color is this?",
            R.drawable.tan,
            "BurlyWood",
            "Tan",
            "RoseBrown",
            "Wheat",
            2)

        questionsList.add(que9)

        val que10 = Question(10, "What color is this?",
            R.drawable.turquoise,
            "Aqua",
            "Cyan",
            "Aquamarine",
            "Turquoise",
            4)

        questionsList.add(que10)
        return questionsList
    }
}