import java.util.Scanner;

class result1 implements Runnable
{
    Thread t1;
    int a,b,c,r,res2;
    result1(int a,int b,int c)
    {
        this.a =a;
        this.b =b;
        this.c =c;
        t1 =new Thread(this,"Thread1");
        t1.start();
    }
    public void run()
    {
        try
        {
            r=a*b;
            System.out.println("a*b is :"+r);
            result2 y =new result2(c,r);
            Thread.sleep(3000);
             res2 =y.return_res();
             
            
            
        }
        catch(Exception e)
        {
            System.out.println("Error in a*b");
        }

    }
   
    int return_res2()
    {
        return res2;
    }
}
class result2 implements Runnable
{
    Thread t2;
    int c,r;
    public int res;
    result2(int c,int r)
    {
        this.c =c;
        this.r =r;
        t2 =new Thread(this,"Thread2");
        t2.start();
    }
    public void run()
    {
             try
            {
                res =r+c;
                System.out.println("Result is :"+res);
                
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println("Error in r+c");
            }
    }
    int return_res()
    {
        return res;
    }
}
class threadresult
{
    public static void main(String args[])
    {
        int a,b,c;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the value of a");
        a=input.nextInt();
        System.out.println("Enter the value of b");
        b =input.nextInt();
        System.out.println("Enter the value of c");
        c =input.nextInt();
        result1 x =new result1(a,b,c);
        try
        {
            Thread.sleep(5000);
            System.out.println("Result of a*b+c is :"+(x.return_res2()));
        }
        catch(Exception e)
        {
            System.out.println("Error in main result");
        }
    }
}