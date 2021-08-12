import java.util.Scanner;

class Book
{
   private String name,author;
   private double price;
   private int num_pages;
   Scanner input =new Scanner(System.in);
   
   Book()
   {
      name ="Harry Potter";
	  author ="J.K.Rowling";
	  price =265.05;
	  num_pages =223;
   }
   
   public String toString()
   {
	   return("NAME OF THE BOOK IS : "+name+ "\nAUTHOR OF THE BOOK IS : "+author+ "  \nPRICE OF THE BOOK IS : "+price+ "  \nNUMBER OF PAGES OF THE BOOK ARE : "+num_pages);
   }
   
   
   void getdetails()
   {
      System.out.println("Enter the name of the book");
	  name =input.next();
	  System.out.println("Enter the author name");
	  author =input.next();
	  System.out.println("Enter the price of the book");
	  price =input.nextDouble();
	  System.out.println("Enter the number of pages of the book");
	  num_pages =input.nextInt();
	  System.out.println(" ");
   }
   
  /* void displaydetails()
   {
      System.out.println("NAME OF THE BOOK IS : "+name);
	  System.out.println("AUTHOR OF THE BOOK IS : "+author);
	  System.out.println("PRICE OF THE BOOK IS : "+price);
	  System.out.println("NUMBER OF PAGES OF THE BOOK ARE : "+num_pages);
	  System.out.println(" ");
   }*/
}

class Bookmain
{
    public static void main(String args[])
	{
	   int n;
	   Scanner input =new Scanner(System.in);
	   Book b1 =new Book();
	     System.out.println(b1);
	   System.out.println("Enter the number of books");
	   n =input.nextInt();
	   Book s[] =new Book[n];
	   for(int i=0;i<n;i++)
	   {
	      s[i] =new Book();
		  System.out.println("Enter the details of book "+(i+1));
		  s[i].getdetails();
	   }
	   for(int i=0;i<n;i++)
	   {
		  System.out.println("Details of book "+(i+1)+" are");
	      //s[i].displaydetails();
		  System.out.println(s[i]);
	   }
	}
}