#include<stdio.h>
#include<time.h>

void quicksort(int array[20],int first,int last){
   int i, j, pivot, temp;

   if(first<last){
      pivot=first;
      i=first;
      j=last;

      while(i<j){
         while(array[i]<=array[pivot]&&i<last)
            i++;
         while(array[j]>array[pivot])
            j--;
         if(i<j){
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
         }
      }

      temp=array[pivot];
      array[pivot]=array[j];
      array[j]=temp;
      quicksort(array,first,j-1);
      quicksort(array,j+1,last);

   }
}

int main(){
   int i, count, array[20];
   clock_t start,end;
   
   printf("Enter the number of elements \n ");
   scanf("%d",&count);

   printf("Enter the elements: \n");
   for(i=0;i<count;i++)
      scanf("%d",&array[i]);
   
   start = clock();
   
   quicksort(array,0,count-1);
   
   end = clock();
   double time_taken = ((double)end-start)/CLOCKS_PER_SEC;
   printf("Time taken to sort %d elements is %f sec\n",count,time_taken);
    
   printf("Order of Sorted elements: ");
   for(i=0;i<count;i++)
      printf(" %d",array[i]);

   return 0;
}
