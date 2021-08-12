class marks
{
  public static void main(String sss[])
  {
     String name;
	 int sem;
	 int cie,see;
	 
	 name =sss[0];
	 sem =Integer.parseInt(sss[1]);
	 cie =Integer.parseInt(sss[2]);
	 see =Integer.parseInt(sss[3]);
	 
	 System.out.println("Total marks are :"+(cie+see));
  }
}