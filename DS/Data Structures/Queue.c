#include<stdio.h>
#include<conio.h>
#define Queue_size 3
int item,front=0,rear=-1,q[10];

void insertrear()
{
	if(rear==Queue_size-1)
	{
		printf("Queue overflow\n");
		return;
	}
	else
	{
	rear =rear+1;
	q[rear]=item;
    }
}

int deletefront()
{
	if(front>rear)
	{
		front =0;
		rear =-1;
		return-1;
	}
	return q[front++]; 
}

void displayQ()
{
	int i;
	if(front>rear)
	{
		printf("Queue is empty\n");
		return;
	}
	printf("Conents of the Queue are :\n");
	for(i=front;i<rear;i++)
	{
		printf("%d\n",q[i]);
	}
}

void main()
{
	int choice;
	for(;;)
	{
     	printf("Enter your choice\n");
	    printf(" 1:insert rear\n 2:deletefront\n 3:display\n 4:exit\n");
	    scanf("%d",&choice);
	    switch(choice)
	    {
		   case 1:
		    	printf("Enter the item to be inserted\n");
			    scanf("%d",&item);
			    insertrear();
			    break;
		
	    	case 2:
		        item =deletefront();
		    	if(item==-1)
		    	{
			    	printf("Queue is empty\n");
	     		}
		    	else 
		    	{
			    	printf("Item deleted =%d\n",item);
		    	}
		    	break;
			
	    	case 3:
		        displayQ();
			    break;
	    	default:
		     	exit(0);
	    }
    }
}
