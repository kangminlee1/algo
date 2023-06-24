
import java.util.Scanner;

public class GreedyEx {
	static int[] coin= {500, 100, 50, 10};
	static int[] count=new int[4];
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m, i=0, sum = 0;
		boolean f=false;
		
		System.out.println("투입할 금액을 입력해 주세요");
		int insert=in.nextInt();
		
		System.out.println("상품의 금액을 입력해 주세요");
		int price=in.nextInt();
		
		m=insert-price;
		
		System.out.println("거스름돈의 액수는 "+m+"원입니다.");
		
//		System.out.println();
//		System.out.print("거스름돈을 입력하시오");
//		m=in.nextInt();
		
		while(i<4) {
			if(coin[i]>m)
				i++;
			else if(coin[i]<m) {
				m -= coin[i];
				count[i]++;
			}else {
				f=true;
				count[i]++;
				break;
			}
		}
		for(i=0;i<4;i++) {
			sum +=count[i];
		}
		
		if(f) {
		System.out.println(coin[0]+"원 동전은 "+count[0]+"개, "+coin[1]+" 원 동전은 "+count[1]+"개"+coin[2]+" 원 동전은 "+count[2]+"개"+coin[3]+" 원 동전은 "+count[3]+"개");
		int totalCount=0;
		for(i=0;i<4;i++) {
			totalCount+=count[i];
		}
		System.out.println("전체 동전 개수는 "+totalCount+"개 입니다.");
		}else
		System.out.println("해답을 구할 수 없습니다.");
	}

}
