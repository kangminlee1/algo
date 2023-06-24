//1,5, 10, 16센트 동전 5가지만 고려
//거스름돈 금액: 20원
//최소 동전의 개수 , 어떤 동전

public class CoinChangeEx {
	//infinity: actually a very large number
	static final int INF=999;
	
	//total different denominations of coins available
	static final int N=4;

	//amount for which we are making change
	static final int A=20;

//	static void display(int arr[A+1]);
//	static void coinChange(int d[N+1], int C[A+1], int S[A+1]);
//	static void coinSet(int d[N+1], int S[A+1]);

	public static void main(String[] args) {
		 // d coins we will start from index 1. so, index 0 is set to 0
		   int d[] = {0, 1, 5, 10, 16};
		   //Minimum number of coins required to make change
		   int C[]=new int[A+1];
		   //S contain the index of the coin to be included
		   //in the optimal solution
		   int S[]=new int[A+1];
		   //compute minimum number of coins required
		   coinChange(d, C, S);
			
		   System.out.println("\nC[p]\n"); //display the content of the C array
		   display(C);
		   System.out.println("\nS[p]\n"); //display the content of the S array
		   display(S);
		   //display the minimum number of coins required to
		   //make change for amount A
		   System.out.println("\nMin. no. of coins required to make change for amount "+A+ " = "+C[A]);
			
		   //display the coins used in the optimal solution
		   System.out.println("\nCoin Set\n");
		   coinSet(d, S);
	}
	
	static void coinChange(int d[], int C[], int S[]) {
		   int i, p, min, coin=0;
		   //when amount is 0 then min coin required is 0
		   C[0] = 0;
		   S[0] = 0;
		   for(p = 1; p <= A; p++) {
		      min = INF;
		      for(i = 1; i <= N; i++) {
		         if(d[i] <= p) {
		            if(1 + C[p - d[i]] < min) {
			min = 1 + C[p - d[i]];
			coin = i;
		            }
		         }
		      }
		      C[p] = min;
		      S[p] = coin;
		   }
		}

		static void coinSet(int d[], int S[]) {
		   int a = A;
		   while(a > 0) {
		      System.out.println("Used coin : "+d[S[a]]);
		      a = a - d[S[a]];
		   }
		}

		static void display(int arr[]) {
		   int c;
		   for(c = 0; c <= A; c++) {
		      System.out.print("    "+arr[c]);
		   }
		   System.out.println();
		}
	

}
