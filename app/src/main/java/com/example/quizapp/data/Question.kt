package com.example.quizapp.data

data class Question (
    val id: Int,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: String
)

fun getQuestions(): ArrayList<Question>
{
    val questions = ArrayList<Question>()

    questions.add(Question(0,
        "What is Cristiano Ronaldo National Team?",
        "Portugal",
        "Spain",
        "Brazil",
        "Italy",
        "Portugal"
    )
    )

    questions.add(Question(1,
        "Where would you be if you were standing on the Spanish Steps?",
        "Madrid",
        "Rome",
        "Paris",
        "Valencia",
        "Rome"
    )
    )

    questions.add(Question(2,
        "Which language has the more native speakers?",
        "Portuguese",
        "Dutch",
        "Spanish",
        "English",
        "Spanish"
    )
    )

    questions.add(Question(3,
        "Who was the Ancient Greek God of the Sun?",
        "Apollo",
        "Zeus",
        "Hera",
        "Ares",
        "Apollo"
    )
    )

    questions.add(Question(4,
        "What character have both Robert Downey Jr. and Benedict Cumberbatch played?",
        "Doctor Strange",
        "Sherlock Holmes",
        "Iron Man",
        "Jack",
        "Sherlock Holmes"
    )
    )

    questions.add(Question(5,
        "What is the 4th letter of the Greek alphabet? ",
        "Diablo",
        "Dante",
        "Draki",
        "Delta",
        "Delta"
    )
    )

    questions.add(Question(6,
        "What city is known as \"The Eternal City\"?",
        "Paris",
        "New York",
        "Rome",
        "Los Angeles",
        "Rome"
    )
    )

    questions.add(Question(7,
        "Which planet has the most moons?",
        "Earth",
        "Jupiter",
        "Saturn",
        "Venus",
        "Saturn"
    )
    )

    questions.add(Question(8,
        "What Netflix show had the most streaming views in 2021?",
        "Stranger Things",
        "Squid Game",
        "The Witcher",
        "Dark",
        "Squid Game"
    )
    )

    questions.add(Question(9,
        "How many bones do we have in an ear?",
        "3",
        "5",
        "2",
        "4",
        "3"
    )
    )

    questions.add(Question(10,
        "In what country is the Chernobyl nuclear plant located?",
        "Ukraine",
        "Russia",
        "Kazakhstan",
        "Georgia",
        "Ukraine"
    )
    )

    questions.add(Question(11,
        "What country has won the most World Cups?",
        "Argentina",
        "France",
        "Spain",
        "Brazil",
        "Brazil"
    )
    )

    questions.add(Question(12,
        "What is the highest-rated film on IMDB?",
        "Godfather",
        "Pulp Fiction",
        "The Shawshank Redemption",
        "Dune",
        "The Shawshank Redemption"
    )
    )

    questions.add(Question(13,
        "How many minutes are in a full week? ",
        "11,560",
        "9,600",
        "10,080",
        "14,800",
        "10,080"
    )
    )

    questions.add(Question(14,
        "What year was the United Nations established?",
        "1945",
        "1948",
        "1950",
        "1942",
        "1945"
    )
    )

    questions.add(Question(15,
        "What is the only continent with land in all four hemispheres?",
        "Asia",
        "Europe",
        "South America",
        "Africa",
        "Africa"
    )
    )

    return questions
}