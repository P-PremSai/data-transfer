/*Develop a Java program which has the (only) class CircleDemo that has members-
radius, area and perimeter. Include methods to do the following.

a. accept the radius from the user
b. find the area of the circle
c. find the perimeter of the circle
d. Display all the details*/

import java.util.Scanner;

class CircleDemo
{
  double radius,area,perimeter;
  Scanner input =new Scanner(System.in);
  void calradius()
  {
	  System.out.println("Enter the radius of the circle");
      radius =input.nextDouble();
  }
  
  /*double calarea(double a)
  {
     area =3.14*a*a;
	 return area;
  }
  double calperimeter(double a)
  {
      perimeter =2*3.14*a;
	  return perimeter;
  }*/
     public static void main(String args[])
	 {
	    
	     area =3.14*radius*radius;
		  perimeter =2*3.14*radius;
		System.out.println("Radius of the circle :"+radius+"\nArea of the circle :"+area+"\nPerimeter of the circle :"+perimeter);
	 }
  
}