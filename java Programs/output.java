/*Write a Java program to get the output given below.
5 5 5 5
4 4 4
3 3
2*/

class output
{
  public static void main(String args[])
  {
     int a[][]=new int[4][];
	 int k=5;
	 a[0]=new int[4];
	 a[1] =new int[3];
	 a[2] =new int[2];
	 a[3] =new int[1];
	 for(int i=0;i<4;i++)
	 {
	   for(int j=0;j<4-i;j++)
	   {
	     a[i][j] =k;
	   }
	   k--;
	 }
	 for(int i=0;i<4;i++)
	 {
	   for(int j=0;j<4-i;j++)
	   {
	     System.out.print(a[i][j]+" ");
	   }
	   System.out.println();
	 }
  }
}