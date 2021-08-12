/*Develop a Java program to create an abstract class named Shape that contains two integers and
an empty method named printArea( ). Provide three classes named Rectangle, Triangle and
Circle such that each one of the classes extends the class Shape. Each one of the classes contain
only the method printArea( ) that prints the area of the given shape.*/

abstract class Shape
{
  double num1,num2;
  
  abstract double printArea();
}
class Rectangle extends Shape
{
   Rectangle(double a,double b)
   {
     num1 =a;
	 num2 =b;
   }
   double printArea()
   {
      System.out.println("Area of the rectangle is :");
	  return num1*num2;
   }
}
class Triangle extends Shape
{
   Triangle(double a,double b)
   {
     num1 =a;
	 num2 =b;
   }
   double printArea()
   {
      System.out.println("Area of the triangle is :");
	  return num1*num2/2;
   }
}
class Circle extends Shape
{
   Circle(double a)
   {
     num1 =a;
   }
   double printArea()
   {
      System.out.println("Area of the circle is :");
	  return 3.14*num1*num1;
   }
}

class Shapemain
{
   public static void main(String args[])
   {
     Rectangle r=new Rectangle(10,10);
	 Triangle t=new Triangle(10,5);
	 Circle c=new Circle(5);
	 System.out.println(r.printArea());
	 System.out.println(t.printArea());
	 System.out.println(c.printArea());
   }
}