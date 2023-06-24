import java.util.Scanner;
public class DynamicEx {
	static int[] memo=new int[50];
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		
		System.out.println("알고싶은 피보나치 수를 입력해주세요");
		int n=in.nextInt();
		
		int fibonachi= fib(n);
		System.out.println(fibonachi+" 입니다.");
		

	}

	static int fib(int n) {
		int i;
		memo[0]=0;
		memo[1]=1;
		memo[2]=1;
		for(i=3;i<=n;i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		return memo[i-1];
	}

}

//System.out.println("피보나치 수의 개수를 입력해주세요");
//int num=in.nextInt();
//memo=new int[num];


//static int fib(int n) {
//memo[0]=0;
//memo[1]=1;
//memo[2]=1;
//for(int i=3;i<=n;i++) {
//	memo[i]=memo[i-1]+memo[i-2];
//}
//return memo[n];
//}