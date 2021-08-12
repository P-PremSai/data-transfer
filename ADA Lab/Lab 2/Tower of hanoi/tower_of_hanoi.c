#include<stdio.h>
#include<conio.h>
void towers(int n,char source ,char temp , char destination)
{
	if(n==1)
	{
		printf("Move disk 1 from %c to %c\n",source,destination);
		return;
	}
	towers(n-1,source,destination,temp);
	printf("Move disk %d from %c to %c \n",n,source,destination);
	
	towers(n-1,temp,source,destination);
}

void main()
{
	int n;
	printf("Enter the number of disks\n");
	scanf("%d",&n);
	towers(n,'S','T','D');
	getch();
}
