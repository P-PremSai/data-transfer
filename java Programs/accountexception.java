/*Write a Java program to create an account class. Define appropriate constructor for this
class. Implement a separate methods to display account balance and withdraw money.
Raise a user defined exception if there is an attempt to withdraw money which is greater
than the account balance. Make necessary assumptions required. */

import java.util.Scanner;

class exceed extends Exception
{
    double withdraw2,balance2;
    exceed(double withdraw1,double balance1)
    {
        balance2 =balance1;
        withdraw2 =withdraw1;
    }
    public String toString()
    {
        return "Your withdraw amount is greater than your balance";
    }
}
class bank 
{
    double withdraw1,balance1;
    bank(double balance,double withdraw)
    {
        withdraw1 =withdraw;
        balance1 =balance;
    }
    void balance_check() throws exceed
    {
        if(withdraw1>balance1)
        {
            throw new exceed(withdraw1,balance1);
        }
        else 
        {
            balance1=balance1-withdraw1;
            System.out.println("Your remaining balance is :"+balance1);
        }
    }
    void balance_in_account()
    {
        System.out.println("Balance in your account is :"+balance1);
    }
    void withdraw_amount()
    {
        System.out.println("Your withdraw amount is :"+withdraw1);
    }
}
class accountexception
{
    public static void main(String args[])
    {
         double balance=10000,withdraw;
         Scanner input =new Scanner(System.in);
         try
         {
            System.out.println("Enter the withdraw amount");
            withdraw =input.nextDouble();
            bank b =new bank(balance,withdraw);
            try
            {
                b.balance_in_account();
                b.withdraw_amount();
                b.balance_check();
            }
            catch(exceed e)
            {
                System.out.println(e);
            }
         }
         catch(Exception e)
         {
             System.out.println("Please enter the amount in numbers");
         }
         
    }
}