class q2a{
  public static void printarray(double a[]){
     for(int i=0;i<a.length;i++)
	   System.out.println(a[i]);
  }
  public static void main(String args[]){
     double x[] ={2.2,4.4};
	 double y[] ={1.1,3.3,5.5};
	 y=x;
	 x[0]=8.8;
	 printarray(x);
	 printarray(y);
   }
}