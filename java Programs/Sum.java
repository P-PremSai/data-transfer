class Sum{
 int a,b,c;
 Sum(){a=b=c=5;}
 public int sum()
 {return (a+b+c); }
 public int sum(int x,int y)
 {  return (x+y);}
  public int sum(int x,int y,int z)
 {  return (x+y+z);}
 public double sum(double x,double y)
 { return (x+y);}
 public static void main(String args[])
 {
  Sum s =new Sum();
  System.out.println(s.sum());
  System.out.println(s.sum(10,20));
  System.out.println(s.sum(10,20,30));
  System.out.println(s.sum(10.5,20.5));
  //System.out.println(s.sum(10.5,20.5,30.4,10.1));
 }
}