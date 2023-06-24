import java.util.Scanner;

public class QuickSortEx {

	public static final int MAX=10;//C언어에서 #define Max 10이랑 같음
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] A=new int[MAX];
		for(int i=0;i<MAX;i++) {
			A[i]=in.nextInt();
		}
		System.out.println("정렬 되기 전 상태 출력");
	
		printArray(A);
		QuickSort(A, 0, MAX-1);
		System.out.println("정렬");
		printArray(A);
		
		
	}
	
	static void QuickSort(int A[], int start, int end) {
		int L =start, R=end;
		int temp;
		int pivot=A[(start + end)/2];//피벗 위치의 값을 받음
		
		while(L<=R) {
			//피벗이 중간 값이고 비교 대상 arr[L], arr[R]은 피벗과 비교하니
			//중간 지점을 넘어가면 종료로 볼 수 있음
			while(A[L]<pivot)
				L++;//left부터 증가하며 pivot 이상의 값을 찾음.

			while(A[R]>pivot)
				R--; //right부터 감소하며 pivot 이하 값을 찾음.
			 //L, R 모두 최대 pivot 위치까지 이동.
			
			
			if(L<=R) {
				if(L!=R) {//같지 않은 경우만.
					temp=A[L];
					A[L]=A[R];
					A[R]=temp;
				}//L과 R이 같다면 교환(SWAP)은 필요 없고 한 칸씩 진행만 해주면 됨.
				L++;
				R--;
				//그리고 L, R 한칸 더 진행
			}
		}
		//조건 확인하여 재귀 함수로
		if(start<R)
			QuickSort(A, start, R);
		if(L<end)
			QuickSort(A, L, end);
	}
	
	static void printArray(int A[]) //배열의 원소값을 출력
	{
		for(int i=0; i<MAX;i++) {
			System.out.print(A[i]+" ");
		}
		
		System.out.println();
	}

}
