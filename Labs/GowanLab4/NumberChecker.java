/*Lab 4, Exercise 3 (NumberChecker), CSCI 1101
NumberChecker.java has an instance variable of an 8 by 8 integer 2D array. It has a constructor, that
when called will make each element of the array either a 1 or 0 randomly. It has a method which
will test to see if all rows, columns, diagonal, or subdiagonal are all 0's or 1's.
July 4th, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class NumberChecker{
   //instance variables 
   public int[][] checkerBoard = new int[8][8];
   
   public NumberChecker(){
      for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
            checkerBoard[i][j] = (int)(Math.random()*2);
         }
      }
   }
   
   public void checkAll(){
      //check columns
      int hold = 10;
      for(int j=0; j<8; j++){
         if(checkerBoard[1][j] == checkerBoard[0][j])
            if(checkerBoard[2][j] == checkerBoard[0][j])
               if(checkerBoard[3][j] == checkerBoard[0][j])
                  if(checkerBoard[4][j] == checkerBoard[0][j])
                     if(checkerBoard[5][j] == checkerBoard[0][j])
                        if(checkerBoard[6][j] == checkerBoard[0][j])
                           if(checkerBoard[7][j] == checkerBoard[0][j])
                              hold = j;
         if(hold == 0){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 1");
            hold = 10;
         }
         else if(hold == 1){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 2");
            hold = 10;
         }
         else if(hold == 2){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 3");
            hold = 10;
         }
         else if(hold == 3){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 4");
            hold = 10;
         }
         else if(hold == 4){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 5");
            hold = 10;
         }
         else if(hold == 5){
            System.out.println("All " + checkerBoard[0][hold] + "'s in column 6");
            hold = 10;
         }
         else if(hold == 6){
         System.out.println("All " + checkerBoard[0][hold] + "'s in column 7");
         hold = 10;
         }
         else if(hold == 7){
         System.out.println("All " + checkerBoard[0][hold] + "'s in column 8");
         hold = 10;
         }
      }
      //check all rows
      for(int j=0; j<8; j++){
         if(checkerBoard[j][1] == checkerBoard[j][0])
            if(checkerBoard[j][2] == checkerBoard[j][0])
               if(checkerBoard[j][3] == checkerBoard[j][0])
                  if(checkerBoard[j][4] == checkerBoard[j][0])
                     if(checkerBoard[j][5] == checkerBoard[j][0])
                        if(checkerBoard[j][6] == checkerBoard[j][0])
                           if(checkerBoard[j][7] == checkerBoard[j][0])
                              hold = j;
         if(hold == 0){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 1");
            hold = 10;
         }
         else if(hold == 1){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 2");
            hold = 10;
         }
         else if(hold == 2){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 3");
            hold = 10;
         }
         else if(hold == 3){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 4");
            hold = 10;
         }
         else if(hold == 4){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 5");
            hold = 10;
         }
         else if(hold == 5){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 6");
            hold = 10;
         }
         else if(hold == 6){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 7");
            hold = 10;
         }
         else if(hold == 7){
            System.out.println("All " + checkerBoard[hold][0] + "'s in row 8");
            hold = 10;
         }
      }
   //check diagonal
   if(checkerBoard[7][0] == checkerBoard[6][1])
      if(checkerBoard[7][0] == checkerBoard[5][2])
         if(checkerBoard[7][0] == checkerBoard[4][3])
            if(checkerBoard[7][0] == checkerBoard[3][4])
               if(checkerBoard[7][0] == checkerBoard[2][5])
                  if(checkerBoard[7][0] == checkerBoard[1][6])
                     if(checkerBoard[7][0] == checkerBoard[0][7])
                        System.out.println("All " + checkerBoard[7][0] + "'s in diagonal");
   //check subdiagonal
   if(checkerBoard[0][0] == checkerBoard[1][1])
      if(checkerBoard[0][0] == checkerBoard[2][2])
         if(checkerBoard[0][0] == checkerBoard[3][3])
            if(checkerBoard[0][0] == checkerBoard[4][4])
               if(checkerBoard[0][0] == checkerBoard[5][5])
                  if(checkerBoard[0][0] == checkerBoard[6][6])
                     if(checkerBoard[0][0] == checkerBoard[7][7])
                        System.out.println("All " + checkerBoard[0][0] + "'s in subdiagonal");
               
   }
}