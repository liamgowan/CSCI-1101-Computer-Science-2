/*Lab 4, Exercise 3 (NumberCheckerDemo), CSCI 1101
NumberCheckerDemo.java creates a NumberChecker object, displays the 8X8 grid, and calls
the checkAll() method to see where there are all either 0's or 1's.
July 4th, 2015
Liam Gowan B00673126
This is entirely my own work.
*/public class NumberCheckerDemo{
   public static void main(String[] args){
      NumberChecker n1 = new NumberChecker();
      for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
            System.out.print(n1.checkerBoard[i][j]);
         }
         System.out.println();
      }
   n1.checkAll();
   }
}