/*Given an unsorted doubly linked list containing 'n'nodes of integer values . Write a program to remove duplicate nodes from the given list
Sample Input : 8<->7<->5<->8<->7<->8<->1
Sample Output :8<->7<->5<->1   */

#include<stdio.h>
#include<stdlib.h>

struct node
 {
  int info;
  struct node *rlink;
  struct node *llink;
 };
typedef struct node *NODE;
NODE getnode()
{
NODE x;
x=(NODE)malloc(sizeof(struct node));
if(x==NULL)
 {
  printf("Memory full\n");
  exit(0);
 }
 return x;
}
void freenode(NODE x)
{
free(x);
}
NODE insert_rear(NODE head,int item)
{
NODE temp,cur;
temp=getnode();
temp->rlink=NULL;
temp->llink=NULL;
temp->info=item;
cur=head->llink;
temp->llink=cur;
cur->rlink=temp;
head->llink=temp;
temp->rlink=head;
head->info=head->info+1;
return head;
}



void display(NODE head)
{
NODE temp;
if(head->rlink==head)
{
printf("list empty\n");
return;
}
for(temp=head->rlink;temp!=head;temp=temp->rlink)
printf("%d\n",temp->info);
}

NODE remove_duplicates(NODE head)
{
	NODE check,cur,prev,next;
	check =head->rlink;
	prev =head->rlink;
    cur=prev->rlink;
    next=cur->rlink;
	while(check->rlink!=head)
	{
		while(cur->rlink!=head)
		{
			if(check->info==cur->info && check!=cur)
			{
				prev->rlink=cur->rlink;
				next->llink =cur->llink;
				freenode(cur);
				cur=next;
				next=next->rlink;
			}
			else
			{
				next =next->rlink;
				cur=cur->rlink;
				prev =prev->rlink;
			}
		}
		check =check->rlink;
		prev =head->rlink;
    	cur=prev->rlink;
    	next=cur->rlink;
    	if(check==cur)
    	{
    	    cur =cur->rlink;
    	    prev= prev->rlink;
    	    next =next->rlink;
    	}
	}
}
void main()
{
int item,choice,key;
NODE head;
head=getnode();
head->rlink=head;
head->llink=head;
for(;;)
{
printf("\n1:Insert_rear\n2:Display\n3:Remove Duplicates\n4:Exit\n");
printf("Enter the choice\n");
scanf("%d",&choice);
switch(choice)
 {
  case 1:printf("Enter the item\n");
		 scanf("%d",&item);
		 head=insert_rear(head,item);
		 break;
  case 2:display(head);
		 break;
  case 3 :remove_duplicates(head);
          display(head);
         break;
  default:exit(0);
		  break;
  }
 }
}

