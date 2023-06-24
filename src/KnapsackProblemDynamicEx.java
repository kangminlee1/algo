import java.util.Scanner;
public class KnapsackProblemDynamicEx {
	
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
	
	public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
	
	public static int knapSack(int W, int[] wt, int[] val, int n) {
	    int[][] K = new int[n + 1][W + 1];

	    for (int i = 0; i <= n; i++)
	        K[i][0] = 0;
	    for (int w = 0; w <= W; w++)
	        K[0][w] = 0;
        //0으로 초기화
        
	    for (int i = 1; i <= n; i++) {
	        for (int w = 1; w <= W; w++) {
	            if (wt[i - 1] > w) {
	                K[i][w] = K[i - 1][w];
	            } else {
	                K[i][w] = max(K[i - 1][w], (K[i - 1][w - wt[i - 1]] + val[i - 1]));
	            }
	        }
	    }
        
        int count = 0;
        int currentWeight = 0;//배낭의 현재 무게를 구하기 위한 변수
        int remainingWeight = W;//남은 무게

        for (int i = n; i > 0; i--) {
            if (K[i][remainingWeight] != K[i - 1][remainingWeight]) {
                count++;//배낭의 아이템이 채워질 때 마다 1개 씩 증가
                currentWeight += wt[i - 1];//현재 배낭에 아이템의 무게만큼 추가
                remainingWeight -= wt[i - 1];//배낭의 용량을 추가된 아이템의 무게만큼 감소
            }
        }
        
        System.out.println("배낭에 채워진 아이템의 수: "+count+"개");
		System.out.println("배낭의 현재 무게: "+currentWeight+"KG");
        
        return K[n][W];
    }
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
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
		
		    int[] val = new int[n];
	        int[] wt = new int[n];
	        
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
				   System.out.println();
			   }
	        
	        while(true) {
				   System.out.print("배낭의 용량: ");
				   W=in.nextInt();
				   System.out.println();
				   
				   if(W<50||W>100)
				   System.out.println("배낭의 용량을 50~100사이의 정수로 다시 입력해 주세요");
				   else
					   break;
			   }
	        
			int knapSack_value=knapSack(W, wt, val, n);
			System.out.println("배낭의 아이템의 총 가치: "+knapSack_value+"만원");
	}

}
