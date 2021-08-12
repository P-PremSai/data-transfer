import java.util.Scanner;
class Book{
   private String bookid,booktitle,author,publisher;
   private int no_of_pages,year_of_pub;
   private double price;
   
void getbookdetails(){
   Scanner input =new Scanner(System.in);
   System.out.println("Enter the book ID,book title,author,publisher");
   bookid =input.next();
   booktitle =input.next();
   author =input.next();
   publisher =input.next();
   System.out.println("Enter the no.of pages of the book and year of publish");
   no_of_pages =input.nextInt();
   year_of_pub =input.nextInt();
   System.out.println("Enter the price of book");
   price =input.nextDouble();
   
}   

void displaybookdetails(){
    System.out.println("Book ID : "+bookid);
	System.out.println(" Book Title : "+booktitle);
	System.out.println("Author :  "+author);
    System.out.println("Publisher  :"+publisher);
    System.out.println("Number of pages : "+no_of_pages);
	System.out.println(" Year of published : "+year_of_pub);
    System.out.println("Price is : "+price);
}
double reprice()
{
	return price;
}
String reauthor()
{
	return author;
}
int re_year_of_pub()
{
	return year_of_pub;
}
int re_no_of_pages()
{
	return no_of_pages;
}
}
class Bookmain2
{
	public static void main(String args[])
	{ 
	    int n,j=0,k=0,l=0;
		double maxprice=0.0;
		int minpages=0;
		String author;
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the number of books ");
		n =input.nextInt();
		Book s[] =new Book[n];
		for(int i=0;i<n;i++)
		{
			s[i] =new Book();
			s[i].getbookdetails();
		}
		for(int i=0;i<n;i++)
		{
			s[i].displaybookdetails();
		}
		System.out.println("");
		System.out.println("Enter the author name :");
		author =input.next();
		for(int i=0;i<n;i++)
		{
		   if(author==s[i].reauthor())
		   {
			   System.out.println("Book details of author "+author+" are ");
		       s[i].displaybookdetails();
		   }
		}
			  
		System.out.println("");
		maxprice =s[0].reprice();
		for(int i=0;i<n;i++)
		{
		    if(maxprice<s[i].reprice())
			{
				maxprice =s[i].reprice();
				j=i;
			}
		}	
		System.out.println("Maximum book price is : "+maxprice);
		System.out.println("Book details are : ");
		s[j].displaybookdetails();
		System.out.println("");
		for(int i=0;i<n;i++)
		{
			if(s[i].re_year_of_pub()==2000)
			{
				k=k+1;
			}	
		}
		System.out.println("Number of books published in 2000 are : "+k);
		System.out.println("");
	    minpages =s[0].re_no_of_pages();
		for(int i=0;i<n;i++)
		{
			if(minpages>s[i].re_no_of_pages())
			{
				minpages = s[i].re_no_of_pages();
				l =i;
			}
		}
		System.out.println("Minimum number of pages are : " +minpages);
		System.out.println("Book details are : ");
		s[l].displaybookdetails();
	}
}