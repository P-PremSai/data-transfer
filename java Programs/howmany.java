/*Design a Java program to accept a double array- Full. create two more arrays pos,
neg. Check every element of Full array and push the positive
numbers to pos array and negative numbers to neg. Count the number of
positives, negatives and zeros and display.*/

import java.util.Scanner;
class howmany
{
   public static void main(String args[])
   {
      int array[],pos[],neg[],n,i,j=0,posn=0,negn=0,zero=0;
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter the number of elements in an array");
	  n =input.nextInt();
	  array = new int[n];
	  pos =new int[n];
	  neg =new int[n];
	  System.out.println("Enter the elements of array");
	  for(i=0;i<n;i++)
	  {
	     array[i]=input.nextInt();
	  }
	  for(i=0;i<n;i++)
	  {
	     if(array[i]>0)
		 {
			pos[j] =array[i]; 
		    posn =posn+1;
			j=j+1;
		 }
		 else if(array[i]==0)
		 {
		   zero =zero+1;
		 }
		 else 
		 {
			 neg[j]=array[i];
		     negn =negn+1;
			 j=j+1;
		 }
	  }
	  
	  pos =new int[posn];
	  neg =new int[negn];
	  for(i=0;i<n;i++)
	  {
	     if(array[i]>0)
		 {
			pos[j] =array[i]; 
			j=j+1;
		 }
		 else if(array[i]==0)
		 {
		   zero =zero+1;
		 }
		 else 
		 {
			 neg[j]=array[i];
			 j=j+1;
		 }
	  }
	  
	  
	  System.out.println("There is/are "+posn+" postive numbers");
	  System.out.println("There is/are "+zero+" zero's");
	  System.out.println("There is/are "+negn+" negative numbers");
	}
}	