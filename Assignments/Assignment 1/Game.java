/*Assignment 1, Exercise 1, CSCI 1101
Game.java creates Game objects and contains variables that concern a phrase to be guessed and a
total jackpot amount. Game.java contains get and set methods, methods which display disguised phrases,
and if a phrase is the secretPhrase.
June 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

import java.util.Random;
public class Game{
   //instance variables
   private char[] lettersEntered = new char [6];
   private char [] secretPhrase;
   private int guessesMade;
   public int jackpotAmount= 0;
   private char lastLetterGuessMade;
   private int guessesLeft;
   char [] disguisedPhrase = new char[100];
   private String disguisedPhraseString="";
   private int guessesInWord;
   private int guessesOf1stInWord;
   private int guessesOf2ndInWord;
   private int guessesOf3rdInWord;
   private int guessesOf4thInWord;
   private int guessesOf5thInWord;
   private int guessesOf6thInWord;
   
   //constructer
   public Game(String secretPhrase){
   //creates Game object, sets guessesMade to 0 and guessesLeft to 6.
   //sets secretPhrase, and all correct guesses of each letter guesses to 0.
      guessesMade = 0;
      guessesLeft = 6;
      this.secretPhrase = secretPhrase.toUpperCase().toCharArray();
      guessesOf1stInWord=0;
      guessesOf2ndInWord=0;
      guessesOf3rdInWord=0;
      guessesOf4thInWord=0;
      guessesOf5thInWord=0;
      guessesOf6thInWord=0;
   }
   //accessor methods
   public int getJackpotAmount(){//gets total jackpot amount
      return jackpotAmount;
   }
   public char getLastCharEntered(){//returns last character entered
      return lastLetterGuessMade;
   }
   public int getGuessesForLetter(){
   //returns how many times a certain letter is correct
      return guessLetter(getLastCharEntered());
   }
   public int getGuessCount(){//returns the guesses already made
      return guessesMade;
   }
   public int getGuessesLeft(){//returns the guesses user has left
      return guessesLeft;
   }
   public String getSecretPhraseString(){//returns the secretPhrase has a string
      String s = new String(secretPhrase);
      return s;
   } 
   public char getLastLetterGuessed(int i){//returns certain letter guesses, depending on input
      return lettersEntered[i];
   }
   //mutator methods
   public void setLastLetterGuessMade(char c){//sets last letter guess
      lastLetterGuessMade = c;
   }
   public void setGuessesMade(){//increments guesses made by one
      guessesMade++;
   }
   //Other methods
   public int spinWheel(){//returns a int randomly that is 100, 200 or 500
      Random rand = new Random();
      int i = rand.nextInt(3);
      if(i==0)
         return 100;
      else if(i==1)
         return 200;
      else
         return 500;
   }
   public int guessLetter(char c){
   //sees if char c is in the secret word, and if it is it will increase counter by 1
   //It will then return the counter
      int counter = 0;
      for(int i=0; i<secretPhrase.length; i++){
         if(c==secretPhrase[i])
            counter++;
         
      }
      return counter;
   }
   
   public char[] getSecretPhrase(){//returns secretPhrase as a char array
      return secretPhrase;
   }
   public String getDisguisedPhrase(){
   //displays to the user what the clue of the word is by placing an underscore for 
   //every letter, and a space for every space in secretPhrase
      for(int i=0; i<secretPhrase.length; i++){
         if(secretPhrase[i]==' '){
            disguisedPhrase[i] = ' ';
            disguisedPhraseString += disguisedPhrase[i] + " ";
         }
         else{
            disguisedPhrase[i] = '_';
            disguisedPhraseString += "" + disguisedPhrase[i] + " " ;
         }
      }
      disguisedPhraseString = disguisedPhraseString;
      return "\n" + disguisedPhraseString +"\n";
   }

   public void increaseJackpot(int amt, int i){
   /*This method will increase the jackpot amount accordingly.
   This method contains a for loop, within a while loop. The for loop will
   increase 'count' by one every time that the character that is meant to be tested
   (indicated by i), and the jackpot will then be equal to the 'count' value
   multiplied by 'amt' in paramaters. 
   The while loop ensures that it will be broken, therefore ensuring that the 
   for loop will never happen, if ANY of the letters entered are the same as any of the
   other letters entered. This is to ensure that the jackpot will not increase
   for letters already entered.
   */ 
      boolean state = true;
      while(state){
         int count = 0;
         int x = i;
         if(getGuessCount() == 2 && (getLastLetterGuessed(1) == getLastLetterGuessed(0)))
            break; 
         if(getGuessCount() == 3 && (getLastLetterGuessed(2) == getLastLetterGuessed(0) || 
         getLastLetterGuessed(2) == getLastLetterGuessed(1)))
            break;
            if(getGuessCount() == 4 && (getLastLetterGuessed(3) == getLastLetterGuessed(0) || 
         getLastLetterGuessed(3) == getLastLetterGuessed(1) || getLastLetterGuessed(3) == getLastLetterGuessed(2)))
            break;
            if(getGuessCount() == 5 && (getLastLetterGuessed(4) == getLastLetterGuessed(0) || 
         getLastLetterGuessed(4) == getLastLetterGuessed(1) || getLastLetterGuessed(4) == getLastLetterGuessed(2)
         || getLastLetterGuessed(4) == getLastLetterGuessed(3)))
            break;
            if(getGuessCount() == 6 && (getLastLetterGuessed(5) == getLastLetterGuessed(0) || 
         getLastLetterGuessed(5) == getLastLetterGuessed(1) || getLastLetterGuessed(5) == getLastLetterGuessed(2)
         || getLastLetterGuessed(5) == getLastLetterGuessed(3) || getLastLetterGuessed(5) == getLastLetterGuessed(4)))
            break;
         for(int j=0; j<getSecretPhrase().length; j++){
            if(getLastLetterGuessed(i)==getSecretPhrase()[j])
               count++;
            }
         jackpotAmount += (amt * count);
         state = false;//ends loop if not broken
      }
   }
   
   public boolean isFound(){
      //method converts both secretPhrase and disguised phrase arrays to strings
      String secretPhraseOfCharArr = "";
      String disguisedPhraseOfCharArr = "";
      for(int i=0; i<secretPhrase.length; i++){
         secretPhraseOfCharArr += "" + secretPhrase[i];
      }
      for(int i=0; i<disguisedPhrase.length; i++){
         disguisedPhraseOfCharArr += "" + disguisedPhrase[i];
      }
      //method then determines if the disguised phrase is the same as the secretPhrase
      //and returns true or false
      if(secretPhraseOfCharArr.equals(disguisedPhraseOfCharArr))
         return true;
      else
         return false;
   }
   
   public boolean guessWord(String attemptAtPuzzle){
      //If user attemps to guess the entire word, this will return whether or not
      //the user is correct
      String CharToString = new String(getSecretPhrase());
      if(attemptAtPuzzle.equals(CharToString))
         return true;
      else 
         return false;
   }
   
   private void addToLettersEntered(char guess, int i){
   //sets the lettersEntered char array index of i to char
      lettersEntered[i] = guess;
   }
   
   public void findCorrectlyGuessedLetters(char guess, int i){
   //This method will display to the user which of their letters guessed are were correct.
      guessesMade++;
      addToLettersEntered(guess, i);
      String toDisplayToUser = "";
      int counter=0; //keeps track of how many characters are in toDisplayToUser
      boolean keepGoing = true;
      //For loop will run while keepGoing is true
      while(keepGoing){
         for(int it=0; it<getSecretPhrase().length; it++){
            if(counter == getSecretPhrase().length){
            //ensures loop will be end if counter is equal to the length of the secretPhrase array
               keepGoing = false;
            } 
            if(secretPhrase[it]==' '){
            //if character at index 'it' is a space, it will add two spaces to display 
               toDisplayToUser += "  ";
               counter = counter + 2;
            }
            else if(lettersEntered[0] == secretPhrase[it]){
            //if first char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesOf1stWord will be increased
               toDisplayToUser += lettersEntered[0];
               counter++;
               guessesOf1stInWord++;
            }
            else if(lettersEntered[1] == secretPhrase[it]){
            //if second char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesOf2ndWord will be increased
               toDisplayToUser += lettersEntered[1];
               counter++;
               guessesOf2ndInWord++; 
            }
            else if(lettersEntered[2] == secretPhrase[it]){
            //if third char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesOf3rdWord will be increased
               toDisplayToUser += lettersEntered[2];
               counter++;
               guessesOf3rdInWord++;
            }
            else if(lettersEntered[3] == secretPhrase[it]){
            //if fourth char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesOf4thWord will be increased
               toDisplayToUser += lettersEntered[3];
               counter++;
               guessesOf4thInWord++;
            }
            else if(lettersEntered[4] == secretPhrase[it]){
            //if fifth char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesOf5thWord will be increased
               toDisplayToUser += lettersEntered[4];
               counter++;
               guessesOf5thInWord++;
            }
            else if(lettersEntered[5] == secretPhrase[it]){
            //if sixth char entered is equal to index of secretPhrase being tested,
            //it will be added to 'toDisplayToUser', counter and guessesO6thWord will be increased
               toDisplayToUser += lettersEntered[5];
               counter++;
               guessesOf6thInWord++;
            }
            else{
            //otherwise print '_ '
               toDisplayToUser += "_ ";
               counter = counter + 2;
            }   
         }
         //The following if else statements will display only one message indicating how many times
         //the last letter guessed was in the secretPhrase. It will only print a message for this if
         //the guessesMade are what they are where indicated (to work for all rounds).
         //If there is more than 0 of the particular letter want being test at appropiate time, it will
         //send arguments to the letInPhrase method, which will return how many times the letter appears in 
         //the word. Other wise, it will say there are none of these left.
         
         if(guessesMade == 1 && guessesOf1stInWord != 0){
            letInPhrase(guessesOf1stInWord, 0);
         }
         else if(guessesMade == 1){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(0) + "'s.\n");
         }
         if(guessesMade == 2 && guessesOf2ndInWord != 0){
            letInPhrase(guessesOf2ndInWord, 1);
         }
         else if(guessesMade == 2){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(1) + "'s.\n");
         } 
         if(guessesMade == 3 && guessesOf3rdInWord != 0){
            letInPhrase(guessesOf3rdInWord, 2);
         }
         else if(guessesMade == 3){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(2) + "'s.\n");
         }
         
         if(guessesMade == 4 && guessesOf4thInWord != 0){
            letInPhrase(guessesOf4thInWord, 3);
         }
         else if(guessesMade == 4){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(3) + "'s.\n");
         } 
         if(guessesMade == 5 && guessesOf5thInWord != 0){
            letInPhrase(guessesOf5thInWord, 4);
         }
         else if(guessesMade == 5){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(4) + "'s.\n");
         }
         
         if(guessesMade == 6 && guessesOf6thInWord != 0){
            letInPhrase(guessesOf6thInWord, 5);
         }
         else if(guessesMade == 6){
            System.out.print("Sorry, there are no " + getLastLetterGuessed(5) + "'s.\n");
         }
         System.out.print(toDisplayToUser);//displays message
         keepGoing = false;//ends loop
      }
   }
   public void letInPhrase(int num, int i){
   //displays how many times the last letter guessed is in the secretPhrase
      if(num>0){
         System.out.print("\nThere is/are " + num + " " + getLastLetterGuessed(i) + ".\n\n");
      }
   } 
}