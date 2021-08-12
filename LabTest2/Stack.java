/*Write a program to design a StackUnderflowException and a StackOverflowException. Handle the exception when user tries
 to pop elements from an empty stack and pushes elements into a filled stack. */
import java.util.Scanner;

class StackOverflow extends Exception
{
    int top ;
    StackOverflow(int top)
    {
        this.top =top;
    }

    public String toString()
    {
        return "Stack is Full";
    }
}

class StackUnderflow extends Exception
{
    int top;
    StackUnderflow(int top)
    {
        this.top =top;
    }

    public String toString()
    {
        return "Stack is Empty";
    }
}
 /*interface poppush
 {
     void push();
     void pop();
 }*/

 class Stack 
 {
     int stack[] =new int[5];
     int top =-1;
     int item;
     void push(int item) throws StackOverflow
     {
         try
         {
             this.item =item;
            top++;
            stack[top]=item;
         }  
         catch(ArrayIndexOutOfBoundsException ad)
         {
             throw  new StackOverflow(top);
         }  
     }

     int pop() throws StackUnderflow
     {
         try
         {
             item=stack[top] ;
             stack[top]=0;
             System.out.println("Top : "+top);
             top=top-1;
             return item ;
         }
         catch(ArrayIndexOutOfBoundsException as)   
         {
             throw new StackUnderflow(top);
         }
         
     }

     void display()
     {
         if(top==-1)
         {
             System.out.println("Stack is empty");
         }
         else
         {
             System.out.println("Elements of the stack are : ");
             for(int i=0;i<5;i++)
             {
                 System.out.println(stack[i]);
             }
         }
     }

     public static void main(String args[])
     {
         int item,choice;
         Scanner input =new Scanner(System.in);

         Stack st =new Stack();
         Loop : for(;;)
        {
           System.out.println("1.PUSH         2.POP        3.DISPLAY     4.Exit");
           System.out.println("Enter your choice");
           choice =input.nextInt();
           switch(choice)
           {
               case 1 :
                    System.out.println("Enter the item to be inserted");
                    item =input.nextInt();
                    try
                    {
                        st.push(item);
                    }
                    catch(StackOverflow e)
                    {
                        System.out.println(e);
                    }
                    break;
               case 2 :
                    try
                    {
                        item =st.pop();
                        System.out.println("Item deleted is : "+item);
                    }
                    catch(StackUnderflow se)
                    {
                        System.out.println(se);
                    }
                    break;
               case 3 :
                    st.display() ;
                    break;     
               default : break Loop;      
           }
        }  
     }
 }