 package CIE;
 
 
 public class Internals extends Student
 {
     public int internal_marks[] =new int[5];
	 
	 public void getdetails()
	 {
	     System.out.println("Enter the internal marks of the student out of 50");
         for(int i=0;i<5;i++)
		 {
			  System.out.println(" in Subject "+(i+1));
		     internal_marks[i] =input.nextInt();
		 }
	 }
 }