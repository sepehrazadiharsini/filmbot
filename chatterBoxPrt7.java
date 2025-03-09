//Sepehr Azadi-Harsini
// 240540030
// 05/12/24
// version 1
// Mini projcet 8: a chatbot procedural programme that can have realistic conversations with people about a specific topic related to films.


import java.util.Scanner;
import java.util.Random;
import java.io.*;



//Start class Movies
class Movies {
    public String movieName;
    public int movieYear;
    public String movieDirector;
    public String movieGenre;
}// End class BondQuestions



//Start Class chatterBoxPrt7

//Start main
public class chatterBoxPrt7 {
    public static void main(String[] args) throws IOException{
        
        filmBot1();  
    } // end main


    //#region Introductions

    // Start botIntro
    public static void botIntro() {
        
        System.out.println("Hi there! My name is Chatterbox, the ultimate cinema geek.");

    } // End botIntro



    

    // Start getName
    // This method asks for the user's name and returns it as a String
    public static String getName() {
        
        final String name = inputString("What's your name?");  
        return name;  
    } // End getName





    // Start howIsUser
    // this method greest the user using their name

    public static void howIsUser(String name) {
        
        System.out.println("It's nice to meet you, " + name + ". I hope you're doing well today!");
    } // End howIsUser


    //Start greetExistingUser
    // This method greets an existing user by name
    public static void greetExistingUser(String name)
    {
        System.out.println("Welcome back " + name + "!");
    }//End greetExistingUser


    //#endregion Introductions


    //#region IO


    //Start doesFileExist
    // This method checks if a file exists in the current directory
    public static boolean doesFileExist(String fileName) throws IOException 
    {
        File input_file = new File(fileName);
        return input_file.exists();

    } // end doesFileExist



    //start loadUserData
    // This method loads user data from a file
    public static void loadUserData(String name) throws IOException 
    {
        
    String filename = name + ".txt";
    File file = new File(filename);

    if (file.exists()) {
        BufferedReader userFile = new BufferedReader(new FileReader(filename));
        String movieName = userFile.readLine();
        
        if (movieName != null) {
            greetExistingUser(name); 

            Movies loadedMovie = new Movies();
            
            String movieDirector = userFile.readLine();
            String movieYear = userFile.readLine();
            String movieGenre = userFile.readLine();
            
            setMovieName(loadedMovie, movieName);
            setMovieDirector(loadedMovie, movieDirector);
            setMovieYear(loadedMovie, movieYear);
            setMovieGenre(loadedMovie, movieGenre);

            System.out.println("I remember what movie we discussed last time.");
            System.out.println(convertCreatedMovieToString(loadedMovie));
        } else {
            System.out.println("No prior data found. Let's start fresh!");
        }
        userFile.close();
        } else {
        System.out.println("File not found. Starting fresh...");
    }

    }// End loadUserData



    //Start saveUserData
    // This method saves user data to a file
    public static void saveUserData(Movies movie, String name) throws IOException
    {
        final int MOVIE_DETAILS_NUMBER = 4;
        String filename = name + ".txt";

        PrintWriter user_file = new PrintWriter(new FileWriter(filename));

        String[] movieDetails = new String[MOVIE_DETAILS_NUMBER];
        
        movieDetails[0] = getMovieName(movie);
        movieDetails[1] = getMovieDirector(movie);
        movieDetails[2] = getMovieYear(movie) + ""; // Converts int to String
        movieDetails[3] = getMovieGenre(movie);
        
        for(int i = 0; i < MOVIE_DETAILS_NUMBER; i++) {
            user_file.println(movieDetails[i]);
        }
        

        user_file.close();

        return;

    }// End saveUserData


    //#endregion




    //#region Film Series Questions

    // Start favFilmSeries
    // this method asks the user for their favourite film series and returns it as a String
    public static String favFilmSeries(String name) {
       
        System.out.println("Horror films are my favourite. I adore the Evil Dead series.");
        
        String favFilms = inputString("Tell me, " + name + ", what's your favourite film series?");
        return favFilms;  
    } // End favFilmSeries




