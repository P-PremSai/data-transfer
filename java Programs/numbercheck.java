import java.util.Scanner;
class numbercheck
{
    public static void main(String args[])
    {
        long num;
        Scanner input =new Scanner(System.in);
        
        try
        {
            System.out.println("Enter the number");
            num =input.nextLong();
        
        try
        {
            int count =0;
            while(num!=0)
            {
                num/=10;
                count++;
            }
            if(count!=10)
            {
                System.out.println("10 numbers are not there in the number");
            }
            if(count==10)
            {
                System.out.println("Number contain all numbers and it has 10 digits");
            }
        }
        catch(Exception e) 
        {
            System.out.println("Number does not contain 10 numbers");
        }
        }
        catch(Exception e)
        {
            
            System.out.println("Number does not contain all numbers");
        }
        
    }
}