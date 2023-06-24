import java.util.Scanner;
public class BellmanEx {
	
	static final int INF=10000;
	static final int MAX= 20;
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int V;
		int[][] edge=new int[MAX][2];
		int[][] G=new int[MAX][MAX];
		int i, j, k=0;
		System.out.println("Bellman Ford");
		System.out.print("Enter no of vertices: ");
		V=in.nextInt();
		System.out.println("Enter graph in matrix form:");
		for(i=0;i<V;i++)
			for(j=0;j<V;j++) {
				G[i][j]=in.nextInt();
				if(G[i][j]!=0) {
					edge[k][0]=i; 
					edge[k++][1]=j;
				}
			}
		
		if(Bellman_Ford(G,V,k,edge)!=0)
			System.out.println("No negative weight cycle");
		else
			System.out.println("Negative weight cycle exisys");
	}

	static int Bellman_Ford(int G[][],int V,int E, int edge[][]){
		Scanner in=new Scanner(System.in);
		int i,u,v,k, S=0;
		int flag=1;
		int[] distance= new int[MAX];
		int[] parent=new int [MAX];
		
		System.out.println("enter source");
		S=in.nextInt();
		
		   // distance initializing. All nodes set value to inf except start node. 
		   // Parent arrays are also needed to be initialized with negative values such as -1
		   // Main algorithm of Bellman ford. To find the nodes u and v, we can use the edge    // array. It contains edge information from source nodes to destination nodes.
		   // For example, edge[0][0] means a start point, edge[0][1] indicates the end point.
		
		for(i=0;i<V;i++) {
			distance[i]=INF;
			parent[i]=-1;
		}
		distance[S-1]=0;
		
		for(i=1;i<V-1;i++) {
			for(k=0;k<E;k++) {
				u=edge[k][0];
				v=edge[k++][1];
				if(distance[u]+ G[u][v]<distance[v]) {
					distance[v]=distance[i]+G[u][v];
					parent[v]=u;
				}
			}
			
		}
		
		for(k=0;k<E;k++) {
			u=edge[k][0]; 
			v=edge[k][1];
		if(distance[u]+G[u][v]<distance[v])
			flag=0;
		}
		if(flag!=0)
			for(i=0;i<V;i++)
				System.out.println("Vertex "+(i+1)+"cost = "+distance[i]+" parent = "+(parent[i]+1));
		
		return flag;
	}
}