    // Start mentionFavFilm
    public static void mentionFavFilm(String favFilms) {

        System.out.println("So you like " + favFilms + "! Interesting choice. Let's talk about it more.");

    } // End mentionFavFilm
    

    //#region createMovie get and set methods

    // Start creatMovie
    // This method asks the user for the title of a movie they would like to create
    public static Movies createMovie(String favFilms){
        Movies movie = new Movies();
        movie.movieName = favFilms;
        movie.movieDirector = inputString("Who is the director of " + favFilms + "?");
        movie.movieYear = inputInt("What year was " + favFilms + " released?");
        movie.movieGenre = inputString("What genre is " + favFilms + "?");
        
        return movie;
    } // End creatMovie



    // Start getMovieName
    //This method retruns the movie name
    public static String getMovieName(Movies movie)
    {
        return movie.movieName;
    }// End getMovieName


    //Start getMovieDirector
    //This method returns the movie director
    public static String getMovieDirector(Movies movie)
    {
        return movie.movieDirector;
    }// End getMovieDirector


    //Start getMovieYear
    //This method returns the movie year
    public static int getMovieYear(Movies movie)
    {
        return movie.movieYear;
    }// End getMovieYear


    //start getMovieGenre
    // This method returns the movie genre
    public static String getMovieGenre(Movies movie)
    {
        return movie.movieGenre;
    }// End getMovieGenre


    //Start setMovieName
    // This method sets the movie name
    public static Movies setMovieName(Movies movie, String n)
    {
        movie.movieName = n;
        return movie;
    }// End setMovieName


    //Start setMovieDirector
    //This method sets the movie director
    public static Movies setMovieDirector(Movies movie, String d)
    {
        movie.movieDirector = d;
        return movie;
    }// End setMovieDirector

    
    //Start setMovieYear
    // This method sets the movie year
    public static Movies setMovieYear (Movies movie, String y)
    {
        movie.movieYear = Integer.parseInt(y);
        return movie;
    }// End setMovieYear


    //Start setMovieGenre
    // This method sets the movie genre
    public static Movies setMovieGenre (Movies movie, String g)
    {
        movie.movieGenre = g;
        return movie;
    }// end setMovieGenre



    //Start convertCreatedMovieToString
    // This method converts the movie record to a string
    public static String convertCreatedMovieToString(Movies movie)
    {
        String movie_to_string = getMovieName(movie) + " is a " + getMovieGenre(movie) + " movie directed by " + getMovieDirector(movie) + " released in " + getMovieYear(movie) + ".";
        
        return movie_to_string;
    }// End convertCreatedMovieToString


    //#endregion createMovie get and set methods

    

    //Start favFilmSeriesResponse
    // This method replies to the user's input based on what they've  said about their favourite film series

    public static void favFilmSeriesResponse(String favFilms, String name, String[] bondQuestions, String[] jamesBondActors, String[] jamesBondGirls, String[] jamesBondFilms, String[] jamesBondVillains) throws IOException
    {
        favFilms = favFilms.toLowerCase();
        Movies movie = null;

        if(favFilms.equals("spiderman") || favFilms.equals("spider-man")){
            String  favBond = inputString("Who is your favourite Spiderman?").toLowerCase();

            if(favBond.equals("tobey maguire")) {
                System.out.println("I agree! Tobey is the best Spiderman.");
            }
            else if(favBond.equals("andrew garfield")) {
                System.out.println("Andrew is a great Spiderman, but I think Tobey is the best.");
            }
            else  {
                System.out.println("I'm not familiar with that Spiderman.");
            }
        }

        else if(favFilms.equals("james bond")){
            randomBondQuestion(bondQuestions);
            randomBondQuestionAnswer(bondQuestions ,jamesBondActors, jamesBondGirls, jamesBondFilms, jamesBondVillains);
        }

        else if(favFilms.equals("evil dead")) {
            System.out.println("I'm not even gonna ask you which Evil Dead is your favourite.\nThe only correct answer is Evil Dead 2.");
        }

        else {
            System.out.println("I'm not familiar with that film series. \nCan you tell me more about it so I can add it to my database?");
            movie = createMovie(favFilms);
            
            
        }

        
        
        if (movie != null) {
            saveUserData(movie, name);
        }

        return;

    } // End favFilmSeriesResponse





