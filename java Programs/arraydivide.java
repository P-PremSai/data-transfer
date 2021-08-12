import java.util.Scanner;
class arraydivide
{
  public static void main(String args[])
  {
    int n,i,j=0,k=0,sum=0,x,y,min=0,max=0;
	float avg;
    int a[],b[],c[],d[];
	int even,odd;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the number of elements in an array");
	n = input.nextInt();
	a = new int[n];
	b = new int[n];
	c = new int[n];
	System.out.println("Enter the " +n+ " elements");
	for(i=0;i<n;i++)
	{
	   a[i] =input.nextInt();
	}
	for(i=0;i<n;i++)
	{
	   if(a[i]%2==0)
	   {
	     b[j] = a[i];
		 j=j+1;
	   }
	   else 
	   {
		c[k] = a[i];  
		k =k+1;
	   }
	}
	x =j;
	y =k;
	System.out.println("Even array elements are :");
	for(j=0;j<x;j++)
	{
	       System.out.println(+b[j]); 
	}	
	System.out.println("Odd array elements are :");
	for(k=0;k<y;k++)
	{
	       	       System.out.println(+c[k]);  
	}
	for(k=0;k<y;k++)
	{
		sum =sum +c[k];
		min = c[0];
		max =c[0];
		if(min>c[k])
		{
			min =c[k];
		}
		if(max<c[k])
		{
			max =c[k];
		}
	}
	System.out.println("Sum of odd elements is: "+sum);
	System.out.println("Minimum in odd elements is: "+min);
	System.out.println("Maximum of odd elements is: "+max);
	avg =(float)sum/y;
	System.out.println("Average of odd elements is: "+avg);
  }
}