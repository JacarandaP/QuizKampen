package Serverside;

import java.util.ArrayList;
import java.util.Random;

public class QuestionDatabase {
    ArrayList<Question> gameQuestionList = new ArrayList<>();
    ArrayList<Question> sportQuestionList = new ArrayList<>();
    ArrayList<Question> musicQuestionList = new ArrayList<>();
    ArrayList<Question> cultQuestionList = new ArrayList<>();
    ArrayList<ArrayList> allQuestions = new ArrayList<>();

    // Gaming-related questions
    public static Question q1game = new Question(Category.GAMING,
            "I vilket spel finns karaktären Ash och hans kompanion Pikachu?",
            "Mulle Meck",
            "Digimon",
            "Naruto",
            "Pokémon");
    public static Question q2game = new Question(Category.GAMING,
            "Vart grundades det världskända företaget Nintendo?",
            "Taiwan",
            "Kina",
            "Indonesien",
            "Japan");
    public static Question q3game = new Question(Category.GAMING,
            "Vad heter prinsessan i Mario-spelet?",
            "Orange",
            "Mango",
            "Pear",
            "Peach");
    public static Question q4game = new Question(Category.GAMING,
            "Vad står datorspelsgenren FPS för?",
            "Frames Per Second",
            "Fictional Plot Story",
            "Flight Pilot Simulator",
            "First Person Shooter");
    public static Question q5game = new Question(Category.GAMING,
            "Vilket av följande företag har skapat spelet World of Warcraft?",
            "Riot Games",
            "Epic Games",
            "Dice",
            "Activision Blizzard");
    public static Question q6game = new Question(Category.GAMING,
            "Vilken figur passar inte in bland svaren?",
            "Gyarados",
            "Mew",
            "Machop",
            "Captain Falcon");
    public static Question q7game = new Question(Category.GAMING,
            "Vad heter landet i spelet The Legend of Zelda?",
            "Highcoast",
            "Pallet Town",
            "Mushroom Kingdom",
            "Hyrule");
    public static Question q8game = new Question(Category.GAMING,
            "Vilket spel hör inte till bland svaren?",
            "Dota 2",
            "League of Legends",
            "Heroes of Newerth",
            "Mario Kart");
    public static Question q9game = new Question(Category.GAMING,
            "Vad heter huvudkaraktären i spelserien Halo?",
            "Sergeant Crow",
            "Lieutenant Chief",
            "Major Blake",
            "Master Chief");
    public static Question q10game = new Question(Category.GAMING,
            "Vad heter dinosarien som finns i Mario-spelen",
            "Yasha",
            "Yisho",
            "Yushi",
            "Yoshi");
    //Sports-related questions
    public static Question q1sport = new Question(Category.SPORTS,
            "Vilken idrott i Sverige har nästflest utövare i Sverige efter fotboll?",
            "Ishockey",
            "Handboll",
            "Tennis",
            "Innebandy");
    public static Question q2sport = new Question(Category.SPORTS,
            "Vad är ett annat namn för pingis?",
            "Minitennis",
            "Stoltennis",
            "Ping Pong",
            "Bordtennis");
    public static Question q3sport = new Question(Category.SPORTS,
            "Hur många mål har man gjort om man gjort ett hat-trick?",
            "Två",
            "Fyra",
            "Sju",
            "Tre");
    public static Question q4sport = new Question(Category.SPORTS,
            "Vilket land vann Fotbolls-EM 2012",
            "Grekland",
            "Portugal",
            "Holland",
            "Spanien");
    public static Question q5sport = new Question(Category.SPORTS,
            "Vilken sport förknippas med Björn Borg?",
            "Basket",
            "Baseboll",
            "Bodybuilding",
            "Tennis");
    public static Question q6sport = new Question(Category.SPORTS,
            "Vad heter fotbollsspelaren som kallas för Zuper-Zvensken?",
            "Henrik Larsson",
            "Fredrik Ljungberg ",
            "Christian Wilhelmsson",
            "Zlatan Ibrahimovic");
    public static Question q7sport = new Question(Category.SPORTS,
            "Hur många poäng ger en dunk i basket?",
            "3 poäng",
            "4 poäng",
            "1 poäng",
            "2 poäng");
    public static Question q8sport = new Question(Category.SPORTS,
            "Vad är Kinas nationalsport?",
            "Tennis",
            "Schack",
            "Cricket",
            "Pingis");
    public static Question q9sport = new Question(Category.SPORTS,
            "Vilken sport spelar Henrik Lundqvist?",
            "Innebandy",
            "Volleyboll",
            "Simning",
            "Ishockey");
    public static Question q10sport = new Question(Category.SPORTS,
            "I vilken sport används termen En Garde?",
            "Snooker",
            "Golf",
            "Boule",
            "Fäktning");
    //Sports-related questions
    public static Question q1music = new Question(Category.MUSIC,
            "Vilket brittiskt band hade Dummy från 1994 som deras debutalbum?",
            "Radiohead",
            "Pulp",
            "Jonas Brothers",
            "Portishead");
    public static Question q2music = new Question(Category.MUSIC,
            "Vilket år släpptes Red Hot Chili Peppers album Californication?",
            "1995",
            "2000",
            "1994",
            "1999");
    public static Question q3music = new Question(Category.MUSIC,
            "Sias album This is Acting (2016) är hennes album nummer...?",
            "Fem",
            "Tre",
            "Fyra",
            "Sju");
    public static Question q4music = new Question(Category.MUSIC,
            "Vilket var Madonas debutalbum?",
            "Like a Prayer",
            "Like a Virgin",
            "True Blue",
            "Madonna");
    public static Question q5music = new Question(Category.MUSIC,
            "Vilket thrash metal-band tillhör gruppen \"The Big Four of Thrash\"?",
            "Exodus",
            "Testament",
            "Sodom",
            "Slayer");
    public static Question q6music = new Question(Category.MUSIC,
            "Vilken kompositör var en av de viktigaste tonsättarna i den wienklassiska stilen?",
            "Beethoven",
            "Liszt",
            "Stravinskijs",
            "Mozart");
    public static Question q7music = new Question(Category.MUSIC,
            "Vilken operasångare tillhör gruppen \"De tre tenorerna\"?",
            "Andrea Bocelli",
            "Josep Fadó",
            "Fiorenza Cossotto",
            "Jose Carreras");
    public static Question q8music = new Question(Category.MUSIC,
            "När bildades bandet Rage Against the Machine?",
            "2001",
            "1995",
            "1999",
            "1991");
    public static Question q9music = new Question(Category.MUSIC,
            "Vilket är det svernska bandet med mest sålda album i världen?",
            "Cardigans",
            "Ace of Base",
            "Roxette",
            "ABBA");
    public static Question q10music = new Question(Category.MUSIC,
            "Per Håkan Gessle bildade två band, Roxette och vilket annat?",
            "Ace of Base",
            "The Power Station",
            "The Ark",
            "Gyllene Tider");
    //Culture-related questions
    public static Question q1cult = new Question(Category.CULTURE,
            "Vem är den mest framgångsrika spanska filmskapare i sin generation?",
            "Guillermo del Toro",
            "Gonzáles Iñárritu",
            "Alfonso Cuaron",
            "Pedro Almodovar");
    public static Question q2cult = new Question(Category.CULTURE,
            "Vilken serie handlar om ett slott som ägs av familjen Crawley?",
            "The Crown",
            "The Haunting of Bly Manor",
            "Mad men",
            "Downtown Abbey");
    public static Question q3cult = new Question(Category.CULTURE,
            "Vilken film är baserad på Georg VI:s svårigheter med att hålla tal?",
            "The Tudors",
            "Reign",
            "The Crown",
            "The King's Speech");
    public static Question q4cult = new Question(Category.CULTURE,
            "I vilken stad ligger det världsberömda operahuset La Scaglia?",
            "Rom",
            "Neapel",
            "Nice",
            "Milano");
    public static Question q5cult = new Question(Category.CULTURE,
            "Vilken festival arrangeras sedan 1810 och anses vara världens största folkfest?",
            "Eurovision",
            "Tomorrowland",
            "Ferie Messium",
            "Oktoberfest");
    public static Question q6cult = new Question(Category.CULTURE,
            "Vilken är Storbritanniens nationalmuseem för modern konst i London?",
            "The Brittish Museum",
            "The National Gallery",
            "Royal Academy of Arts",
            "Tate Modern");
    public static Question q7cult = new Question(Category.CULTURE,
            "Vilken är fortfattern till romanen Dorian Greys porträtt?",
            "Emily Dickinson",
            "Jane Austen",
            "Charles Dickens",
            "Oscar Wilde");
    public static Question q8cult = new Question(Category.CULTURE,
            "Vilken konstnär skapade statyn David?",
            "Leonardo Da Vinci",
            "Rafael",
            "El greco",
            "Michelangelo");
    public static Question q9cult = new Question(Category.CULTURE,
            "Vilken konstnär tillhör inte konstinrikningen impressionism?",
            "Claude Monet",
            "Auguste Renoir",
            "Edgar Degas",
            "Pablo Picasso");
    public static Question q10cult = new Question(Category.CULTURE,
            "lken författare har INTE vunnit nobelpriset i litteratur?",
            "Bob Dylan",
            "Vargas Llosa",
            "Orhan Pamuk",
            "Haruki Murakami");

