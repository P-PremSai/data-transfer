class Calculater 
{
int add (int a,int b)
{return a+b;}
int sub(int a,int b)
{
	return a-b;
}
}

public class AdvancedCalculater extends Calculater{
   int mult(int a,int b)
   {
	   return a*b;
   }
   int div(int a,int b)
   { return a/b;}
   public static void main(String args[])
   {
     AdvancedCalculater cal =new AdvancedCalculater();
	 System.out.println(cal.add(1,2));
	 System.out.println(cal.sub(1,2));
	 System.out.println(cal.mult(1,2));
	 System.out.println(cal.div(1,2));
   }
}