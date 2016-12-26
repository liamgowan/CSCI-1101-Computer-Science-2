/*Lab1 Part 1, Exercise 1, CSCI 1101
PaliChecker.java will ask the user for a phrase, and will determine if phrase entered
was a palindrome.
June 22, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class PaliChecker{
   public static void main(String[] args){
   Scanner input = new Scanner(System.in);
   //Prompts user for phrase, assigns to 'phrase'
   System.out.print("Please enter a word or phrase: ");
   String phrase = input.nextLine(); 
   String phraseHold = phrase.toLowerCase();//converts phrase to lowercase, assigns to phraseHold
   char [] stringToChar = convertString(phraseHold);//calls convertString method to change to char
   boolean validity = isReverse(stringToChar); //calls isReverse method to see if it same backwards
   //Depending on validity, states if phrase is a palindrome or not
   if(validity)
      System.out.print(phrase + " is a palindrome.");
   else
      System.out.print(phrase + " is not a palindrome.");
   }
    
   public static char[] convertString(String s){ //convers string to char
      String stringToBeConverted = "";
      /*For loop creates string and ensures that it will contain none of the characters
      given in the if statement */
      for(int i=0; i<s.length(); i++){
         if(s.charAt(i) != ' ' && s.charAt(i) != ' ' && s.charAt(i) != '/'
         && s.charAt(i) != '"' && s.charAt(i) != '!' && s.charAt(i) != ','
         && s.charAt(i) != '?' && s.charAt(i) != '-' && s.charAt(i) != ';'
         && s.charAt(i) != ':' && s.charAt(i) != '.'){
            stringToBeConverted += "" + s.charAt(i);
         }
      }
      //creates charArray from string using for loop
      char [] charArray = new char[stringToBeConverted.length()];
      for(int i = 0; i<stringToBeConverted.length(); i++){
         charArray[i] = stringToBeConverted.charAt(i);
      }
      return charArray;
   } 
      
   public static boolean isReverse (char[] arr){ //checks to see if a palindrome was entered      
      char[] reversedArr = new char[arr.length];
      for(int i=0; i<arr.length; i++){ //makes a char array in reversed order
         reversedArr[i] = arr[arr.length-1-i];
      }
      for(int i=0; i<reversedArr.length; i++){//sees if both char arrays are the same
         if(reversedArr[i] != arr[i]){
             return false;           
         }
      }
      return true;
   }
}