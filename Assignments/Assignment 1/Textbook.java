public class Textbook{
   //instance variables
   private String title, author, publisher;
   private int year, numPages;
   private double price;
   
   //constructor
   public Textbook(){}//creates object 
   
   //contstructor
   public Textbook(String t, String a, String p, int yr, int pp, double pr){
      //creates object, sets title, author, publisher, year, numPages and price
      title = t;
      author = a;
      publisher = p;
      year = yr;
      numPages = pp;
      price = pr;
   }
   
   //accessor methods
   public String getTitle(){
      return title; //returns title
   }
   public String getAuthor(){
      return author;//returns author
   }
   public String getPublisher(){
      return publisher;//returns publisher
   }
   public int getYear(){
      return year;//returns year
   }
   public int getNumPages(){
      return numPages;//returns number of pages
   }
   public double getPrice(){
      return price;//returns price
   }
   
   //mutator methods
   public void setTitle(String t){
      title = t;//sets title
   }
   public void setAuthor(String a){
      author = a;//sets author
   }
   public void setPublisher(String p){
      publisher = p;//sets publisher
   }
   public void setYear(int yr){
      year = yr;//sets year
   }
   public void setNumPages(int pp){
      numPages = pp;//sets numPages
   }
   public void setPrice(double pr){
      price = pr;//sets price
   }
   
   //other methods
   public boolean morePages(Textbook otherTB){
      if(getNumPages()>otherTB.getNumPages())
         return true;
      else
         return false;
   }
   public boolean isEqual(Textbook otherTB){
      //method checks to see if all attributes of another textbook are the same
      //as 'this' one. If it is, it will return true, otherwise it will return
      //false
      if(getTitle().equals(otherTB.getTitle()))
         if(getAuthor().equals(otherTB.getAuthor()))
            if(getPublisher().equals(otherTB.getPublisher()))
               if(getYear() == otherTB.getYear())
                  if(getNumPages() == otherTB.getNumPages())
                     if(getPrice() == otherTB.getPrice())
                        return true;
      return false;
   }
   
   public Textbook copy(){
   //if called, this will copy all the attributes of this object to another
      Textbook dup = new Textbook(getTitle(), getAuthor(), getPublisher(), getYear(),
      getNumPages(), getPrice());
      return dup; 
      
   }
   
   public String toString(){
   //returns all information about attributes of objects
      return "\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() + "\nPublisher: " +
      getPublisher() + "\nYear: " + getYear() + "\nNumber of pages: " + getNumPages() +
      "\nPrice: $" + getPrice() +"\n";
   }  
}