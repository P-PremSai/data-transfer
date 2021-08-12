
               /*WORKS ON ONLINE COMPLIER*/

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
            { 
			    small=a[j];
             	pos=j;
            }
        }
        if(pos!=i)
        {
        	temp=a[i];
            a[i]=a[pos];
            a[pos]=temp;
		}
    }
}


int main()
{
 int n,a[1000000],sort,i;
	clock_t start,end;
	   printf("Enter the number of elements\n");
       scanf("%d",&n);
       
      /* printf("Enter elements which are to be sorted\n");
       for(i=0;i<n;i++)
       {
            scanf("%d",&a[i]);
       }*/
    //   randomize();
       for(i=0;i<n;i++)
        {
            a[i]=rand();
        }
        
        start = clock();
        sort=selectionsort(a,n);
        end = clock();
        double time_taken = ((double)end-start)/CLOCKS_PER_SEC;
        printf("Time taken to sort %d elements is %f sec\n",n,time_taken);
       
       
       if(sort!=0)
       {
            printf("Elements in a sorted way are:\n");
            for(i=0;i<n;i++)
            {
                printf("%d\n",a[i]);
            }
        }
       else
	   {
            printf("Not possible");
		}
    
    
}
