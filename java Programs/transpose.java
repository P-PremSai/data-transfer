/*Develop a Java program to find the transpose of a given matrix of order MXN.*/
import java.util.Scanner;
class transpose
{
   public static void main(String args[])
   {
     int a[][];
	 int ta[][];
	 int m,n,temp;
	 Scanner input =new Scanner(System.in);
	 System.out.println("Enter the number of rows and columns");
	 m =input.nextInt();
	 n =input.nextInt();
	 a =new int[m][n];
	 ta =new int[n][m];
	 for(int i=0;i<m;i++)
	 {
	   System.out.println("Enter the elements of row "+(i+1)); 
	   for(int j=0;j<n;j++)
	   {
	     a[i][j]=input.nextInt();
	   }
	 }
	 System.out.println();
	 for(int i=0;i<m;i++)
	 {
	   for(int j=0;j<n;j++)
	   {
	     ta[j][i] =a[i][j];
	   }
	 }
	 for(int i=0;i<n;i++)
	 {
	   for(int j=0;j<m;j++)
	   {
	     System.out.print(ta[i][j]);
		 if(j==m-1)
			 System.out.println();
		 else 
			 System.out.print("  ");
	   }
	 }
   }
}