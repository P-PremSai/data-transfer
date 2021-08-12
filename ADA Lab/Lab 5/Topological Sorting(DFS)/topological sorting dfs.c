#include<stdio.h>
#include<conio.h>
#include<process.h>
#include<stdlib.h>
int a[10][10],vis[10],ex[10],n,j,i;

void topo_dfs(int v)
{
	vis[v]=1;
	for(i=1;i<=n;i++)
	{
		if(a[v][i]==1&&vis[i]==0)
			topo_dfs(i);
	}
	
	ex[j++]=v;
}

void main()
{
	int m,u,v;
	printf("enter no of vertices \n");
	scanf("%d",&n);
	
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
			a[i][j]=0;
	}
	
	printf("Enter no of edges \n");
	scanf("%d",&m);
	for(i=1;i<=m;i++)
	{
		printf("enter an edge between 2 vertices\n");
		scanf("%d%d",&u,&v);
		a[u][v]=1;
	}
	
	for(i=1;i<=n;i++)
		vis[i]=0;
	
	for(i=1;i<=n;i++)
	{
		if(vis[i]==0)
			topo_dfs(i);
	}
	
	printf("Topological order by dfs method : \n");
	for(i=n-1;i>=0;i--)
		printf("%d ",ex[i]);
}
