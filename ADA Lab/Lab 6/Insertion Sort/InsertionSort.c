#include <math.h>
#include <stdio.h>
#include<time.h>
#include<stdlib.h>
 

void insertion_Sort(int array[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++) 
	{
        key = array[i];
        j = i - 1;

        while (j >= 0 && array[j] > key) 
		{
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = key;
    }
}


int main()
{
    int array[100],n,i;
    double time;
    clock_t start,end;
    while(1)
    {
    	printf("Enter the number of elements to be inserted\n");
        scanf("%d",&n);
        printf("Enter the elements of the array\n");
        for(i=0;i<n;i++)
        {
    	    scanf("%d",&array[i]);
	    }
	
        start = clock();
        insertion_Sort(array, n);
        end = clock();
  
        time = ((double)(end - start))/CLOCKS_PER_SEC;
        printf("Time taken for sorting %d elements is %f sec\n",n,time);
        printf("\n");
    
    
    for (i = 0; i < n; i++)
        printf("%d ", array[i]);
    printf("\n");
 
	}
    
}
