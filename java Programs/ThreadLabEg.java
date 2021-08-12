/*Create two class Java_Question and Java_Answer. Make them threads. The two threads tries to access an object of Internals class 'Internals' involves
question() and answer() methods .Java_Question should first ask question as 'What is Java' by calling question() method and Java_Answer should 
then  print answer as 'It is a OO langague' by calling answer() method .Write the required code.*/

class Internals
{
    public void question(String s)
    {
        System.out.print("Question : ");
        System.out.println(s+"?");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }

    public void answer(String s1)
    {
        System.out.print("Answer : ");
        System.out.println(s1);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie)
        {
            System.out.println("Interrupted");
        }
    }
}

class Java_Question implements Runnable
{
    String msg;
    Thread t;
    Internals in;

    Java_Question(Internals inter,String s)
    {
        in =inter;
        msg =s;
        t=new Thread(this);
        t.start();
    }

    public void run()
    {
        in.question(msg);
    }
}

class Java_Answer implements Runnable 
{
    String msg1;
    Internals in1;
    Thread t2;

    Java_Answer(Internals inter1,String s1)
    {
        in1 =inter1;
        msg1 =s1;
        t2 =new Thread(this);
        t2.start();
    }

    public void run()
    {
        in1.answer(msg1);
    }
}

class ThreadLabEg
{
    public static void main(String args[])
    {
        Internals i =new Internals();
        try
        {
            Java_Question jq =new Java_Question(i,"What is Java") ;
            Thread.sleep(2000);
            Java_Answer ja =new Java_Answer(i,"It is a OO langague.");

            try
            {
               jq.t.join();
               ja.t2.join();
            }
            catch(InterruptedException ae)
            {
              System.out.println("Interrupted");
            }
        }
        catch(InterruptedException de)
        {
            System.out.println("Interrupted");
        }   
   }
}