/*Develop a Java program to create a class PLAYER with member variables name,
matches_played and average. This class has an abstract method cal_average(String,int,int).
Derive two classes BATSMAN and BOWLER from PLAYER. Class BATSMAN has a
member variable runs_scored. Class BOWLER has a member variable runs_given. Create m
BATSMAN objects and n BOWLER objects. Calculate and display the average runs scored
by each BATSMAN and average runs given by each BOWLER.*/

import java.util.Scanner;

abstract class PLAYER
{
Scanner input =new Scanner(System.in);
  String name;
  int matches_played;
  double average;
  void getdetails1()
  {
    System.out.println("Enter the name");
	name =input.next();
	System.out.println("Enter the number of matches played ");
	matches_played =input.nextInt();
  } 
 abstract void cal_average();
  /*{
	 // name =a;
	 // matches_played =c;
      //average =c/b;
  }*/
}

class BATSMAN extends PLAYER
{
  int runs_scored;
  void getdetails2()
  {
     System.out.println("Enter the number of runs bastman scored");
     runs_scored =input.nextInt();
  }
  void  cal_average()
  {
	  average =runs_scored/matches_played;
  }
  void display1()
  {
    System.out.println("Average runs scored by BATSMAN "+name+" is: "+average);
  }
  
}

class BOWLER extends PLAYER
{
   int runs_given;
   void getdetails3()
   {
     System.out.println("Enter the runs given by the bowler");
	 runs_given =input.nextInt();
   }
   void  cal_average()
   {
	   average =runs_given/matches_played;
   }
   void display2()
   {
     System.out.println("Average runs given by the BOWLER "+name+" are: "+average);
   }
}

class PLAYER_main
{
  public static void main(String args[])
  {
    int m,n;
	Scanner input =new Scanner(System.in);
	System.out.println("Enter the number of BATSMAN's");
	m =input.nextInt();
	BATSMAN a[]= new BATSMAN[m];
	System.out.println("Enter the number of BOWLER's");
	n =input.nextInt();
	BOWLER b[] =new BOWLER[n];
	for(int i=0;i<m;i++)
	{
	  System.out.println("Enter the details of BATSMAN "+(i+1));
	  a[i] =new BATSMAN();
	  a[i].getdetails1();
	  a[i].getdetails2();
	  a[i].cal_average();
	}
	System.out.println("************************");
	for(int i=0;i<n;i++)
	{
	  System.out.println("Enter the details of BOWLER "+(i+1));	
	  b[i] =new BOWLER();
	  b[i].getdetails1();
	  b[i].getdetails3();
	  b[i].cal_average();
	}
	System.out.println("*************************");
	for(int i=0;i<m;i++)
	{
	  a[i].display1();
	}
	System.out.println("*************************");
	for(int i=0;i<n;i++)
	{
	  b[i].display2();
	}
  }
}