    //Start askFavFilmAgain
    // This method  asks the user if they want to talk about their favourite film again

    public static String  askFavFilmAgain()
    {
        String answer = inputString("Do you have another favourite film series? If yes, then type in the name of the movie. If not just type no: ").toLowerCase();

        return answer;

    } // End askFavFilmAgain






    //Start loopAskFavFilmSeries
    // This method  will keep asking the user for their favourite film series until they type 'no'
    public static void loopAskFavFilmSeries(String name, String[] bondQuestions, String[] jamesBondActors, String[] jamesBondGirls, String[] jamesBondFilms, String[] jamesBondVillains) throws IOException
    {
        final String EXIT = "no";
        String answer = askFavFilmAgain();

        while (!answer.equals(EXIT)) { 
            while(!answer.equals("YES"))
            {
                if(!answer.equals("no"))
                {
                    favFilmSeriesResponse(answer, name, bondQuestions, jamesBondActors, jamesBondGirls, jamesBondFilms, jamesBondVillains);
                    answer = askFavFilmAgain(); 
                }
                
            }

        }

        System.out.println("Really??? Nothing else?");

    } // End loopAskFavFilmSeries


    //#endregion film series questions

    

    //start isValidAnswerForArray
    //method to check if the user's answer is in the array of possible answers
    public static boolean isValidAnswerForArray(String answer, String[] validArray)
    {
        for (int i = 0; i < validArray.length; i++){
            if(answer.equalsIgnoreCase(validArray[i])) {
                return true;
            }
        }
        return false;
    } // End isValidAnswerForArray



    //#region James Bond related methods

    //Start bondActors
    //This method creates a String array of actors who have played James Bond
    public static String [] bondActors()
    {
        String [] jamesBondActors = {"Sean Connery", "George Lazenby", "Roger Moore", "Timothy Dalton", "Pierce Brosnan", "Daniel Craig"};
        return jamesBondActors;
    }// End bondActors



    //Start bondFilms
    //This method creates a String array of James Bond films
    public static String [] bondFilms()
    {
        String [] jamesBondFilms = {
            "Dr. No",
            "From Russia with Love",
            "Goldfinger",
            "Thunderball",
            "You Only Live Twice",
            "On Her Majesty's Secret Service",
            "Diamonds Are Forever",
            "Live and Let Die",
            "The Man with the Golden Gun",
            "The Spy Who Loved Me",
            "Moonraker",
            "For Your Eyes Only",
            "Octopussy",
            "A View to a Kill",
            "The Living Daylights",
            "Licence to Kill",
            "GoldenEye",
            "Tomorrow Never Dies",
            "The World Is Not Enough",
            "Die Another Day",
            "Casino Royale",
            "Quantum of Solace",
            "Skyfall",
            "Spectre",
            "No Time to Die"
        };

        return jamesBondFilms;
    } // End bondFilms



    //Start bondVillains
    //This method creates a String array of James Bond villains
    public static String[] bondVillains()
    {
        String[] jamesBondVillains = {
            "Dr. Julius No",
            "Ernst Stavro Blofeld",
            "Goldfinger",
            "Auric Goldfinger",
            "Rosa Klebb",
            "Francisco Scaramanga",
            "Max Zorin",
            "Le Chiffre",
            "Raoul Silva",
            "Dominic Greene",
            "Karl Stromberg",
            "Elektra King",
            "Jaws",
            "Xenia Onatopp ",
            "Mr. White",
            "Dr. Madeleine Swann",
            "Blofeld"
        };

        return jamesBondVillains;

    } // End bondVillains



