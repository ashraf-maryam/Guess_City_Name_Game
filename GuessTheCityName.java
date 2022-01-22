//Author : Maryam Ashraf
//Date   : 11-15-2020
//File   : GuessTheCity.java

package com.company;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//Program begins
public class GuessTheCityName {

        //StartGame method
        public static void startGame(String fileName) throws IOException {

            City[] cities = returnCitiesFromFile(fileName);
            cities = shuffleCities(cities);

            Scanner userInput = new Scanner(System.in);

            int totalPoints = 0;

            int questionCounter = 1;

            while (questionCounter <= 3) {

                City city = cities[questionCounter];
                int pointPerCity = 3;
                questionCounter++;
                System.out.println("Please type your answer in all lowercase letters.");
                System.out.println("Here is your question:");
                System.out.println(city.getHintOne());
                String Answer1;
                Answer1 = userInput.nextLine();

                    if (Answer1.equals(city.getCityName())) {

                        totalPoints += pointPerCity;
                        System.out.println("Great job! Your total points is: " + totalPoints);
                        System.out.println(" ");

                    } else {

                        System.out.println("Oh no! You missed! Try again.");
                        pointPerCity--;
                        System.out.println("Here is your question:");
                        System.out.println(city.getHintTwo());
                        String Answer2;
                        Answer2 = userInput.nextLine();

                        if (Answer2.equals(city.getCityName())) {

                            totalPoints += pointPerCity;
                            System.out.println("Great job! Your total points is: " + totalPoints);

                        } else {

                            System.out.println("Oh no! You missed! Try again.");
                            pointPerCity--;
                            System.out.println("Here is your third question:");
                            System.out.println(city.getHintThree());
                            String Answer3;
                            Answer3 = userInput.nextLine();

                           if (Answer3.equals(city.getCityName())) {

                               totalPoints += pointPerCity;
                               System.out.println("Great job! Your total points is: " + totalPoints);
                           }
                        }
                    }

                }


            if( totalPoints >= 5){
                System.out.println("Congratulations! You are our new winner!");
            } else {
                System.out.println("Oh no. Better luck next time.");
            }

        }

        //method that shuffle the cities
        public static City[] shuffleCities (City[]cities){

            Random rand = new Random();

            int[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            City[] shuffledCities = new City[11];
            boolean[] citiesSelected = new boolean[11]; //[][false][false]
            int selectedCities = 0;
            int i = 0;

            //while loop that will shuffle cities and make sure not to repeat the same one
            while (selectedCities < 11) {

                int indexLocation = rand.nextInt(11);

                if (citiesSelected[indexLocation] == false) {

                    City randomCity = cities[indexLocation];
                    shuffledCities[i] = randomCity;
                    i++;
                    selectedCities++;
                    citiesSelected[indexLocation] = true;
                }

            }

            return shuffledCities;

        }

        //return Cities in an array
        public static City[] returnCitiesFromFile (String fileName) throws IOException {

            File myfile = new File(fileName);

            if(!myfile.exists()) {
                System.out.println("File " +fileName+ " does not exist!!!");
                System.exit(-1);
            }

            Scanner input = new Scanner(myfile);

            int numElements = input.nextInt();
            input.nextLine();

            City[] cities = new City[numElements];

            int i=0;
            while(input.hasNext()){
                String lineFromFile = input.nextLine();
                String[] tokens = lineFromFile.split(",");
                City tempCities = new City(tokens[0], tokens[1], tokens[2], tokens[3]);
                cities[i] = tempCities;
                i++;
            }
            return cities;

        }

        //main method
        public static void main (String[]args) throws IOException {

            //get the README.txt file
            Scanner userInput = new Scanner(System.in);
            String fileName = "cityNames.txt";

            //present the rules
            System.out.println("*****  Welcome to Guess The City Name!  ******");
            System.out.println(" ");
            System.out.println("Rules: ");
            System.out.println("There are 3 questions.");
            System.out.println("Every question is worth 3 points.");
            System.out.println("You will get three chances to answer a question before moving to the next one.");

            //let the games begin
            System.out.println(" ");
            System.out.println("Do you want to play? Say Yes or No.");
            String play;
            play = userInput.nextLine();

            //switch statement to catch the yes and nos
            switch (play) {

                case "YES":
                case "yes":
                case "Yes":
                    startGame(fileName);
                    break;
                case "no":
                case "NO":
                case "No":
                    System.out.println("Good-Bye!");
                    break;
            }

        }// main ends

}//program ends
