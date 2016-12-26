/*Assignment 2, Exercise 1 (Play), CSCI 1101
Play.java is the file in which a two player game of connect four can actually be played. It 
has two main while loops. The outer while loop gets the name of the two players, and accounts 
for the first two moves and tells the players what colour their chips are. The inner while 
accounts for every other move and checks to see if there is a winner. If there is a winner, the
inner while loop will break, and the outer while loop will ask the users if they wish to play
again. If they answer Y, the outer loop will repeat itself, otherwise it will break and the
entire program will exit. The program also says the round number each round. If the round > 42, 
the program will output a tie. This program can make a Connect4Board object and Chip objects.
Play.java has a method called showAll(), which when called will display all rows and columns 
numbers, and the colours of the Chip objects and their locations.
July 7, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

import java.util.Scanner;
public class Play{
   public static void main(String[] args){
      boolean noWinner = true;//used for controlling inner while loop.
      boolean playAgainOption = true;//used for controlling outer while loop.
      Scanner input = new Scanner(System.in);
      String player1;
      String player2;
      String winner = "";
      int counter = 1;//used for indicated round number
      while(playAgainOption){//let this be declared as the outer while loop
         /*This loop exists only to create a connect4Board object, to get the names of each
         user, and tell them what chip colour they are.
         */
         int colToAdd;
         Connect4Board c4 = new Connect4Board(6, 7);
         System.out.println("Welcome to Connect 4!");
         System.out.print("Player one, please enter your name: ");
         player1 = input.nextLine();
         System.out.print("Player two, please enter your name: ");
         player2 = input.nextLine();
         System.out.println("\nRound: " + counter); //displays round number
         System.out.println(player1 + " you have red chips \"R\", and you move first.");
         showAll(c4);//displays what the board looks like empty
         System.out.print("Please input a column between 1-7: ");
         colToAdd = input.nextInt();
         if(c4.add(colToAdd, "R"))
            showAll(c4);//shows first move
         System.out.println(player2 + " you have yellow chips \"Y\", and you move next.");
         System.out.print("Please input a column between 1-7: ");
         colToAdd = input.nextInt();
         if(c4.add(colToAdd, "Y"))
            showAll(c4);//shows second move
         counter++;//increases counter
         
         while(noWinner){//let this be declared as the inner while loop
            if(counter>42 && !(c4.winner())){
               //if the board is full, and there is still no winner, the inner loop shall break
               winner = "IT'S A TIE! NO ONE";
               counter = 1;
               break;
            }
            
            System.out.println("\nRound: " + counter);//displays round number
            System.out.println(player1 + " it is your turn.");
            //Prompts for column. Ensures input is between 1-7, and that column is not full
            System.out.print("Please enter a column between 1-7: ");
            colToAdd = input.nextInt();
            if(c4.add(colToAdd, "R"))
               showAll(c4);//displays all chips
            if(c4.winner()){
               //if there is a winner, the String winner will be the first players name, then break inner loop
               winner=player1.toUpperCase();
               break;
            }
            //The following works just the same as for player 1, apart from entering in a Y instead of R
            System.out.println(player2 + " it is your turn.");
            System.out.print("Please enter a column between 1-7: ");
            colToAdd = input.nextInt();
            if(c4.add(colToAdd, "Y"))
               showAll(c4);
            if(c4.winner()){
               winner = player2.toUpperCase();
               break;
            }
            counter++; //increases round number
         }
         /*Once the inner while loop breaks, program will display the winner name, (or "IT'S A TIE! NO ONE
         IS THE WINNER" if applicable) plus "IS THE WINNER!". It will then ask if the users want to play again
         and ensures that expected input is entered.
         */
         System.out.println("\n" + winner + " IS THE WINNER!");
         System.out.print("Play Again? (Y/N): ");
         String option = "" + input.nextLine();
         option = "" + input.nextLine().charAt(0);
         option = option.toUpperCase();
         while(!(option.equals("Y") || option.equals("N"))){
            System.out.print("Invalid option. Please enter Y or N: ");
            option = "" + input.nextLine().toUpperCase().charAt(0);
         } 
         if(option.equals("N")){
            //If user enters N the program will thank users for playing, and then break the 
            //outer loop
            System.out.print("Thanks for playing!");
            break;
         }
      }     
   }
      
      public static void showAll(Connect4Board c4){//displays the whole board
      System.out.println("\n\t 1\t 2\t 3\t 4\t 5\t 6\t 7\n");//displays column numbers
      for(int r=1; r<=6; r++){
         System.out.print(r);//displays row numbers
         for(int c=1; c<=7; c++){
            System.out.print("\t " + c4.getCB(r-1,c-1));//displays chip at specified location, or "" if null
         }
         System.out.println("\n");//makes new line
      }
   }
}
      