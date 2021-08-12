/*Given a circular singly linked list, reverse the list and display the same.
Sample Input: 1 2 3 4 5
Sample Output: 5 4 3 2 1*/
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

NODE cir_delete_front(NODE last)
{
NODE temp,first;
if(last==NULL)
{
printf("list empty\n");
return NULL;
}
if(last->link==last)
{
printf("item deleted is %d\n",last->info);
freenode(last);
return NULL;
}
first=last->link;
last->link=first->link;
printf("item deleted at front end is %d\n",first->info);
freenode(first);
return last;
}
NODE cir_delete_rear(NODE last)
{
NODE prev;
if(last==NULL)
{
printf("list empty\n");
return NULL;
}
if(last->link==last)
{
printf("item deleted is %d\n",last->info);
freenode(last);
return NULL;
}
prev=last->link;
while(prev->link!=last)
{
prev=prev->link;
}
prev->link=last->link;
printf("item deleted at rear end is %d\n",last->info);
freenode(last);
return prev;
}
void display(NODE last)
{
NODE temp;
if(last==NULL)
{
printf("list empty\n");
return;

}
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
printf("\n1:cir_insert_front\n2:cir_insert_rear\n3:cir_delete_front\n4:cir_delete_rear\n5:display\n6:Reverse\n7:exit\n");
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

case 3:last=cir_delete_front(last);
break;
case 4:last=cir_delete_rear(last);
break;
case 5:display(last);
break;
case 6:last=reverse(last);
break;
default:exit(0);
}
}
getch();
}
