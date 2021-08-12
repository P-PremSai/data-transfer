//Write a program to demonstrate generics with multiple object parameters.
class Genrics<T, U,V,X> 
{
   T ob1;
   U ob2;
   V ob3;
   X ob4;

 
    Genrics(T o1, U o2,V o3,X o4)
    {
      ob1 = o1;
      ob2 = o2;
      ob3 =o3;
      ob4 =o4;
    }
 
    void showTypes()
    {
        System.out.println("Type of T is " + ob1.getClass().getName());
        System.out.println("Type of U is " + ob2.getClass().getName());
        System.out.println("Type of V is " + ob3.getClass().getName());
        System.out.println("Type of X is " + ob4.getClass().getName());

    }
    T getob1()
    {
      return ob1;
    }
    U getob2() 
    {
      return ob2;
    }
    V getob3() 
    {
      return ob3;
    }
    X getob4() 
    {
      return ob4;
    }
}

class Genricsmain
{
    public static void main(String args[])
    {
        Genrics<Integer, String,Double,Integer> a =new Genrics<Integer, String,Double,Integer>(100, "GENRICS",120.6544562,14545633);
        a.showTypes();
 
        int t = a.getob1();
        System.out.println("Value: " + t);
        String str = a.getob2();
        System.out.println("Value: " + str);
        double d =a.getob3();
        System.out.println("Value : "+d);
        int c =a.getob4();
        System.out.println("Value : "+c);

    }
}