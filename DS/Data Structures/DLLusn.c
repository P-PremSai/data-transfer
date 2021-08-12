/*Given an unsorted dll containing 'n' nodes of USN and Name . wap to remove the given USN nodes from list.*/

/*Excutives in onlline complier*/

#include<stdio.h>
#include<stdlib.h>

struct node
 {
  char usn[15],name[20];
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
NODE insert_rear(NODE head,char usn[],char name[])
{
NODE temp,cur;
int j;
temp=getnode();
temp->rlink=NULL;
temp->llink=NULL;
for(j=0;j<20;j++)
{
	temp->usn[j]=usn[j];
	temp->name[j]=name[j];
}

cur=head->llink;
temp->llink=cur;
cur->rlink=temp;
head->llink=temp;
temp->rlink=head;
//head->info=head->info+1;
return head;
}

NODE delete_all_key(char usn[],NODE head)
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
  if(usn[15]!=cur->usn[15])
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
  printf("USN not found");
else 
  printf("USN found and deleted");
// printf("Key found at %d positions and are deleted\n", count);

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
{
	printf("%s\t",temp->usn);
	printf("%s\n",temp->name);
}


}


void main()
{
int choice;
char usn[15],name[20];
NODE head;
head=getnode();
head->rlink=head;
head->llink=head;
for(;;)
{
printf("\n 1:Insert_rear\n 2:Delete_specific_USN\n 3:Display\n 4:Exit\n");
printf("Enter the choice\n");
scanf("%d",&choice);
switch(choice)
 {
  case 1:printf("Enter the USN\n");
		 scanf("%s",&usn);
		 printf("Enter the Name\n");
		 scanf("%s",&name);
		 head=insert_rear(head,usn,name);
		 break;
  case 2:printf("Enter the USN to be deleted\n");
         scanf("%s",&usn);	 
         head =delete_all_key(usn,head);
         break;
  case 3:display(head);
		 break;
  default:exit(0);
		  break;
  }
 }
}

