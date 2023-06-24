import java.util.Scanner;

public class KnapsackProblemEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
//		   int val[] = { 120, 100, 250, 300, 220};
//		   int wt[] = { 32, 15, 48, 50, 18};
		   int[] val=new int[5];
		   int[] wt=new int[5];
		   
		   int  W = 100;
		   int n = val.length;
		   
//		   for(int i=0;i<wt.length;i++) {
//			   System.out.println((i+1)+"번째 상품의 무게: "+ wt[i]+"kg");
//			   System.out.println((i+1)+"번째 상품의 가격: "+ val[i]);
//		   }
		   
		   for(int i=0;i<5;i++) {
			   System.out.print((i+1)+"번째 상품의 무게: ");
			   wt[i]=in.nextInt();
			   System.out.print((i+1)+"번째 상품의 가격: ");
			   val[i]=in.nextInt();
		   }
			   
			   
		  System.out.println("Maximum value of the goods in the Knapsack : "+knapSack(W, wt, val, n));
	}
	static int max(int a, int b) { return (a > b)? a : b; }
	
	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n)
	{
	   // Base Case
	   if (n == 0 || W == 0)
	       return 0;
	 
	   // If weight of the nth item is more than Knapsack capacity W, then
	   // this item cannot be included in the optimal solution
	   if (wt[n-1] > W)
	       return knapSack(W, wt, val, n-1);
	 
	   // Return the maximum of two cases: 
	   // (1) nth item included 
	   // (2) not included
	   else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
	                    knapSack(W, wt, val, n-1)
	                  );
	}
}
