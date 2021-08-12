
#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#define V 5

int minKey(int key[], bool mstSet[])
{
	int min = INT_MAX, min_index,v;
    
	for (v = 0; v < V; v++)
		if (mstSet[v] == false && key[v] < min)
			min = key[v], min_index = v;

	return min_index;
}


int printMST(int parent[], int graph[V][V])
{
	printf("\n");
	int total=0;
	printf("Edges in the spanning tree are : \n");
	printf("Edge \t\tWeight\n");
	int i;
	for (i = 1; i < V; i++)
	{
	
		printf("%d - %d \t\t%d \n", parent[i], i, graph[i][parent[i]]);
		total =total+graph[i][parent[i]];
	}
	printf("Total weight = %d ",total);
}


void primMST(int graph[V][V])
{
	
	int parent[V];

	int key[V],i,count,v;
	
	bool mstSet[V];

	
	for (i = 0; i < V; i++)
		key[i] = INT_MAX, mstSet[i] = false;

	
	key[0] = 0;
	parent[0] = -1; 

	
	for (count = 0; count < V - 1; count++) {
		
		int u = minKey(key, mstSet);

		
		mstSet[u] = true;

		for (v = 0; v < V; v++)

			if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])
				parent[v] = u, key[v] = graph[u][v];
	}

	
	printMST(parent, graph);
}


int main()
{
    //printf("Enter the number of vertices\n");
    //scanf("%d",V);
    
	int graph[V][V] ;
	int i,j;
	printf("Enter the elements of the adjacency matrix\n");
	for(i=0;i<V;i++)
	{
		for(j=0;j<V;j++)
		{
			scanf("%d",&graph[i][j]);
		}
	}
	primMST(graph);

	return 0;
}

