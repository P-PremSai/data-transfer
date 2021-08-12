/*Develop a Java program to accept the values of a double array through command line.
Display the sorted array.*/

import java.util.Scanner;

class cmdlinearray
{
   public static void main(String sss[])
   {
      double array[];
	  array =new double[sss.length];
	  for(int i=0;i<sss.length;i++)
	  {
	     array[i] =Double.parseDouble(sss[i]);
	  }
	   System.out.print("Elements of array are :");
	  for(int i=0;i<sss.length;i++)
	  {
	      System.out.print(array[i]);
		  System.out.print(" ");
	  }
	  
   }
}