    //Start bondGirls
    //This method creates a String array of James Bond actresses
    public static String[] bondGirls()
    {
        String[] jamesBondGirls = {
            "Honey Ryder",
            "Tatiana Romanova",
            "Pussy Galore",
            "Domino Derval",
            "Tracy Bond",
            "Tiffany Case",
            "Solitaire",
            "Mary Goodnight",
            "Anya Amasova",
            "Holly Goodhead",
            "Octopussy",
            "Melina Havelock",
            "Kara Milovy",
            "Pam Bouvier",
            "Wai Lin",
            "Elektra King",
            "Jinx Johnson",
            "Vesper Lynd",
            "Camille Montes",
            "Moneypenny",
            "Madeleine Swann",
            "Paloma"
        };

        return jamesBondGirls;

    } // End bondGirls







    //Start bondRelatedQuestions
    //This method creates a String array of James Bond related questions
    public static String[] bondRelatedQuestions()
    {
        String [] bondQuestions= {
            "Who is your favourite James Bond actor? ",
            "What is your favourite James Bond film? ",
            "Who is your favourite James Bond villain? ",
            "Who is your favourite Bond girl? ",
        };

        return bondQuestions;
    }// End bondRelatedQuestions



    //Start randomNumberGenerator
    //This method generates a random integer number between and inclusive 0 and 3
    public static int randomNumberGenerator()
    {
        final int MAX_NUMBER_OF_QUESTION = 4;
        Random random = new Random();
        int randomFromZeroToFour = random.nextInt(MAX_NUMBER_OF_QUESTION);

        return randomFromZeroToFour;
    } // End randomNumberGenerator




    // start randomBondQuestion
    public static String randomBondQuestion(String[] bondQuestions)
    {
        int randomIndex = randomNumberGenerator();
        String randomQuestion = bondQuestions[randomIndex];
        return randomQuestion;

    } // End randomBondQuestion



