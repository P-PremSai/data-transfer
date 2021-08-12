import java.util.Scanner;
class amount
{
   public static void main(String args[])
   {
       int i,j,k,x,r=1;
      double a[][];
	  int b[][];
	  double m=0,n;
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter the number of items");
	  x =input.nextInt();
	  a = new double[r][x];
	  b =new int[x][r];
	  System.out.println("Enter the rate of "+x+"items");
	  for(i=0;i<=0;i++)
	  {
	  for(j=0;j<x;j++)
	  {
	    a[i][j] =input.nextInt();
	  }
	  }
	  System.out.println("Enter the quantity of "+x+" items in the same order");
	  for(i=0;i<x;i++)
	  {
	    for(j=0;j<1;j++) 
		{
		   b[i][j] = input.nextInt();
		}
	  }
	  for(i=0;i<1;i++)
	  {
	     for(j=0;j<1;j++)
		 {	 
		   for(k=0;k<x;k++)
		   {
		      m+=a[i][k]*b[k][j];
		   }
		 }
	  }
	  for(i=0;i<1;i++)
	  {
		  for(j=0;j<1;j++)
		  {
			  System.out.println("Total amount is "+m);
		  }
	  }
	  if(m>=10000)
	  {
		  n =m-((5*m)/100);
		  System.out.println("Final bill is : "+n);
		  System.out.println("Your discount is 5%");
	  }
	  else if(m>=7500 && m<10000)
	  {
		  n =m-((3*m)/100);
		  System.out.println("Final bill is : "+n);
		   System.out.println("Your discount is 3%");
	  }
	  else if(m>=5000)
	  {
		  n =m-((2*m)/100);
		  System.out.println("Final bill is : "+n);
		   System.out.println("Your discount is 2%");
	  }
	  else
	  {
		  System.out.println("No discount");
		  System.out.println("Total amount = Final amount (no discount) ="+m);
	  }
   }
}