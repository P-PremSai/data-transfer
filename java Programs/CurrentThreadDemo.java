class CurrentThreadDemo{
    public static void main (String args[]){
        CurrentThreadDemo t =Thread.CurrentThreadName();
        System.out.println("Current thread: "+t);
        t.setname("My Thread");
        System.out.println("After name change: "+t);
        try{
            for(int n=5;n>0;n--)
            { System.out.println(n); Thread.Sleep(1000);}
        }
        catch (ArithmeticException e)
        { System.out.println("Main thread interrupted");}
    }
}