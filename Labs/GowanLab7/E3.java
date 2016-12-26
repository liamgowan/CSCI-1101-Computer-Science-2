/*Lab 7, Exercise 3, CSCI 1101
E3.java is a procedural program which creates three lists. It then asks the user
to enter in names on one line, and once they are finished to enter "-1", twice, which adds the names
entered into two different array lists. It then adds the names from both list1 and list2 to list 3 and 
sorts them alphabetically.
July 14, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class E3{
   public static void main(String[] args){
      //creates three lists
      ArrayList<String> names1 = new ArrayList<String>(20);
      ArrayList<String> names2 = new ArrayList<String>(20);
      ArrayList<String> names3 = new ArrayList<String>(40);
      Scanner input = new Scanner(System.in);
      String name;
      //Until line 32, the following code asks user to enter in names on two separate lines, which adds
      //them to list3
      System.out.println("Enter names on one line, end with -1");
      name = input.next();
      while(!name.equals("-1")){
         names1.add(name);
         name = input.next();
      }
      System.out.println("Enter names on one line, end with -1");
      name = input.next();
      while(!name.equals("-1")){
         names2.add(name);
         name = input.next();
      }
      boolean isLonger = false;
      //until line 92, program adds one name at a time, and sorts alphabetically
      for(int i=0; i<=(names1.size() + names2.size()); i++){
         //Will execute this if name1 size is less than name2 size
         if(names1.size()<names2.size()){
            //adds names up to if i/2 < names1 size
            if(i%2==0 && i/2<names1.size()){
               names3.add(names1.get(i/2));
               isLonger = true;
            }
            //adds names up and including to if i/2 < names2 size
            if(i%2!=0 && i/2<=names2.size()){
               names3.add(names2.get(i/2));
               isLonger = true;
            }
         }
         //executes if name1 size is greater than name2 size
         else if(names1.size()>names2.size()){
            //adds names up and including to if i/2 < names1 size
            if(i%2==0 && i/2<=names1.size()){
               names3.add(names1.get(i/2));
               isLonger = true;
            }
            //adds names up to if i/2 < names2 size
            if(i%2!=0 && i/2<names2.size()){
               names3.add(names2.get(i/2));
               isLonger = true;
            }
         }
         //executes if name1 size is the same as name2 size
         else if(names1.size() == names2.size()){
            //adds names up to if i/2 < names1 size
            if(i%2==0 && i/2<names1.size()){
               names3.add(names1.get(i/2));
               isLonger = true;
            }   
            //adds names up to if i/2 < names2 size   
            if(i%2!=0 && i/2<names2.size()){
               names3.add(names2.get(i/2));
               isLonger = true;
            }
         }
         //does the actual comparing and adds each part to name3
         for(int a=0; a<names3.size(); a++){
            String name1, name2;
            for(int j=0; j<names3.size(); j++){
               if(names3.get(a).compareTo(names3.get(j))<0){
                  name1=names3.get(a);
                  name2=names3.get(j);
                  names3.set(a, name2);
                  names3.set(j, name1);
               }
            }
         }
         //only prints if names3 is greater than what it was in the previous cycle of loop
         if(isLonger)
            System.out.println(names3);
         isLonger = false;
      }         
   }
}
      
      
      