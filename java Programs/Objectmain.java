class Object
{
  static int x;
  String name,id;
  
  Object(String oname,String oid)
  {
     name =oname;
	 id =oid;
	 x++;
  }
  /*int returnx()
  {
     return x;
  }*/
}

class Objectmain
{
  public static void main(String args[])
  {
     Object o1 =new Object("Ram","123");
	  Object o2 =new Object("sam","456");
	  System.out.println("Number of objects : "+Object.x);
  }
}