    public QuestionDatabase() {




        sportQuestionList.add((q1sport));
        sportQuestionList.add(q2sport);
        sportQuestionList.add((q3sport));
        sportQuestionList.add((q4sport));
        sportQuestionList.add(q5sport);
        sportQuestionList.add((q6sport));
        sportQuestionList.add((q7sport));
        sportQuestionList.add(q8sport);
        sportQuestionList.add((q9sport));
        sportQuestionList.add((q10sport));


        gameQuestionList.add((q1game));
        gameQuestionList.add(q2game);
        gameQuestionList.add((q3game));
        gameQuestionList.add((q4game));
        gameQuestionList.add(q5game);
        gameQuestionList.add((q6game));
        gameQuestionList.add((q7game));
        gameQuestionList.add(q8game);
        gameQuestionList.add((q9game));
        gameQuestionList.add((q10game));



        musicQuestionList.add((q1music));
        musicQuestionList.add(q2music);
        musicQuestionList.add((q3music));
        musicQuestionList.add((q4music));
        musicQuestionList.add(q5music);
        musicQuestionList.add((q6music));
        musicQuestionList.add((q7music));
        musicQuestionList.add(q8music);
        musicQuestionList.add((q9music));
        musicQuestionList.add((q10music));

        cultQuestionList.add((q1cult));
        cultQuestionList.add(q2cult);
        cultQuestionList.add((q3cult));
        cultQuestionList.add((q4cult));
        cultQuestionList.add(q5cult);
        cultQuestionList.add((q6cult));
        cultQuestionList.add((q7cult));
        cultQuestionList.add(q8cult);
        cultQuestionList.add((q9cult));
        cultQuestionList.add((q10cult));

        allQuestions.add(sportQuestionList);
        allQuestions.add(gameQuestionList);
        allQuestions.add(musicQuestionList);
        allQuestions.add(cultQuestionList);


    }



    public Question getRandomQuestion(int category) {
        Random rand = new Random();
        int x = rand.nextInt(allQuestions.get(category).size());
        return (Question) allQuestions.get(category).get(x);

    }


    public String getAnswerBasedOnText(String questionText, int category) {
        ArrayList<Question> questionList = allQuestions.get(category);
        for (Question q : questionList) {
            if (q.getQuestionText().equalsIgnoreCase(questionText)) {
                return q.getCorrectAnswer();
            }
        }

        return null;
    }




}


