/*Lab 4, Exercise 2 (LotteryDemo), CSCI 1101
LotteryDemo.java creates a Lottery object and uses Scanner to read input from the user to set
the userArray in the Lottery.java file. It then calls the methods to find how many matches there were
and to print what the user wins.
July 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
/*Lab 4, Exercise 2 (LotteryDemo), CSCI 1101
LotteryDemo.java creates a Lottery object, creates an array of numbers selected by user and assigns
it to the userArray of Lottery object. It then displays how many matches there were between
user selected numbers and computer generated numbers.
July 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

import java.util.Scanner;
public class LotteryDemo{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Lottery lott = new Lottery();//creates Lottery object
      int userInput[] = new int[5];
      for(int i=0; i<5; i++){//recieves input
         System.out.print("\nEnter number " + (i+1) + ": ");
         userInput[i] = input.nextInt();
      }
      lott.userArrayMaker(userInput);//makes userArray
      lott.matches();//finds number of matches
      lott.printPrize();//prints what user wins
   }
}
         