    // Start randomBondQuestionAnswer
    //This method ask a random quesion and responds depending on the users answer
public static void randomBondQuestionAnswer(String[] bondQuestions, String[] jamesBondActors, String[] jamesBondGirls, String[] jamesBondFilms, String[] jamesBondVillains) { 
    String randomisedQuestion = randomBondQuestion(bondQuestions);

    if (randomisedQuestion.equals(bondQuestions[0])) {
        handleBondActorQuestion(bondQuestions[0], jamesBondActors);
    } else if (randomisedQuestion.equals(bondQuestions[3])) {
        handleBondGirlQuestion(bondQuestions[3], jamesBondGirls);
    } else if (randomisedQuestion.equals(bondQuestions[1])) {
        handleBondFilmQuestion(bondQuestions[1], jamesBondFilms);
    } else {
        handleBondVillainQuestion(bondQuestions[2], jamesBondVillains);
    }
} // End randomBondQuestionAnswer




// Start handleBondActorQuestion
// This method handles the input validation for the favourite bond question
private static void handleBondActorQuestion(String question, String[] actors) {
    String answer = inputString(question);
    while (!isValidAnswerForArray(answer, actors)) {
        System.out.println("That's not a Bond actor. Enter a real name. Get help from Wikipedia if you need: ");
        answer = inputString(question);
    }
    respondToBondActorAnswer(answer, actors);
} // End handleBondActorQuestion


// Start respondToBondActorAnswer
// This method handles the response to the favourite bond actor question
private static void respondToBondActorAnswer(String answer, String[] actors) {
    if (answer.equalsIgnoreCase(actors[0])) {
        System.out.println("Really? " + actors[0] + " is my favourite too!");
    } else {
        System.out.println(answer + " is a great Bond. However, I think " + actors[0] + " is the best.");
    }
} // End respondToBondActorAnswer



// Start handleBondGirlQuestion
private static void handleBondGirlQuestion(String question, String[] girls) {
    String answer = inputString(question);
    while (!isValidAnswerForArray(answer, girls)) {
        System.out.println("That's not a Bond girl. Enter a real name. Get help from Wikipedia if you need: ");
        answer = inputString(question);
    }
    respondToBondGirlAnswer(answer, girls);
}// End handleBondGirlQuestion

// Start respondToBondGirlAnswer
private static void respondToBondGirlAnswer(String answer, String[] girls) {
    if (answer.equalsIgnoreCase(girls[1])) {
        System.out.println("Played by the beautiful Daniela Bianchi, " + girls[1] + " is my favourite Bond girl too.");
    } else {
        System.out.println(answer + " is a great Bond girl, but in my opinion, Tatiana Romanova was the best match for Bond.");
    }
} // End respondToBondGirlAnswer

// Start handleBondFilmQuestion
private static void handleBondFilmQuestion(String question, String[] films) {
    String answer = inputString(question);
    while (!isValidAnswerForArray(answer, films)) {
        System.out.println("That's not a valid Bond film. Enter a real title. Get help from Wikipedia if you need: ");
        answer = inputString(question);
    }
    respondToBondFilmAnswer(answer, films);
}// End handleBondFilmQuestion

// Start respondToBondFilmAnswer
private static void respondToBondFilmAnswer(String answer, String[] films) {
    if (answer.equalsIgnoreCase(films[1])) {
        System.out.println("I agree, " + films[1] + " is a masterpiece.");
    } else {
        System.out.println("No matter how good " + answer + " is, it'll never be as good as From Russia with Love!");
    }
} // End respondToBondFilmAnswer

// Start handleBondVillainQuestion
private static void handleBondVillainQuestion(String question, String[] villains) {
    String answer = inputString(question);
    while (!isValidAnswerForArray(answer, villains)) {
        System.out.println("That's not a Bond villain. Enter a real name. Get help from Wikipedia if you need: ");
        answer = inputString(question);
    }
    respondToBondVillainAnswer(answer, villains);
}// End handleBondVillainQuestion

// Start respondToBondVillainAnswer
private static void respondToBondVillainAnswer(String answer, String[] villains) {
    if (answer.equalsIgnoreCase(villains[7])) {
        System.out.println("I agree, " + villains[7] + " is the ultimate Bond villain. He's the one who sets the bar for all the others.");
    } else {
        System.out.println(answer + " is a great Bond villain, but Le Chiffre is the one who really knows how to be evil.");
    }
} // End respondToBondVillainAnswer

    //#endregion James Bond related methods

    

    

    // Start botOutro
    public static void botOutro(String name, String favFilms) {
        
        System.out.println("It was nice talking to you, " + name + ", about films today.");
        System.out.println("Until next time, farewell!");

    } // End botOutro



    // Start inputString
    public static String inputString(String message) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();

    } // End inputString


    // Start inputInt
    //A method to input Integers
    public static int inputInt(String message)
    {
        return Integer.parseInt(inputString(message));
    }// End inputInt




    // Main method to handle the flow of the chatbot
    public static void filmBot1() throws IOException {

        botIntro();
        String name = getName();
        if (doesFileExist(name + ".txt")) {
            loadUserData(name);
        }
        String favFilms = favFilmSeries(name);
        mentionFavFilm(favFilms);

        String[] bondQuestions = bondRelatedQuestions();
        String[] jamesBondActors = bondActors();
        String[] jamesBondGirls = bondGirls();
        String[] jamesBondFilms = bondFilms();
        String[] jamesBondVillains = bondVillains();

        favFilmSeriesResponse(favFilms, name, bondQuestions, jamesBondActors, jamesBondGirls, jamesBondFilms, jamesBondVillains);
        loopAskFavFilmSeries(name, bondQuestions, jamesBondActors, jamesBondGirls, jamesBondFilms, jamesBondVillains);
    
        botOutro(name, favFilms);

        } // End filmBot1


} // End ChatterBoxPrt7
