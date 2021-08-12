/*WAP Implement doubly link list with primitive operations
a)  	Create a doubly linked list.
b)  	Insert a new node to the left of the node.
c)  	Delete the node based on a specific value
d)  	Display the contents of the list*/

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


NODE insert_leftpos(int item,NODE head)
{
NODE temp,cur,prev;
if(head->rlink==head)
{
printf("List is empty\n");
return head;
}
cur=head->rlink;
while(cur!=head)
{
if(item==cur->info)break;
cur=cur->rlink;
}
if(cur==head)
{
 printf("key not found\n");
 return head;
 }
 prev=cur->llink;
 printf("Enter the item to be inserted towards the left of %d:\n",item);
 temp=getnode();
 scanf("%d",&temp->info);
 prev->rlink=temp;
 temp->llink=prev;
 cur->llink=temp;
 temp->rlink=cur;
 return head;
}


NODE delete_all_key(int item,NODE head)
{
NODE prev,cur,next;
int count;
   if(head->rlink==head)
    {
     printf("List is Empty");
     return head;
     }
count=0;
cur=head->rlink;
while(cur!=head)
{
  if(item!=cur->info)
  cur=cur->rlink;
  else
 {
  count++;
  prev=cur->llink;
  next=cur->rlink;
  prev->rlink=next;
  next->llink=prev;
  freenode(cur);
  cur=next; 
 }
}
if(count==0)
  printf("Key not found");
else
 printf("Key found at %d positions and are deleted\n", count);

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
void main()
{
int item,choice,key;
NODE head;
head=getnode();
head->rlink=head;
head->llink=head;
for(;;)
{
printf("\n 1:Insert_rear\n 2:Insert_key\n 3:Delete_specific_value\n 4:Display\n 5:Exit\n");
printf("Enter the choice\n");
scanf("%d",&choice);
switch(choice)
 {
  case 1:printf("Enter the item\n");
		 scanf("%d",&item);
		 head=insert_rear(head,item);
		 break;
  case 2:printf("Enter the key item\n");
		 scanf("%d",&item);
		 head=insert_leftpos(item,head);
		 break;
  case 3:printf("Enter the specific value to be deleted\n");
         scanf("%d",&item);	 
         head =delete_all_key(item,head);
         break;
  case 4:display(head);
		 break;
  default:exit(0);
		  break;
  }
 }
}

