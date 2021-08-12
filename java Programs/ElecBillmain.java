/*Create a class ElecBill with members custname,custid,custaddress, 
custnounits and custbillamt. Include a static member cust_highestbillamt 
which holds the id of the customer who has paid the highest billamount.
Create n Elecbills.
Include methods for the following:
1. Accept the details
2. Display the details of all bills in a tabular format
3. Calculate the bill amount based on the following slabs.
	For the first 100 units -Rs.2 /unit
	For the next 150 units - Rs.3 /unit
	For the remaining un
nits -Rs.5 / unit*/
import java.util.Scanner;

class ElecBill
{
  String custname;
  String custid;
  String custaddress;
  double custnounits;
  double custbillamt;
  double custbillamt1;
  static double cust_highestbillamt;
  Scanner input =new Scanner(System.in);
  
  void accept()
  {
     System.out.println("Enter the customer name,id,address,number of units\n ");
	 custname =input.next();
	 custid =input.next();
	 custaddress =input.next();
	 custnounits =input.nextDouble();
  }
  
  void calculate()
  {
     if(custnounits<=100)
	 {
	    custbillamt =(custnounits*2);
	 }
	 else if(custnounits<=350)
	 {
	    custbillamt =((100*2)+((custnounits-100)*3));
	 }
	 else 
	 {
	    custbillamt =((100*2)+(150*3)+((custnounits-350)*5));
	 }
  }
  
  void display()
  {
     System.out.println("Name :"+custname+"\nID :"+custid+"\nAddress :"+custaddress+"\nNumber of units :"+custnounits+"\nTotal amount is :"+custbillamt);
  }
  
 double recustbillamt()
  {
    return custbillamt;
  }
  
  static void highest(double a)
  {
    cust_highestbillamt = a;
	System.out.println("Highest bill is :"+cust_highestbillamt);
  }
}


class ElecBillmain
{
  public static void main(String args[])
  {
    int n;
	double max=0;
	Scanner input =new Scanner(System.in);
	System.out.println("Enter the number of customers");
	n =input.nextInt();
	ElecBill s[]=new ElecBill[n];
	for(int i=0;i<n;i++)
	{
	  s[i] =new ElecBill();
	  System.out.println("Enter the details of customer "+(i+1));
	  s[i].accept();
	  System.out.println();
	}
	for(int i=0;i<n;i++)
	{
		s[i].calculate();
	}
	for(int i=0;i<n;i++)
	{
	  System.out.println("Details of customer "+(i+1)+" are:\n");	
	  s[i].display();
	  System.out.println();
	}
	max =s[0].recustbillamt();
	for(int i=0;i<n;i++)
	{
	  if(s[i].recustbillamt()>max)
	  {
	     max =s[i].recustbillamt();
	  }
	}
	ElecBill.highest(max);
  }
}