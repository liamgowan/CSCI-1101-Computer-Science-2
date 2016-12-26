public class HighSchoolDemo{
   public static void main(String[] args){
      //makes School object
      School s = new School("Eastern Shore District High");
      s.setNumStudents(500);//School constructor wasn't supposed to set number of students, so this line is needed
      System.out.print(s + "\n");//prints information about s
      //makes HighSchool object
      HighSchool hs = new HighSchool("Eastern Shore District High School", 501, "Patrick Savage", 30);
      //prints information about hs
      System.out.print(hs);
   }
}