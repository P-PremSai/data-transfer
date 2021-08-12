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
	  author ="Sai";
	  price =300.0;
	  num_pages =200;
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
   }
   void displaydetails()
   {
      System.out.println("NAME OF THE BOOK IS : "+name);
	  System.out.println("AUTHOR OF THE BOOK IS : "+author);
	  System.out.println("PRICE OF THE BOOK IS : "+price);
	  System.out.println("NUMBER OF PAGES IN THE BOOK ARE : "+name);
   }
}

class Bookmain
{
    public static void main(String args[])
	{
	   int n;
	   Scanner input =new Scanner(System.in);
	   Book b1 =new Book();
	   System.out.println("Enterr the number of books");
	   n =input.nextInt();
	   Book s[] =new Book[n];
	   for(int i=0;i<n;i++)
	   {
	      s[i] =new Book();
		  s[i].getdetails();
	   }
	   for(int i=0;i<n;i++)
	   {
	      s[i].displaydetails();
	   }
	   
	   
	   
	}
}