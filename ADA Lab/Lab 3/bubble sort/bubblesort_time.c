#include <stdio.h>
#include<time.h>
#include<stdlib.h>

int bubblesort(int a[],int n)
{
int temp,i,j;
for(i=1;i<=n-1;i++)
{
for(j=0;j<=n-i-1;j++)
{
if(a[j]>a[j+1])
{
temp=a[j];
a[j]=a[j+1];
a[j+1]=temp;
}
}
}

}


int main()
{
 int n,a[30000],sort,i,j,temp;
 clock_t start,end;
 
 while(1)
       {
		   n=500;
		   while(n<=29500)
		   {
			   for(i=0;i<n;i++)
			   {
				   a[i]=n-1;
			   }
				   start=clock();
				  sort=bubblesort(a,n);
				   for(j=0;j<500000;j++)
				   {temp=38/600;}
				   end=clock();
				   printf("\n time taken to sort %d numbers is %fsecs",n,(((double)(end-start))/(CLOCKS_PER_SEC)));
				   n=n+1000;
    
            }
        }
}
