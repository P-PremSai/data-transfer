/*Write a program which creates two threads, one thread displaying BMS College of
Engineering once every ten seconds and another displaying CSE once every two seconds. */
class Dept implements Runnable
{
   Thread mythread ;
   Dept()
   { 
      mythread = new Thread(this, "dept thread");
      mythread.start();
   }
   public void run()
   {
      try
      {
        for (int i=0 ;i<5;i++)
        {
          System.out.println("CSE");
          Thread.sleep(2000);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("CSE interrupted");
     }
     System.out.println("CSE is over" );
   }
}

class threadmain
{
    public static void main(String args[])
    {
       Dept cnt = new Dept();
       try
       {
          for(int i=0;i<5;i++)
          {
            System.out.println("BMS College of Engineering"); 
            Thread.sleep(10000);
          }
       }
       catch(InterruptedException e)
       {
          System.out.println("college interrupted");
       }
       System.out.println(" BMS College of Engineering is over" );
    }
}