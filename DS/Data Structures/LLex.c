/*abc shopping mall decided to bill all the items (name, cost) shopped in last-in first-out order. wap to simulate the above scenario using linked list*/

/*Running in online complier*/


#include<stdio.h>
#include<stdlib.h>

struct node
{
  char name[20];	
  int cost;
  struct node *link;
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

NODE insert_rear(NODE first,char name[],int cost)
{
NODE temp,cur;
temp=getnode();
for(int j=0; j<20; j++)
{
	temp->name[j]=name[j];
}

temp->cost=cost;
temp->link=NULL;
if(first==NULL)
 return temp;
cur=first;
while(cur->link!=NULL)
 cur=cur->link;
cur->link=temp;
return first;
}

NODE delete_front(NODE first)
{
NODE temp;
if(first==NULL)
{
printf("List is Empty cannot delete\n");
return first;
}
temp=first;
temp=temp->link;
printf("Item deleted name is= %s\n",first->name);
free(first);
return temp;
}

void display(NODE first)
{
 NODE temp;
 if(first==NULL)
    printf("List empty cannot display items\n");
 for(temp=first;temp!=NULL;temp=temp->link)
  {
  printf("Name : %s\t",temp->name);
  printf("Cost : %d\n",temp->cost);
  }
}


void main()
{
	char name[20];
	int cost,choice;
    NODE first=NULL;
	for(;;)
        {
            printf("\n 1:Insert_rear\n 2:Delete_front\n 3:Display_list\n 4:Exit\n");
            printf("Enter the choice\n");
            scanf("%d",&choice);
            switch(choice)
            { 
            case 1:printf("Enter the name \n");
                    scanf("%s",&name);
			        printf("Enter the cost of %s\n",name);
                    scanf("%d",&cost);
                    first=insert_rear(first,name,cost);
                    break;
            case 2:first=delete_front(first);
                    break;
            case 3:display(first);
                    break;
            default:exit(0);
                    break;
            }
        }
}
