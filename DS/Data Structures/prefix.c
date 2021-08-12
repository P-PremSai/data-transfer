#include<stdio.h>
#include<string.h>
int F(char symbol)
{
	switch(symbol)
	{
		case '+' :
		case '-' :return 2;
		case '*' :
		case '/' :return 4;
		case '^' :
		case '$' :return 5;	
		case '(' :return 0;
		case '#' :return -1;
		default  :return 8;
	}
}
int G(char symbol)
{
switch(symbol)
	{
		case '+' :
		case '-' :return 1;
		case '*' :
		case '/' :return 3;
		case '^' :
		case '$' :return 6;	
		case '(' :return 9;
		case ')' :return 0;
		default  :return 7;
	}	
}

void infix_prefix(char infix[],char prefix[])
{
	int top;
	char s[20];
	int j;
	int i;
	char symbol;
	top =-1;
	s[++top]= '#';
	j=0;
	for(i=0;strlen(infix);i++)
	{
		symbol =infix[i];
		while(F(s[top])>G(symbol))
		{
			prefix[j] =s[top--];
			j++;
		}
		if(F(s[top])!=G(symbol))
		{
			s[++top] =symbol;
		}
		else 
		{
			top--;
		}
    }
	while(s[top]!='#')
	{
		prefix[j++]=s[top--];
	}
	prefix[j] ='\0';
	strrev(prefix);
}

void main()
{
	char infix[20];
	char prefix[20];
	char prefix1[20];
	int length;
	printf("Enter the infix expression\n");
	scanf("%s",&infix);
	infix_prefix(infix,prefix);
     length = strlen(postfix) – 1;
strncpy(prefix1, postfix, 20);
for(int count = 0; count < length; count++, length–)
{
temp = prefix[count];
prefix[count] = prefix1[length];
prefix1[length] = temp;
}
	printf("The prefix expression is \n");
	printf("%s\n",prefix);
	getch();
}
