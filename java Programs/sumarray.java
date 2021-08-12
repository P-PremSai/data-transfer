import java.util.Scanner;
class sumarray
{
   public static void main(String args[])
   {
      int array[],n,i,even=0,odd=0;
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter the number of elements in an array");
	  n =input.nextInt();
	  array = new int[n];
	  System.out.println("Enter the elements of array");
	  for(i=0;i<n;i++)
	  {
	     array[i]=input.nextInt();
	  }
	  for (i=0;i<n;i++)
	  {
		 System.out.println("Element in " +i+ "is"+array[i]);
	  }  
	  
	  for(i=0;i<n;i+=2)
	  {
		  even =even+array[i];
	  }
	  
	  System.out.println("sum of even indices is: "+even);
	  for(i=1;i<n;i+=2)
	  {
		  odd=odd+array[i];
	  }
	  System.out.println("sum of odd indices is: "+odd);  
   }
}