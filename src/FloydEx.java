
public class FloydEx {
	
	static final int V=5;
	static final int INF=10000;
	static int count=0;
	
	public static void main(String[] args) {
		  int[][] graph = {
				  { 0, 8, 4, 5, 5 },
                  { 7, 0, 6, 2, 2 },
                  { 3, 2, 0, 3, 7 },
                  { 7, 3, 7, 0, 1 },
                  { 3, 7, 4, 2, 0 },
		  	};

		  // 플로이드 워셜 알고리즘으로 진입
		  floydWarshall(graph);

	}
	// 플로이드 워셜의 결과를 출력하는 함수
	static void printSolution(int dist[][]) {
	System.out.print("Following matrix shows the shortest distances, between every pair of vertices \n\n");
	System.out.print("\t   to→ ");
	for (int i = 0; i < V; i++)
	System.out.print("["+i+"]    ");

	System.out.print("\n      ↓from \n");

	for (int i = 0; i < V; i++) {
		System.out.print("\t["+i+"]");
	for (int j = 0; j < V; j++) {
	if (dist[i][j] == INF)
		System.out.printf("%7s", "INF");
	else
		System.out.printf("%7d",dist[i][j]);
	}
	System.out.print("\n");
	}
	System.out.println("변경횟수는 "+count+"개 입니다.");
	}
	
	// 모든 경로에 대한 최단 거리를 찾아주는 플로이드 워셜 함수
	static void floydWarshall(int graph[][]) {
	  /* dist[][] 배열에 최단 거리에 대한 정보들이 모두 들어가게 된다. */
	   int[][] dist=new int[V][V];
	   int i, j, k;
	  /*
	    dist[][] 배열에 초기값은 그래프에서 주어진 값들이다.
	   (즉, 아직 최단 거리를 구하기 전에는 기존의 거리를 최단 거리라 생각한다.)
	  */
	   for (i = 0; i < V; i++)
	   for (j = 0; j < V; j++)
	   dist[i][j] = graph[i][j];//복사
	   /* 플로이드 워셜 알고리즘의 핵심 */
	   
	   for(k=0;k<V;k++) {
		   for(i=0;i<V;i++) {
			   if(i==k) continue;

				   for(j=0;j<V;j++) {
					   if(j==k || j==i) continue;

						   if(dist[i][j]>dist[i][k]+dist[k][j]) {
						   dist[i][j]=dist[i][k]+dist[k][j]; 
						   count++;
						   }
					   }
					   
				   }   
		   }
	   
	// 모든 최단거리가 구해지고 난 뒤, 출력을 해준다.
	   printSolution(dist);
	}
}
//dist[i][j]=Math.min(dist[i][j]+dist[k][j], dist[i][j]);//min 함수 사용한 것	
