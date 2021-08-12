import java.util.Scanner;

class Distance 
{
   int feet,inches;
   Scanner input =new Scanner(System.in);
 
 void setvalues(int feet,int inches)
 {
	 this.feet =feet;
	 this.inches =inches;
 }
 void getdetails()
{
  System.out.println("enter the distance in feet");
  feet =input.nextInt();
   System.out.println("enter the distance in inches");
  inches =input.nextInt();
} 
Distance add(Distance a)
{
   Distance temp =new Distance();
   temp.feet=feet +a.feet;
   temp.inches =inches+a.inches;
  
    return temp;   
}
void displaydetails()
{    
    System.out.println("feet"+feet+ " inches"+inches);
    if(inches>=12)
   {
	    feet =feet+(inches/12);
      inches =inches%12;
	 
   }
   else 
   {
	   inches =inches;
   }	
  System.out.println(feet+" feets "+inches+" inches");
}
}
 
 class Distancemain
 {
   public static void main(String args[])
   {
       int n,sum;
	   Scanner input =new Scanner(System.in);
	   System.out.println("Enter the number of distances you have ");
	   n =input.nextInt();
	   Distance d = new Distance();
	   d.setvalues(0,0);
	    Distance s[] =new Distance[n];
	   for(int i=0;i<n;i++)
	   {
	      s[i] =new Distance();
	      s[i].getdetails();
	   }
	   
	   for(int i=0;i<n;i++)
	   {
	   d =d.add(s[i]);
	   }
	  d.displaydetails();
    }
 }