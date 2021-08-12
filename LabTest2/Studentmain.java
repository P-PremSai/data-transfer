/*Create a class Student which includes instance variables usn, name and marks of three subjects. Accept the input for two
students through command line arguments. Raise an user defined exception ‘noargs’ if no arguments are given in command
line. Also raise an exception when negative mark is given for any of the subject. */
class Noargs extends Exception
{
    int count;
    Noargs(int count)
    {
        this.count =count;
    }
    public String toString()
    {
        return "You didn't entered anything in command line argument ";
    }
}

class Negative extends Exception
{
    int s;
    Negative(int i)
    {
        s=i;
    }
    public String toString()
    {
        return "Negative mark  not allowed \nYou entered negative mark in subject "+s;
    }
}
class Student
{
    String name,usn;
    int marks1,marks2,marks3;
    int count;
    Student(String array[],int array3[],int count)
    {
        name =array[0];
        usn =array[1];
        marks1 =array3[0];  
        marks2 =array3[1];
        marks3 =array3[2];
        this.count =count;
    }
    void check_args() throws Noargs
    {
        if(count==0)
        {
            throw new Noargs(count);
        }
    }

    void check_marks() throws Negative
    {
        
        if(marks1<0)
        {
            int i=1;
            throw new Negative(i);
        }
        else if(marks2<0)
        {
            int i=2;
            throw new Negative(i);   
        }
        else if(marks3<0)
        {
            int i=3;
            throw new Negative(i);
        }
    }

    void display()
    {
        System.out.println();
        System.out.println("USN :"+usn+"\nName : "+name+"\nMarks in sub1 : "+marks1+"\nMarks in sub2 : "+marks2+"\nMarks in sub3 : "+marks3);
        System.out.println();
    }

}
class Studentmain
{
    public static void main(String args[])
    {
        String array[] =new String[2];
        int array3[] =new int[3];
        int count;
        count = args.length;
        
        if(count<10)
        {
            System.out.println("");
            System.out.println("You didn't entered all the details ");
            System.out.println("");
        }
        if(count>10)
        {
            System.out.println("");
            System.out.println("You  entered more details ");   
            System.out.println("");
        }
        if(count==5)
        {
            System.out.println("");
            System.out.println("You  entered details of only one student ");   
            System.out.println("");
        }
        for(int i=0;i<2;i++)
        {
            try 
            {
                array[i] =args[i];
            }
            catch(ArrayIndexOutOfBoundsException ae)
            {

            }
        }
        for(int i=0;i<3;i++)
        {
            
                try 
                {
                    array3[i] =Integer.parseInt(args[i+2]);
                }
                catch(Exception eb)
                {
                    if(count==0)
                    {

                    }
                    else
                    {
                        System.out.println("Enter the marks in numbers of student 1 in sub "+(i+1));
                    }
                    
                }
        }
        Student s =new Student(array,array3,count);
      
        String array2[] =new String[2];
        int array4[] =new int[3];
        for(int i=0;i<2;i++)
        {
            try 
            {
                array2[i] =args[i+5];
            }
            catch(ArrayIndexOutOfBoundsException ae)
            {

            }
        }

        for(int i=0;i<3;i++)
        {
            try 
                {
                    array4[i] = Integer.parseInt(args[i+7]);
                }
                catch(Exception eb)
                {
                    if(count==0)
                    {

                    }
                    else
                    {
                        System.out.println("Enter the marks in numbers of student 2 in subject "+(i+1));
                    }
                    
                }
            
        }
         
        Student t =new Student(array2,array4,count);
       try
        {
            s.check_args();
            t.check_args();
        }
        catch(Noargs xe)
        {
            System.out.println(xe);
        }
        try
        {
            s.check_marks();
            t.check_marks();
            if(count!=0)
            {
                System.out.println("Details of Student 1 :");
                s.display();
                System.out.println("Details of Student 2 :");
                t.display();
            }
        }
        catch(Negative ce)
        {
            System.out.println(ce);
        }
        
    }
}