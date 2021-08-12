/*Develop a Java Program that implements queue. Accept the user’s interest on a fixed queue
and perform operations accordingly. Loop the program till the user wishes to stop.*/

import java.util.Scanner;

class Queue
{
  int n,q[],item,rear=-1,front=0;
  Scanner input =new Scanner(System.in);
  void no_of_elements()
  {
    System.out.println("Enter the number of elements in the queue");
	n=input.nextInt();
	q =new int[n];
  }
  void insert_rear()
  {  if(rear==n)
     {
	    System.out.println("Queue is overflow");
	 }
	 else
		 {
			 rear++;
             System.out.println("Enter the element to be inserted");
	         item =input.nextInt();
	         q[rear] =item;
	     
	 }
  }
  void delete_front()
  {
     
	 if(front==n)
	 {
	     System.out.println("Queue is empty");
	 }
	 else
	 {
         item =q[front];
	     q[front]--;
		 System.out.println("Element deleted is "+item);
		 front++;
	 }
  }
  void display()
  {
	  if(front==rear)
	  {
		  System.out.println("Queue is empty");
	  }
	  else
	  {
          System.out.println("Elements of the queue are :");
	      for(int i=0;i<n;i++)
	      {
	       System.out.println(q[i]);
	      }
	  }	  
  }
}

class Queuemain
{
     public static void main(String args[])
	 {
	     Scanner input =new Scanner(System.in);
		 Queue a =new Queue();
		 a.no_of_elements();
	     int choice;
		 Loop:for(;;)
		 {
		     System.out.println("1.insert an element    2.delete an element    3.display the elements of the queue    4.Exit");
		     System.out.println("Enter your choice");
		     choice =input.nextInt();
			 switch(choice)
			 {
			      case 1:
				    {
				      a.insert_rear();
					  break;
					}  
				  case 2:
                    {
					  a.delete_front();
					  break;
					} 		
				  case 3:
				    {
					  a.display();
					  break;
					}
				  case 4:
				    {
					  break Loop;
					}
			 }
		 }
		 
	 }
}