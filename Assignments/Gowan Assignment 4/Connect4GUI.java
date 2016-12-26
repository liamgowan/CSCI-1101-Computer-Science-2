/*Assignment 4, Part 2, CSCI 1101
Connect4GUI.java will create a GUI to play Connect Four with. It has a method for AI (to
decided where the best spot for a chip would be), a winChecker, a method which
puts the chip in the lowest possible position, an action performed method, and of course a main
method. It has both a one player and two player mode. The two player mode was first added simply 
to understand how everything would work with the winChecker method and lowest possible position
method, but then perfected and kept for an additonal playing mode. The game will keep track of 
the score, unless if they return to the home screen. 
The black icon is used to indicate an empty position.
The red icon is used to indicate where user/first player put a chip.
The yellow icon is used to indicate where computer/second player put a chip.
The star icon is used to indicate where this is win by first player, computer, or second player.

July 28, 2015
Liam Gowan B00673126
This is entirely my own work.
The following API's were examined during this program.
http://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html
http://docs.oracle.com/javase/7/docs/api/javax/swing/JLabel.html
The images of chips were made by myselfusing Microsoft Word 2011 shape tool, and were then screenshotted.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Connect4GUI extends JFrame implements ActionListener{
   private JPanel panel1,panel2, panel3;//creates 3 panels
   private JLabel modePick, score1, score2, fullScreen; //creates five JLabels
   private JButton playAgain, onePlayer, twoPlayer, startOver, home;//creates 5 buttons
   private int[][] board = new int[6][7];//creates int 2D array 
   private JButton[][] GBoard;//creates 2D array of buttons
   private int turn=1;
   private int totalTurns =1;
   private int scoreRED=0;
   private int scoreYELLOW=0;
   private int mode=0;
   private boolean wonYet = false;
   //makes four icons
   Icon blackicon = new ImageIcon("blackness.png");
   Icon redicon = new ImageIcon("red.png");
   Icon yellowicon = new ImageIcon("yellow.png");
   Icon star = new ImageIcon("star.png");
   
   public Connect4GUI(){
      /*Home screen is made up of a label asking whether they want to play against computer
      or another user, and there are two buttons saying "One Player" and "Two Player".
      The following code just adds everything to the GUI frame and sets it's start up visibilities and
      what has action listeners. */
      panel3 = new JPanel();
      modePick = new JLabel("User VS User or User VS The Computer?");
      fullScreen = new JLabel("No more moves. TIE!");
      onePlayer = new JButton("One Player");
      twoPlayer = new JButton("Two Player");
      playAgain = new JButton("Play Again?");
      startOver = new JButton("Start over?");
      home = new JButton("Home");
      playAgain.addActionListener(this);
      playAgain.setVisible(false);
      startOver.addActionListener(this);
      home.addActionListener(this);
      startOver.setVisible(false);
      home.setVisible(false);
      panel3.add(playAgain);
      panel3.add(modePick);
      panel3.add(onePlayer);
      panel3.add(fullScreen);
      panel3.add(home);
      panel3.add(startOver);
      fullScreen.setVisible(false);
      onePlayer.addActionListener(this);
      panel3.add(twoPlayer);
      twoPlayer.addActionListener(this);
      panel2 = new JPanel(new GridLayout(6,7));
      panel1 = new JPanel();
      score1 = new JLabel("Red: " + scoreRED);
      score1.setVisible(false);
      panel1.add(score1);
      score2 = new JLabel("Yellow: " + scoreYELLOW);
      score2.setVisible(false);
      panel1.add(score2);
      GBoard = new JButton[6][7];
      for(int i =0; i<6; i++){//sets up 42 buttons, gives each a picture of a black icon
         for(int j=0; j<7; j++){
            GBoard[i][j] = new JButton(blackicon);
            GBoard[i][j].addActionListener(this);
            GBoard[i][j].setActionCommand(i+","+j);
            panel2.add(GBoard[i][j]);
         }
      }
      //tells java where to put each panel
      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.CENTER);
      add(panel3, BorderLayout.SOUTH);
      panel2.setVisible(false);
      panel3.setVisible(true);
      setTitle("Connect 4");
      setSize(1100, 1100);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(true); 
   }
   public void actionPerformed(ActionEvent e){
      boolean winnerYes = false;
      if(e.getSource()==onePlayer){
         /*If the one player button is pushed, the turn and totalTurns will be reset to 1. wonYet
         will be reset to false. A board of buttons will first have all action listeners removed, 
         set to display a black icon, and then all action listeners will be re-added. panel2 will be
         set to visible, the label and buttons that ask user which mode they want to play will
         be set to invisible. The score of the user and computer will be visible. Mode will be set to 1. */
         turn =1;
         totalTurns =1;
         wonYet=false;
         for(int a=0; a<6; a++){
            for(int b=0; b<7; b++){
               board[a][b]=0;
               GBoard[a][b].removeActionListener(this);
               GBoard[a][b].setIcon(blackicon);
               GBoard[a][b].addActionListener(this);
            }
         }
         panel2.setVisible(true);
         modePick.setVisible(false);
         onePlayer.setVisible(false);
         twoPlayer.setVisible(false);
         score1.setVisible(true);
         score2.setText("Computer: " + scoreYELLOW);
         score2.setVisible(true);
         mode = 1;
         playAgain.setEnabled(false);
      }   
      if(e.getSource() == twoPlayer){
      /*If the one player button is pushed, the turn and totalTurns will be reset to 1. wonYet
         will be reset to false. A board of buttons will first have all action listeners removed, 
         set to display a black icon, and then all action listeners will be re-added. panel2 will be
         set to visible, the label and buttons that ask user which mode they want to play will
         be set to invisible. The score of the user and computer will be visible. Mode will be set to 2. */
         turn =1;
         totalTurns =1;
         wonYet=false;
         for(int a=0; a<6; a++){
            for(int b=0; b<7; b++){
               board[a][b]=0;
               GBoard[a][b].removeActionListener(this);
               GBoard[a][b].setIcon(blackicon);
               GBoard[a][b].addActionListener(this);
            }
         }
         panel2.setVisible(true);
         modePick.setVisible(false);
         onePlayer.setVisible(false);
         twoPlayer.setVisible(false);
         score1.setVisible(true);
         score2.setVisible(true);
         mode = 2;
         playAgain.setEnabled(false);

      }
      else if(mode ==1){//one player game mode
         //makes startOver and home button visible
         startOver.setVisible(true);
         home.setVisible(true);
         playAgain.setVisible(true);
         for(int i=0; i<6; i++){//checks for all rows
            for(int j=0; j<7; j++){//checks for all rows
               if(e.getSource()==GBoard[i][j]){//checks to see which button was pressed
                  int x = checkLowestPossible(j,1);//adds a 1 to the lowest part of board[][] array (integer)
                  if(x != -1){//if above method has not returned -1, the following shall happen
                     GBoard[x][j].setIcon(redicon);//sets applicable button to be red
                     totalTurns++;//increases total turns
                     if(winCheck() &&turn%2!=0){//happens only if there isn't a winner yet, and turn is odd
                        wonYet = true;
                        scoreRED++;//increases score of red
                        score1.setText("Red: " + scoreRED);
                        for(int y=0; y<6; y++){//removes every action listener
                           for(int z=0; z<7; z++){
                              GBoard[y][z].removeActionListener(this);
                           }
                        }
                        playAgain.setEnabled(true);//makes the playAgain button enabled
                        turn--;     
                     }
                     turn++;//increases turn number
                     if(!wonYet){//if there hasn't been a winner yet, then do the following
                        int b = AI();//b is = to a number given by AI method
                        int c = checkLowestPossible(b,2);//sees lowest row b can go into, sets c to it
                        while(c==-1&&!wonYet){//runs if c==-1 and if there isn't a winner
                           b = AI();
                           c = checkLowestPossible(b,2);
                        }
                        if(wonYet == false&&b!=-1)//sets applicable button to yellow
                           GBoard[c][b].setIcon(yellowicon);
                        totalTurns++;//increases turn
                     }
                     if(winCheck() && turn%2==0){//checks to see if there is a win on an even (computer) turn
                        scoreYELLOW++;//increases comp core
                        score2.setText("Computer: " + scoreYELLOW);//shows score of comp
                        for(int y=0; y<6; y++){//removes every listener
                           for(int z=0; z<7; z++){
                              GBoard[y][z].removeActionListener(this);
                           }
                        }
                        playAgain.setEnabled(true);  
                        turn--;   
                     }
                     turn++;
                     if(totalTurns==42){//Displays that board is full if it is
                        fullScreen.setVisible(true);
                        playAgain.setEnabled(true);
                     }
                  }
               }
            }
         }
      } 
      if(mode == 2){//Two player mode
         playAgain.setVisible(true);
         scoreRED=0;
         scoreYELLOW=0;
         score1.setText("Red: " + scoreRED);
         score2.setText("Yellow: " + scoreYELLOW);
         score1.setVisible(true);
         score2.setVisible(true);
         //makes startOver and home button visible
         startOver.setVisible(true);
         home.setVisible(true);
         for(int i=0; i<6; i++){//checks to see where button was pressed
            for(int j=0; j<7; j++){
               if(e.getSource()==GBoard[i][j]){
                  if(turn%2!=0){//if turn is odd, it's reds turn
                     int x = checkLowestPossible(j,1);//sees lowest possible position of button click
                     if(x !=-1)//if not -1, makes applicable button red
                        GBoard[x][j].setIcon(redicon);
                     turn++;//increases turn
                     if(winCheck()){//if there is a winner, increase score, remove all listeners
                        scoreRED++;
                        score1.setText("Red: " + scoreRED);
                        for(int a=0; a<6; a++){
                           for(int b=0; b<7; b++){
                              GBoard[a][b].removeActionListener(this);
                           }
                        }
                        playAgain.setEnabled(true);     
                     }
                  }
                  else if(turn%2==0){//yellow's turn
                     int x = checkLowestPossible(j,2);//checks lowest position for where button click can go
                     if(x!=-1)//sets applicable button to yellow
                        GBoard[x][j].setIcon(yellowicon);
                     turn++;//increases turn
                     if(winCheck()){//if there is a winner, increases score of yellow, removes all listeners
                        scoreYELLOW++;
                        score2.setText("Yellow: " + scoreYELLOW);
                        for(int a=0; a<6; a++){
                           for(int b=0; b<7; b++){
                              GBoard[a][b].removeActionListener(this);
                           }
                        }
                        playAgain.setEnabled(true);//sets playAgain to enabled 
                     }
                  }
               }  
            }
         }
      }
      if(e.getSource() == playAgain){
         //if playAgain button is pushed it will set turn and totalTurns to 1, and wonYet to false
         totalTurns = 1;
         turn = 1;
         wonYet = false;
         for(int a=0; a<6; a++){//removes all board pieces action listeners, sets buttons to black, re-
                                //adds action listeners
            for(int b=0; b<7; b++){
               board[a][b]=0;
               GBoard[a][b].removeActionListener(this);
               GBoard[a][b].setIcon(blackicon);
               GBoard[a][b].addActionListener(this);
            }
         }
         fullScreen.setVisible(false);//makes label invisible
         playAgain.setEnabled(false);//makes itself disabled
      }
      if(e.getSource() == startOver){
         playAgain.setEnabled(true);
         playAgain.doClick();//pushed the playAgain button
         playAgain.setEnabled(false);
      }
      if(e.getSource() == home){
         //If the home button is pushed, it will make all of panel 1 and 2 invisble,
         //but will make the one and two player buttons visible, as well as the label
         //explaining what they do
         playAgain.setVisible(false);
         panel2.setVisible(false);
         home.setVisible(false);
         startOver.setVisible(false);
         score1.setVisible(false);
         score2.setVisible(false);
         onePlayer.setVisible(true);
         twoPlayer.setVisible(true);
         modePick.setVisible(true);
      }       
   }
   
   public int checkLowestPossible(int j, int m){
      //This method serves to ensure that only the button at lowest possible location will be turned
      //red/yellow
      for(int i =5; i>=0; i--){
         if(board[i][j]==0){
            board[i][j] = m;
            return i;
         }
      }
      return -1;
   } 
   public boolean winCheck(){
      //This methods checks to see if there is a winner. Every nested for loop works in the same way
      //in that it goes through and sees if there are four integers in the board array that
      //are the same, if they aren't 0. If so, the applicable buttons in the GBoard[][] will be
      //turned into a star, the wonYet variable will be set to true, and method will return true.
      
      //check diagonals 
      for(int i=0; i<3; i++){//goes through rows
         for(int j=0; j<4; j++){//goes through columns
            if(board[i][j+3] != 0 && board[i+1][j+2] != 0 && board[i+2][j+1] != 0 && 
            board[i+3][j] != 0)
               if(board[i][j+3]==(board[i+1][j+2]))
                  if(board[i][j+3]==(board[i+2][j+1]))
                     if(board[i][j+3]==(board[i+3][j])){
                        GBoard[i][j+3].setIcon(star);
                        GBoard[i+1][j+2].setIcon(star);
                        GBoard[i+2][j+1].setIcon(star);
                        GBoard[i+3][j].setIcon(star);
                        wonYet=true;
                        return true;
                     }
         }
      }
      //checks for subdiagonals
      for(int i=0; i<3; i++){//goes through rows
         for(int j=0; j<4; j++){//goes through columns
            if(board[i][j] != 0 && board[i+1][j+1] != 0 && board[i+2][j+2] != 0 &&
            board[i+3][j+3] != 0)
               if(board[i][j] == (board[i+1][j+1]))
                  if(board[i][j] == (board[i+2][j+2]))
                     if(board[i][j] == (board[i+3][j+3])){
                        GBoard[i][j].setIcon(star);
                        GBoard[i+1][j+1].setIcon(star);
                        GBoard[i+2][j+2].setIcon(star);
                        GBoard[i+3][j+3].setIcon(star);
                        wonYet=true;
                        return true;
                     }              
         }
      }
      //check horizontals
      for(int i=0; i<6; i++){//goes through rows
         for(int j=0; j<4; j++){//goes through columns
            if(board[i][j] != 0 && board[i][j+1] != 0 && board[i][j+2] != 0 && 
            board[i][j+3] != 0){
               if(board[i][j]==(board[i][j+1]))
                  if(board[i][j]==(board[i][j+2]))
                     if(board[i][j]==(board[i][j+3])){
                        GBoard[i][j].setIcon(star);
                        GBoard[i][j+1].setIcon(star);
                        GBoard[i][j+2].setIcon(star);
                        GBoard[i][j+3].setIcon(star);
                        wonYet=true;
                        return true;
                     }
            }
         }
      }
      //checks for vertical wins
      for(int i=0; i<3; i++){//checks rows
         for(int j=0; j<7; j++){//checks columns
            if(board[i][j] != 0 && board[i+1][j] != 0 && board[i+2][j] != 0 && 
            board[i+3][j] != 0){
               if(board[i][j]==(board[i+1][j]))
                  if(board[i][j]==(board[i+2][j]))
                     if(board[i][j]==(board[i+3][j])){
                        GBoard[i][j].setIcon(star);
                        GBoard[i+1][j].setIcon(star);
                        GBoard[i+2][j].setIcon(star);
                        GBoard[i+3][j].setIcon(star);
                        wonYet=true;
                        return true;
                     }
            }
         }
      }
      return false;        
   }
   public int AI(){
      /*This method only returns one integer, referring to one column a "chip will be dropped into".
      It first sees to if it can win anywhere (verticals, all horizontals, all diagnonals, and all sub
      subdiagonals). If if can't win anywhere, it will then see if the user is one move away from
      winning by checking for all verticals, all horizontals, all diagnonals, and all sub
      subdiagonals, and will block it. It also of course makes sure that when blocking that there is nothing 
      below the space for where it would have to have the chip. Since it would be too easy to beat the computer 
      by simply putting 3 red chips in a row with nothing on either side, the computer checks for that and will 
      block (-RR-) on the left. Since a smart real player would attempt to set itself up for a win if it couldn't win 
      or block on a given turn, if the computer has no other moves it will try and itself up for a vertical or
      horizontal win by connecting 3. If and only if none of this is possible, the computer will then
      generate a random number.
      */
      
      //only checks for columns
      for(int i=0; i<3; i++){
         for(int j=0; j<7; j++){
            if(board[i][j]==0 && board[i+1][j]==2 && board[i+2][j]==2 && board[i+3][j]==2){
               return j;
               
            }
         }
      }
      //checks for horizontals (Y-YY)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i][j+1]==0 && board[i][j+2]==2 && board[i][j+3]==2){
               if((i==5)||
                  (i==4&&board[5][j+1]!=0) ||
                  (i==3&&board[5][j+1]!=0&&board[4][j+1]!=0) ||
                  (i==2&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0) ||
                  (i==1&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0) ||
                  (i==0&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0&&board[1][j+1]!=0) ||
                  (i==0&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0&&board[1][j+1]!=0&&board[0][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for horizontals (YY-Y)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i][j+1]==2 && board[i][j+2]==0 && board[i][j+3]==2){
               if((i==5)||
                  (i==4&&board[5][j+2]!=0) ||
                  (i==3&&board[5][j+2]!=0&&board[4][j+2]!=0) ||
                  (i==2&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0) ||
                  (i==1&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0) ||
                  (i==0&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0&&board[1][j+2]!=0) ||
                  (i==0&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0&&board[1][j+2]!=0&&board[0][j+2]!=0)){
                  return j+2;
               }
            }
         }
      }
      //checks for horizontals (-YYY)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==0 && board[i][j+1]==2 && board[i][j+2]==2 && board[i][j+3]==2){
               if((i==5)||
                  (i==4&&board[5][j]!=0) ||
                  (i==3&&board[5][j]!=0&&board[4][j]!=0) ||
                  (i==2&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0) ||
                  (i==1&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0) ||
                  (i==0&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0&&board[1][j]!=0) ||
                  (i==0&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0&&board[1][j]!=0&&board[0][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for horizontals (YYY-)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i][j+1]==2 && board[i][j+2]==2 && board[i][j+3]==0){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+3;
               }
            }
         }
      }
      //checks for diagonal (-YYY)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==0 && board[i+2][j+1]==2 && board[i+1][j+2]==2 && board[i][j+3]==2){
               if((i+3==5)||
                  (i+2==4&&board[5][j]!=0)||
                  (i+1==3&&board[5][j]!=0&&board[4][j]!=0)||
                  (i==2&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0)||
                  (i==1&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0)||
                  (i==0&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0&&board[1][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for diagonal (Y-YY)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==2 && board[i+2][j+1]==0 && board[i+1][j+2]==2 && board[i][j+3]==2){
               if((i==2&&board[5][j+1]!=0)||
                  (i==1&&board[5][j+1]!=0&&board[4][j+1]!=0)||
                  (i==0&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for diagonal (YY-Y)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==2 && board[i+2][j+1]==2 && board[i+1][j+2]==0 && board[i][j+3]==2){
               if((i==2&&board[5][j+2]!=0&&board[4][j+2]!=0)||
                  (i==1&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0)||
                  (i==0&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0)){
                  return j+2;
               }
            }
         }
      }
      //checks for diagonal (YYY-)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==2 && board[i+2][j+1]==2 && board[i+1][j+2]==2 && board[i][j+3]==0){
               if((i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0)||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0)||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0)){
                  return j+3;
               }
            }
         }
      }
      //checks for subdiagonal (-YYY)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==0 && board[i+1][j+1]==2 && board[i+2][j+2]==2 && board[i+3][j+3]==2){
               if((i==0&&board[1][j]!=0)||
                  (i==1&&board[2][j]!=0)||
                  (i==2&&board[3][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for subdiagonal (Y-YY)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i+1][j+1]==0 && board[i+2][j+2]==2 && board[i+3][j+3]==2){
               if((i==0&&board[2][j+1]!=0)||
                  (i==1&&board[3][j+1]!=0)||
                  (i==2&&board[4][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for subdiagonal (YY-Y)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i+1][j+1]==2 && board[i+2][j+2]==0 && board[i+3][j+3]==2){
               if((i==0&&board[3][j+2]!=0)||
                  (i==1&&board[4][j+2]!=0)||
                  (i==2&&board[5][j+2]!=0)){
                  return j+2;
               }
            }
         }
      }
      //checks for subdiagonal (YYY-)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==2 && board[i+1][j+1]==2 && board[i+2][j+2]==2 && board[i+3][j+3]==0){
               if((i==0&&board[4][j+3]!=0)||
                  (i==1&&board[5][j+3]!=0)||
                  (i==2)){
                  return j+3;
               }
            }
         }
      }
      //BLOCK CHECKER
      //columns
      for(int i=0; i<3; i++){
         for(int j=0; j<7; j++){
            if(board[i][j]==0 && board[i+1][j]==1 && board[i+2][j]==1 && board[i+3][j]==1){
               return j;  
            }
         }
      }
      //Checks for blocks horizontal (R-RR)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i][j+1]==0 && board[i][j+2]==1 && board[i][j+3]==1){
               if((i==5)||
                  (i==4&&board[5][j+1]!=0) ||
                  (i==3&&board[5][j+1]!=0&&board[4][j+1]!=0) ||
                  (i==2&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0) ||
                  (i==1&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0) ||
                  (i==0&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0&&board[1][j+1]!=0) ||
                  (i==0&&board[5][j+1]!=0&&board[4][j+1]!=0&&board[3][j+1]!=0&&board[2][j+1]!=0&&board[1][j+1]!=0&&board[0][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for horizontal blocks (RR-R)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i][j+1]==1 && board[i][j+2]==0 && board[i][j+3]==1){
               if((i==5)||
                  (i==4&&board[5][j+2]!=0) ||
                  (i==3&&board[5][j+2]!=0&&board[4][j+2]!=0) ||
                  (i==2&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0) ||
                  (i==1&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0) ||
                  (i==0&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0&&board[1][j+2]!=0) ||
                  (i==0&&board[5][j+2]!=0&&board[4][j+2]!=0&&board[3][j+2]!=0&&board[2][j+2]!=0&&board[1][j+2]!=0&&board[0][j+2]!=0)){
                  return j+2;
               }
            }
         }
      }
      
      //checks for horizontals (-RRR)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==0 && board[i][j+1]==1 && board[i][j+2]==1 && board[i][j+3]==1){
               if((i==5)||
                  (i==4&&board[5][j]!=0) ||
                  (i==3&&board[5][j]!=0&&board[4][j]!=0) ||
                  (i==2&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0) ||
                  (i==1&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0) ||
                  (i==0&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0&&board[1][j]!=0) ||
                  (i==0&&board[5][j]!=0&&board[4][j]!=0&&board[3][j]!=0&&board[2][j]!=0&&board[1][j]!=0&&board[0][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for horizontals (RRR-)
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i][j+1]==1 && board[i][j+2]==1 && board[i][j+3]==0){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+3;
               }
            }
         }
      }
      //checks for diagonal (-RRR)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==0 && board[i+2][j+1]==1 && board[i+1][j+2]==1 && board[i][j+3]==1){
               if((i+3==5)||
                  (i+2==4&&board[i+3][j]!=0)||
                  (i+1==3&&board[i+3][j]!=0&&board[i+2][j]!=0)||
                  (i==2&&board[i+3][j]!=0&&board[i+2][j]!=0&&board[i+1][j]!=0)||
                  (i==1&&board[i+3][j]!=0&&board[i+2][j]!=0&&board[i+1][j]!=0&&board[i][j]!=0)||
                  (i==0&&board[i+3][j]!=0&&board[i+2][j]!=0&&board[i+1][j]!=0&&board[i][j]!=0&&board[i-1][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for diagonal (R-RR)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==1 && board[i+2][j+1]==0 && board[i+1][j+2]==1 && board[i][j+3]==1){
               if((i+2==4&&board[i+3][j+1]!=0)||
                  (i+1==3&&board[i+3][j+1]!=0&&board[i+2][j+1]!=0)||
                  (i==2&&board[i+3][j+1]!=0&&board[i+2][j+1]!=0&&board[i+1][j+1]!=0)||
                  (i==1&&board[i+3][j+1]!=0&&board[i+2][j+1]!=0&&board[i+1][j+1]!=0&&board[i][j+1]!=0)||
                  (i==0&&board[i+3][j+1]!=0&&board[i+2][j+1]!=0&&board[i+1][j+1]!=0&&board[i][j+1]!=0&&board[i-1][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for diagonal (RR-R)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==1 && board[i+2][j+1]==1 && board[i+1][j+2]==0 && board[i][j+3]==1){
               if((i==2&&board[i+2][j+2]!=0)){//||
                  return j+2;
               }
            }
         }
      }
      //checks for diagonal (RRR-)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i+3][j]==1 && board[i+2][j+1]==1 && board[i+1][j+2]==1 && board[i][j+3]==0){
               if((i==0&&board[1][j+3]!=0)||
                  (i==1&&board[2][j+3]!=0)||
                  (i==2&&board[3][j+3]!=0)){
                  return j+3;
               }
            }
         }
      }
      //checks for subdiagonal blocks(-RRR)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==0 && board[i+1][j+1]==1 && board[i+2][j+2]==1 && board[i+3][j+3]==1){
               if((i==0&&board[1][j]!=0)||
                  (i==1&&board[2][j]!=0)||
                  (i==2&&board[3][j]!=0)){
                  return j;
               }
            }
         }
      }
      //checks for subdiagonal blocks(Y-YY)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i+1][j+1]==0 && board[i+2][j+2]==1 && board[i+3][j+3]==1){
               if((i==0&&board[2][j+1]!=0)||
                  (i==1&&board[3][j+1]!=0)||
                  (i==2&&board[4][j+1]!=0)){
                  return j+1;
               }
            }
         }
      }
      //checks for subdiagonal blocks(YY-Y)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i+1][j+1]==1 && board[i+2][j+2]==0 && board[i+3][j+3]==1){
               if((i==0&&board[3][j+2]!=0)||
                  (i==1&&board[4][j+2]!=0)||
                  (i==2&&board[5][j+2]!=0)){
                  return j+2;
               }
            }
         }
      }
      //checks for subdiagonal blocks(YYY-)
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(board[i][j]==1 && board[i+1][j+1]==1 && board[i+2][j+2]==1 && board[i+3][j+3]==0){
               if((i==0&&board[4][j+3]!=0)||
                  (i==1&&board[5][j+3]!=0)||
                  (i==2)){
                  return j+3;
               }
            }
         }
      }
      //INTERMEDIATE BLOCKING
      //If horizontal (RR--) make it (RRY-)
      for(int i=0; i<6; i++){
         for(int j=0; j<3; j++){
            if(board[i][j]==1 && board[i][j+1]==1 && board[i][j+2]==0){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+2;
               }
            }
         }
      }
       //If horizontal (--RR) make it (-YRR)
      for(int i=0; i<6; i++){
         for(int j=0; j<3; j++){
            if(board[i][j+1]==0 && board[i][j+2]==1 && board[i][j+3]==1){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+1;
               }
            }
         }
      }
      //The following attempts to set the computer up for a win, instead of first just generating a random number
      for(int i=0; i<3; i++){
         for(int j=0; j<7; j++){
            if(board[i+1][j]==0 && board[i+2][j]==2 && board[i+3][j]==2){
               return j;
               
            }
         }
      }
      //If horizontal (-YY-) make it (-YYY)
      for(int i=0; i<6; i++){
         for(int j=0; j<3; j++){
            if(board[i][j]==0 && board[i][j+1]==2 && board[i][j+2]==2 && board[i][j+3]==0){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+3;
               }
            }
         }
      }
      //If horizontal (YY--) make it (YYY-)
      for(int i=0; i<6; i++){
         for(int j=0; j<3; j++){
            if(board[i][j]==2 && board[i][j+1]==2 && board[i][j+2]==0 && board[i][j+3]==0){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+2;
               }
            }
         }
      }
      //If horizontal (--YY) make it (-YYY)
      for(int i=0; i<6; i++){
         for(int j=0; j<3; j++){
            if(board[i][j]==0 && board[i][j+1]==0 && board[i][j+2]==2 && board[i][j+3]==2){
               if((i==5)||
                  (i==4&&board[5][j+3]!=0) ||
                  (i==3&&board[5][j+3]!=0&&board[4][j+3]!=0) ||
                  (i==2&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0) ||
                  (i==1&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0) ||
                  (i==0&&board[5][j+3]!=0&&board[4][j+3]!=0&&board[3][j+3]!=0&&board[2][j+3]!=0&&board[1][j+3]!=0&&board[0][j+3]!=0)){
                  return j+1;
               }
            }
         }
      }
      boolean sent = false;
      //The following code will simply generate a random number.
      int x = (int)((Math.random())*7);
      if(!wonYet){      
         while(!sent){
            if(board[0][x]!=0)
               x = (int)((Math.random())*7);
            else if(board[1][x]!=0)
               x = (int)((Math.random())*7);
            else if(board[2][x]!=0)
               x = (int)((Math.random())*7);
            else if(board[3][x]!=0)
               x = (int)((Math.random())*7);
            else if(board[4][x]!=0)
               x = (int)((Math.random())*7);
            else if(board[5][x]!=0)
               x = (int)((Math.random())*7);
            sent = true;
         }  
         return x;
      }
      return -1;  
   } 
   public static void main(String[] args){
      Connect4GUI game = new Connect4GUI();//main method
   }
}