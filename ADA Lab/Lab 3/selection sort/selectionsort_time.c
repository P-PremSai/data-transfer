#include <stdio.h>
#include<time.h>
#include<stdlib.h>
int selectionsort(int a[],int n)
{
int temp,pos,small,i,j;
for(i=0;i<=n-2;i++)
{
	small=a[i];
	pos=i;
for(j=i+1;j<=n-1;j++)
{
if(a[j]<small)
{small=a[j];
	pos=j;
}
}
temp=a[i];
a[i]=a[pos];
a[pos]=temp;
}
}


int main()
{
 int n,a[20000],sort,i,j,temp;
 clock_t start,end;

	
       while(1)
       {
		   n=500;
		   while(n<=19500)
		   {
			   for(i=0;i<n;i++)
			   {
				   a[i]=n-1;
			   }
				   start=clock();
				  sort=selectionsort(a,n);
				   for(j=0;j<500000;j++)
				   {temp=38/600;}
				   end=clock();
				   printf("\n time taken to sort %d numbers is %fsecs",n,(((double)(end-start))/(CLOCKS_PER_SEC)));
				   n=n+1000;
    
    }
}
}
