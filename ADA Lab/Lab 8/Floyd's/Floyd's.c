#include<stdio.h>

#define INF 99999

int V;
int i,j;
void printSolution(int dist[][V]);


void floydWarshall (int graph[][V])
{
	
	int dist[V][V], i, j, k;

	
	for (i = 0; i < V; i++)
		for (j = 0; j < V; j++)
			dist[i][j] = graph[i][j];

	
	for (k = 0; k < V; k++)
	{
		
		for (i = 0; i < V; i++)
		{
			
			for (j = 0; j < V; j++)
			{
				
				if (dist[i][k] + dist[k][j] < dist[i][j])
					dist[i][j] = dist[i][k] + dist[k][j];
			}
		}
	}

	
	printSolution(dist);
}


void printSolution(int dist[][V])
{
	printf ("The following matrix shows the shortest distances"
			" between every pair of vertices \n");
	for (i = 0; i < V; i++)
	{
		for (j = 0; j < V; j++)
		{
			if (dist[i][j] == INF)
				printf("%7s", "INF");
			else
				printf ("%7d", dist[i][j]);
		}
		printf("\n");
	}
}


int main()
{
	printf("Enter the number of vertices\n");
	scanf("%d",&V);
	int graph[V][V];
	
	printf("Enter the distance matrix (Enter -1 is no edge)\n");
	for(i=0;i<V;i++)
	{
		for(j=0;j<V;j++)
		{
			scanf("%d",&graph[i][j]);
		}
	}
	
	
	for(i=0;i<V;i++)
	{
		for(j=0;j<V;j++)
		{
			if(graph[i][j]==-1)
			{
				graph[i][j]=INF;
			}
		}
	}
	

	
	floydWarshall(graph);
	return 0;
}

