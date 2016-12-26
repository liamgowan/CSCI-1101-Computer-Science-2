public class TextbookDemo{
   public static void main(String[] args){
      Textbook book1 = new Textbook("Harry Potter and the Philosopher's Stone",
      "J.K. Rowlings", "Bloomsbury", 1997 , 223, 21.12);
      Textbook book2 = new Textbook("Harry Potter and the Chamber of Secrets",
      "J.K. Rowlings", "Bloomsbury", 1997, 251, 22.44);
      Textbook book3 = book1.copy();
      if(book1.morePages(book2))
         System.out.println(book1.getTitle() + " has more pages than " +book2.getTitle() + ".");
      else
         System.out.println(book2.getTitle() + " has more pages than " + book1.getTitle() + ".");
      if(book1.isEqual(book2))
         System.out.println(book1.getTitle() + " is the same as " +book2.getTitle() + ".");
      else
         System.out.println(book1.getTitle() + " is not the same as " +book2.getTitle() + ".");
      if(book1.isEqual(book3))
         System.out.println(book1.getTitle() + " is the same as " +book3.getTitle() + ".");
      else
         System.out.println(book1.getTitle() + " is not the same as " +book3.getTitle() + ".");
      System.out.println("\nBook information: \n" + book1 + book2 + book3);   
   }
}