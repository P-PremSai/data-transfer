#include <stdio.h>
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
 int n,a[100],sort,i;
 printf("enter the number of elements\n");
       scanf("%d",&n);
       printf("enter elements which is to be sorted\n");
       for(i=0;i<n;i++)
       {
       scanf("%d",&a[i]);
       }
    sort=bubblesort(a,n);
    if(sort!=0)
    {
    printf("elements in a sorted way are:\n");
    for(i=0;i<n;i++)
   {
    printf("%d\n",a[i]);
    }
    }
    else{
    printf("not possible");}
    }
