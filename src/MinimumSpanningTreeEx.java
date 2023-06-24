
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSpanningTreeEx {//kruskal 알고리즘
	
	static final int MAX=30;
	
	static int[][] G= new int[MAX][MAX];
	static int n;
	static int belongs[] = new int[MAX];
	static EdgeList eList = new EdgeList();
	static EdgeList spanList = new EdgeList();
	
	static class Edge{
		int u;
		int v;
		int w;
		
		public Edge(int u, int v, int w) {
			this.u=u;
			this.v=v;
			this.w=w;
		}
		
	}
	static class EdgeList{
		Edge[] data=new Edge[MAX];
		int n=0;
	}
		
		
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int i, j;
		
		System.out.println("노드의 수 입력");
		n= in.nextInt();
		
		System.out.println("노드의 인접행렬 입력");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				G[i][j]=in.nextInt();
		
		Kruskal();
		print();
		
	}
	static void Kruskal() {
		int i, j, cno1, cno2;
		eList.n=0;
		
		for(i=1;i<n;i++) 
			for(j=0;j<i;j++) {
				if(G[i][j]!=0) {
				eList.data[eList.n]=new Edge(i,j,G[i][j]);
				eList.n++;
				}
			}
		
		sort(eList);
		for(i=0;i<n;i++)
			belongs[i]=i;
		
		spanList.n=0;
		for(i=0;i<eList.n;i++) {
			cno1 = find(belongs, eList.data[i].u);
			cno2 = find(belongs, eList.data[i].v);
			
			if(cno1 != cno2) {
				spanList.data[spanList.n]=eList.data[i];
				spanList.n++;
				union(belongs, cno1, cno2);
			}
		}
	}
	
	static int find(int belongs[], int vertexno) {
		return (belongs[vertexno]);
	}

	static void union(int belongs[], int c1, int c2) {
		int i;
		for(i=0;i<n;i++) {
			if(belongs[i]==c2) {
				belongs[i]=c1;
			}
		}
	}
	static void sort(EdgeList elist) {
		int i, j;
		Edge temp;
		for(i=1;i<elist.n;i++) {
			for(j=0;j<elist.n-1;j++) {
				if(elist.data[j].w>elist.data[j+1].w) {
					temp = elist.data[j];
					elist.data[j]=elist.data[j+1];
					elist.data[j+1]=temp;
				}
			}
		}
	}
	
	static void print() {
	    int i, cost = 0;
	    for (i = 0; i < spanList.n; i++) {
	        System.out.printf("%d\t%d\t%d\n", spanList.data[i].u, spanList.data[i].v, spanList.data[i].w);
	        cost += spanList.data[i].w;
	    }
	    System.out.printf("최소 비용: %d\n", cost);
	}
}
