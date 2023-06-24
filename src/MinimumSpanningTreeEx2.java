import java.util.Scanner;

public class MinimumSpanningTreeEx2 {
	
	static final int infinity=9999;
	static final int MAX=20;
	
	static int G[][]=new int[MAX][MAX];
	static int spanning[][]=new int[MAX][MAX];
	static int n;
	
	static int distance[]=new int [MAX];
	static int from[]=new int [MAX];
	static int visited[]=new int [MAX];
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int i, j, total_cost;
		
		System.out.println("구성할 트리의 노드 수");
		n=in.nextInt();
		System.out.println("인접행렬 표햔시긍로 엣지와 가중치 입력");
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				G[i][j]=in.nextInt();
		
		total_cost=prims();
		System.out.println("\n 인접행렬 표현한 최소 신장트리:");
		
		for(i=0;i<n;i++) {
		    for(j=0;j<n;j++)
		        System.out.print(spanning[i][j]+"\t");
		    System.out.println();
		}
		
		
		System.out.println("Total Cost of spanning tree="+total_cost);
	}

	public static int prims() {
		int cost[][]= new int[MAX][MAX];
		int u=0,v=0,min_distance;
		int no_of_edges, i, min_cost, j;
		
		//create cost[][] matrix, spanning[][]
		for(i=0;i<n;i++)
			for(j=0;j<n;j++) {
				if(G[i][j]==0)
					cost[i][j]=infinity;
				else
					cost[i][j]=G[i][j];
				
				spanning[i][j]=0;
			}
		//initialise visited[], distance[] and from[]
		distance[0]=0;
		visited[0]=1;
		
		for(i=1;i<n;i++) {
			distance[i]=cost[0][i];
			from[i]=0;
			visited[i]=0;
			
		}
		min_cost=0;	//cost of spanning tree
		no_of_edges=n-1; //no. of edges to be added
		
		while (no_of_edges>0) {
			//find the vertex at minimum distance from the tree min_distance = infinity;
			min_distance = infinity;
			for(i=1;i<n;i++)
				if(visited[i]==0&&distance[i]<min_distance) {
					v=i;
					min_distance=distance[i];
				}
			u=from[v];
			//insert the edge in spanning tree
			spanning[u][v]=distance[v];
			spanning[v][u]=distance[v];
			no_of_edges--;
			visited[v]=1;
			
			//updated the distance[] array
			for(i=1;i<n;i++)
				if(visited[i]==0&& cost[i][v]<distance[i]) {
					distance[i]=cost[i][v];
					from[i]=v;
				}
			min_cost=min_cost+cost[u][v];
		}
		return min_cost;
	}
}