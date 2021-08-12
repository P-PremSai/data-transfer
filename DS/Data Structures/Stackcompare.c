#include<stdio.h>
#include<conio.h>
 int s1[10],s2[10];
 int item,top=-1,top2=-1,n,flag=1;
 int Stack_size1,Stack_size2;
 
 void push(int a)
 {
 	n=a;
 	if(n==1)
 	{
 	if(top==Stack_size1-1)
 	{
 		printf("Stack overflow\n");
	 }
	 else 
	 {
	 	top=top+1;
	 	s1[top]=item;
		 
	 }
   }
   if(n==2)
   {
   if(top2==Stack_size2-1)
 	{
 		printf("Stack overflow\n");
	 }
	 else 
	 {
	 	top2=top2+1;
	 	s2[top2]=item;
	 }
   }  
	 
 }
 
 void display(int a)
 {
 	n=a;
 	if(n==1)
 	{
 	if(top==-1)
 	{
 		printf("Stack is empty");
 		return;
	 }
	 else 
	 {
	 	printf("Contents of the stack 1 are :\n");
	 	     for(int i=0;i<Stack_size1;i++)
	 	     {
	 	     	printf("%d\n",s1[i]);
			  }
	 }
 }
    if(n==2)
 	{
 	if(top==-1)
 	{
 		printf("Stack is empty");
 		return;
	 }
	 else 
	 {
	 	printf("Contents of the stack 2 are :\n");
	 	     for(int i=0;i<Stack_size2;i++)
	 	     {
	 	     	printf("%d\n",s2[i]);
			  }
	 }
 }
}

int main()
{
	int choice;
	printf("Enter the number of elements of stack 1\n");
	scanf("%d",&Stack_size1);
	printf("Enter the number of elements of stack 2\n");
	scanf("%d",&Stack_size2);
	
 	    printf("Stack 1\n");
		  
	          for(int i=0;i<Stack_size1;i++)
	          {
	             	printf("1.push  2.display 3.exit\n");
	             	printf("Enter your choice\n");
	            	scanf("%d",&choice);
	             	switch(choice)
	            	{
	             		case 1:
			         	{
				         	printf("Enter the item to be inserted\n");
				        	scanf("%d",&item);
				         	push(1);
				        	break;
		                 }
		                case 2:
			            {
			               	display(1);
			            	break;
		           	     }  
			             
                	}
	
                }
            
         
		  printf("stack 2\n");
	          for(int i=0;i<Stack_size2;i++)
	          {
	             	printf("1.push  2.display 3.exit\n");
	             	printf("Enter your choice\n");
	            	scanf("%d",&choice);
	             	switch(choice)
	            	{
	             		case 1:
			         	{
				         	printf("Enter the item to be inserted\n");
				        	scanf("%d",&item);
				         	push(2);
				        	break;
		                 }
		                case 2:
			            {
			               	display(2);
			            	break;
		           	     }  
			     
                	}
	
                }

    if(Stack_size1!=Stack_size2)
    {
        printf("Stacks are not equal\n");
        
    }
    else if(Stack_size1==Stack_size2)
    {
        for(int i=0;i<Stack_size2;i++)
        {
            if(s1[i]!=s2[i])
            {
                flag=0;
                printf(" notdone\n");
            }
            else if(s1[i]==s2[i])
            {
                 printf("done\n");
            }
        }
        if(flag==0)
        {
            printf("not equal\n");
        }
        else 
        {
            printf("equal");
        }
    }
 	    
 	
}
