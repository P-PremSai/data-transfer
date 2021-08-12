/*Develop a Java program to create a class Bank that maintains two kinds of account for its
customers, one called savings account and the other current account. The savings account
provides compound interest and withdrawal facilities but no cheque book facility. The current
account provides cheque book facility but no interest. Current account holders should also
maintain a minimum balance and if the balance falls below this level, a service charge is
imposed. Create a class Account that stores customer name, account number and type of
account. From this derive the classes Curr-acct and Sav-acct to make them more specific to
their requirements. Include the necessary methods in order to achieve the following tasks:
 • Accept deposit from customer and update the balance.
 • Display the balance.
 • Compute and deposit interest
 • Permit withdrawal and update the balance 
 • Check for the minimum balance, impose penalty if necessary and update the balance*/


import java.util.Scanner;
class Bank
{
	String savings,current;
}
class Account extends Bank
{
  double balance=10000;	
  String customer_name;
  long account_number;
  //String type_of_account;
  Scanner input =new Scanner(System.in);
  void get_details()
  {
     System.out.println("Enter the name ");
     customer_name =input.next();
     System.out.println("Enter the account number ");
     account_number =input.nextLong();
   //  System.out.println("Enter the type of account (SA or CA) ");
   //  type_of_account =input.next();
  }	 
}

class Curr_acct extends Account
{
  double deposit_amount=0;
  double minimum_balance=1000;
  double withdrawal_amount=0;
  void deposit()
  {
     System.out.println("Enter the balance to be deposited");
      deposit_amount=input.nextDouble();
     balance +=deposit_amount;
	 System.out.println("Your balance amount is Rs."+balance);
  }	 
 
  void withdrawal()
  {
    System.out.println("Enter the withdrawal amount");
	withdrawal_amount=input.nextDouble();
	if(withdrawal_amount>balance)
	{
		System.out.println("Your balance is less than your withdrawal amount");
	}
	else 
	{
	balance=balance-withdrawal_amount;
	System.out.println("Your balance is :"+balance);
	if(balance<minimum_balance)
	{
	    balance=balance-100;
		System.out.println("You lost Rs.100 due to the insufficient minimum balance");
		System.out.println("Now your balance is :"+balance);
	}
	}
  }
    
}

class Sav_acct extends Account
{
     double deposit_amount=0;
     double years=3;
     double rate_of_interest=5; //rate of interest=5%
	 double withdrawal_amount=0;
  void deposit()
  {
     System.out.println("Enter the balance to be deposited");
     deposit_amount=input.nextDouble();
     balance +=deposit_amount;
	 System.out.println("Your balance is :"+balance);
  }	 
 
  void interest()
  {
	 double interest_amount;
     interest_amount=balance*(Math.pow((1+(rate_of_interest*0.01)),(years))-1);
	 System.out.println("The amount  you gained in interest is:"+interest_amount);
	 balance+=interest_amount;
	 System.out.println("Your total balance is :"+balance);
  }
  void withdrawal()
  {
    System.out.println("Enter the withdrawal amount");
	withdrawal_amount=input.nextDouble();
	if(withdrawal_amount>balance)
	{
		System.out.println("Your balance is less than your withdrawal amount");
	}
	else 
	{
	balance=balance-withdrawal_amount;
	System.out.println("Your balance is :"+balance);
    }
  }
}
class Accountmain
{
   public static void main(String args[])
   {
     Scanner input =new Scanner(System.in);
     Account a=new Account();
	 a.get_details();
	 int type_of_account;
	 System.out.println("Enter the type of account 1.Current account   2.Savings account");
	 type_of_account=input.nextInt();
	 if(type_of_account==1)
	 {
	    Curr_acct b =new Curr_acct();
		int n;
		Loop:for(;;)
		{
		System.out.println("Enter your choice");	
		System.out.println("1.deposit  2.withdraw 3.Done");
		n=input.nextInt();
		switch(n)
		{
		   case 1:{
		     b.deposit();
			 break;
		   }
		   case 2:{
			   b.withdrawal();
			   break;
		   }
		   case 3:
		   {
			   break Loop;
		   }
		}
		}
	 }
	 if(type_of_account==2)
	 {
	    Sav_acct c =new Sav_acct();
		int n;
		Loop:for(;;)
		{	
	    System.out.println("Enter your choice");
		System.out.println("1.deposit  2.withdraw 3.Done");
		n=input.nextInt();
		switch(n)
		{
		   case 1:{
		     c.deposit();
			 break;
		   }
		   case 2:{
			   c.interest();
			   c.withdrawal();
			   break;
		   }
		   case 3:
		   {
			   break Loop;
		   }
		}
		}
	 }
   }
}