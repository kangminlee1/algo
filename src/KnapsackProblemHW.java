import java.util.Scanner;

public class KnapsackProblemHW {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=0;
		int W=0;
		
		while(true) {
		System.out.print("물건의 개수 입력: ");
		n=in.nextInt();
		System.out.println();
		
		if(n<1||n>10) {
			System.out.println("1~10 사이의 정수를 다시 입력해 주세요");
		}
		else
			break;
		}
		
		
		int[] val=new int[n];
		int[] wt=new int[n];   
		   
		   for(int i=0;i<n;i++) {
			   while(true) {
			   System.out.print((i+1)+"번째 상품의 무게: ");
			   wt[i]=in.nextInt();
			   if(wt[i]<10||wt[i]>50) {
				   System.out.println("물건의 무게를 10~50 사이의 정수를 다시 입력해 주세요");
			   }
			   else if(sameWeight(i, wt))
				   System.out.println("동일한 무게의 물건이 이미 있습니다.");
			   else 
				   break;
			   }
			   System.out.print((i+1)+"번째 상품의 가격: ");
			   val[i]=in.nextInt();
			   if(sameValue(i,val))
			   {
				   System.out.println("동일한 가치의 물건이 이미 있습니다.");
				   i--;
			   }
			   
		   }
		   
		   while(true) {
			   System.out.println("배낭의 용량: ");
			   W=in.nextInt();
			   System.out.println();
			   
			   if(W<50||W>100)
			   System.out.println("배낭의 용량을 50~100사이의 정수로 다시 입력해 주세요");
			   else
				   break;
		   }
			   
			   
			System.out.println("배낭에 채워진 아이템의 수: "+countItem(W, wt, val, n)+"개");
			System.out.println("배낭의 현재 무게: "+currentWeight(W, wt, val, n)+"KG");
			System.out.println("배낭의 아이템의 총 가치: "+knapSack(W,wt, val, n)+"만원");
		  //System.out.println("Maximum value of the goods in the Knapsack : "+knapSack(W, wt, val, n));
	}
	// 중복 무게 검사 메소드
	static boolean sameWeight(int currentIndex, int[] wt) {
	    for (int i = 0; i < currentIndex; i++) {
	        if (wt[i] == wt[currentIndex]) {
	            return true;
	        }
	    }
	    return false;
	}

	// 중복 가치 검사 메소드
	static boolean sameValue(int currentIndex, int[] val) {
	    for (int i = 0; i < currentIndex; i++) {
	        if (val[i] == val[currentIndex]) {
	            return true;
	        }
	    }
	    return false;
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
	static int countItem(int W, int[] wt, int[] val, int n) {
		if(n==0||W==0)
			return 0;
		
		if(wt[n-1]>W) {
			return countItem(W, wt, val, n-1);
		}
		else {
			int includeItem=1 + countItem(W-wt[n-1],wt, val, n-1);
			int excludeItem=countItem(W, wt, val, n-1);
			return max(includeItem, excludeItem);
		}
	}
	static int currentWeight(int W, int[] wt, int[] val, int n) {

		if(n==0||W==0)
			return 0;
		
		if(wt[n-1]>W) {
			return currentWeight(W, wt, val, n-1);
		}
		else 
			return wt[n-1]+ currentWeight(W-wt[n-1], wt, val, n-1);

	}
}
