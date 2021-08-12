/*Given a Circular linked list exchange the first and the last node .The task should be done with only one extra node .You cannot declare more than one extra 
node and also you are not allowed to declare any other temporary variable .Write a program to perform the above task.

Sample Input :5->4->3->2->1
Sample Output :1->4->3->2->5*/

#include<stdio.h>
#include<stdlib.h>
struct node
{
int info;
struct node *link;
};
typedef struct node *NODE;
NODE getnode()
{
NODE x;
x=(NODE)malloc(sizeof(struct node));
if(x==NULL)
{
printf("mem full\n");
exit(0);
}
return x;
}
void freenode(NODE x)
{
free(x);
}

NODE cir_insert_front(NODE last,int item)
{
NODE temp;
temp=getnode();
temp->info=item;
if(last==NULL)
last=temp;
temp->link=last->link;
last->link=temp;
return last;
}

NODE cir_insert_rear(NODE last,int item)
{
NODE temp;
temp=getnode();
temp->info=item;
if(last==NULL)
last=temp;
else
temp->link=last->link;
last->link=temp;
return temp;
}

NODE exchange(NODE last)
{
	NODE cur;
	cur =last->link;
	last->link =cur->link;
	cur->link =last;
	while(last->link!=cur->link)
	{
	    last =last->link;
	}
	last->link=cur;
//	printf("last is %d",last->info);
	//printf("cur is %d",cur->info);
	return cur;
}
void display(NODE last)
{
NODE temp;
if(last==NULL)
{
printf("list empty\n");
return;

}
//printf("Last is :%d\n",last->info);
//printf("cur is %d\n",last->link->info);
printf("contents of circular list are\n");
for(temp=last->link;temp!=last;temp=temp->link)
{
printf("%d\n",temp->info);
}
printf("%d\n",temp->info);
}

NODE reverse(NODE last)
{
	NODE cur,prev;
	prev=last;
	cur =last->link;
	int count=0,i;
	while(cur!=prev)
	{
		prev->link=last;
		last= prev;
		prev =cur;
		cur =cur->link;
		count++;
	}
	prev->link=last;
	last= prev;
	prev =cur;
	cur =cur->link;
	for(i=0;i<count-1;i++)
	{
		last=last->link;
	}
    return last;
}
void main()
{
int item,choice;
NODE last=NULL;
for(;;)
{
printf("\n1:cir_insert_front\n2:cir_insert_rear\n3:display\n4:Reverse\n5:Exchange\n6:exit\n");
printf("enter the choice\n");
scanf("%d",&choice);
switch(choice)
{
case 1:printf("enter the item at front end\n");
scanf("%d",&item);
last=cir_insert_front(last,item);
break;

case 2:printf("enter the item at rear end\n");
scanf("%d",&item);
last=cir_insert_rear(last,item);
break;
case 3:display(last);
break;
case 4:last=reverse(last);
break;
case 5 :
last =exchange(last);
       display(last);
       break;
default:exit(0);
}
}
getch();
}
