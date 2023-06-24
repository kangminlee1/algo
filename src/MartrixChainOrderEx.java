
public class MartrixChainOrderEx {

	
	
	public static void main(String[] args) {
		int[] arr= {10, 20, 5 ,15 ,30};
		int size=arr.length;
		
		System.out.println("Minimum number of multiplications is "+MatrixChainOrder(arr, size));

	}
	
	static int MatrixChainOrder(int p[], int n) {
		/* For simplicity of the program, one extra row and one
		extra column are allocated in m[][].  0th row and 0th
		column of m[][] are not used */

		int i, j, k, L, q;
//		int **m; // for the matrix
//		m = (int **)malloc(sizeof(int)*n);
//		for (i = 0; i < n; i++)
//		m[i] = (int*)malloc(sizeof(int)*n);
		int[][] m=new int[n][n];

		/* m[i, j] = Minimum number of scalar multiplications needed
		to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
		dimension of A[i] is p[i-1] x p[i] */

		// cost is zero when multiplying one matrix.
		for(i=1;i<n;i++) {
			m[i][i]=0;
		}

		// L is chain length.
		for(L=2;L<n;L++) {
			for(i=1;i<n-L+1;i++) {
				j=i+L-1;
				m[i][j]=Integer.MAX_VALUE;
				
				for(k=i;k<j;k++) {
					q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<m[i][j])
						m[i][j]=q;
				}
			}
		}

		return m[1][n - 1];
		}

}
