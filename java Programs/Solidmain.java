/*Write a program which has an abstract class Solid and implements cylinder, cone and
sphere by inheriting from solid to find surface area and volume.*/

import java.util.Scanner;

abstract class Solid
{
   Scanner input =new Scanner(System.in);
   abstract double surface_area();
   abstract double volume();
}

class Cylinder extends Solid
{
     double radius,height;
     void get_details()
	 {
	   System.out.println("Enter the radius of the cylinder");
	   radius =input.nextDouble();
	   System.out.println("Enter the height of the cylinder");
	   height =input.nextDouble();
	 }
	 
	 double surface_area()
	 {
	    System.out.println("Total Surface area of the cylinder is");
		 return (2*3.14*radius*(radius+height));
	    //System.out.println("Curved Surface area of the cylinder is"+(3.14*radius*radius*height));
	 }
	 double volume()
	 {
	    System.out.println("Volume of the cylinder is: ");
		return (3.14*radius*radius*height);
	 }
}

class Sphere extends Solid
{
     double radius;
     void get_details()
	 {
	   System.out.println("Enter the radius of the sphere");
	   radius =input.nextDouble();
	   
	 }
	 
	 double surface_area()
	 {
	   System.out.println("Surface of the Sphere is : ");
	   return (4*3.14*radius*radius);
	 }
	 
	 double volume()
	 {
	    System.out.println("Volume of the Sphere is: ");
		return (4*3.14*radius*radius*radius/3);
	 }
}

class Solidmain
{
   public static void main(String args[])
   {
       
	   
	  Scanner input =new Scanner(System.in);
	  int choice;
	  Loop:for(;;)
	  {
	    System.out.println("1.Cylinder 2.Sphere 3.Exit");
		System.out.println("Enter your choice");
		choice =input.nextInt();
		switch(choice)
		{
		case 1:
		{
		   Cylinder c =new Cylinder();  
		   c.get_details();
		   System.out.println(c.surface_area());
		   System.out.println(c.volume());
		   break;
		}
		case 2:
		{
		   Sphere s=new Sphere();
		   s.get_details();
		   System.out.println(s.surface_area());
		   System.out.println(s.volume());
		   break;
		}
		case 3:
		{
		    break Loop;
		}
		}
	  }
   }
}