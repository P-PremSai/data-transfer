/*Develop a Java program to create a class Actor with id, name, no_of_movies,
no_of_years_exp. Calculate the average_performance for each of the actor and print
the name of the actor with highest average.*/

import java.util.Scanner;

class Actor
{
  String id,name;
  int no_of_movies,no_of_years_exp;
  double average_performance;
  Scanner input =new Scanner(System.in);
  
  void getdetails()
  {
    System.out.println("Enter the id of the actor");
	id =input.next();
	System.out.println("Enter the name of the actor");
	name =input.next();
	System.out.println("Enter the number of movies that actor did");
	no_of_movies =input.nextInt();
	System.out.println("Enter the number of years of experience of the actor");
	no_of_years_exp =input.nextInt();
  }
  void calculate_average()
  {
    average_performance =no_of_movies/no_of_years_exp;
  }
  double reaverage()
  {
    return average_performance;
  }
}

class Actormain
{
  public static void main(String args[])
  {
     int n,j=0;
	 double highest;
	 
     Scanner input =new Scanner(System.in);
	 System.out.println("Enter the number of actors");
	 n =input.nextInt();
	 Actor s[]=new Actor[n];
	 for(int i=0;i<n;i++)
	 {
	    s[i] = new Actor();
		s[i].getdetails();
		s[i].calculate_average();
	 }
	 highest =s[0].reaverage();
	 for(int i=0;i<n;i++)
	 {
	   if(s[i].reaverage()>highest)
	   {
	     highest =s[i].reaverage();
		 j=i;
	   }
	 }
	 System.out.println("Name of the actor with highest average is :"+s[j].name);
	 
  }
}