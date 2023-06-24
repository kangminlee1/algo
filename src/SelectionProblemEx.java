import java.util.Scanner;

public class SelectionProblemEx {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		 int n, index, value;  // n:A size, index: k, value: 탐색된 값 
		   int[] A;
		   System.out.print("배열의 크기를 입력하시오 : ");
		   n=in.nextInt();

		   A=new int[n];
		  // A = (int*)malloc(sizeof(int)*n);
		   System.out.print("배열의 원소를 입력하시오 : ");
		   for (int i = 0; i<n; i++) {
			   A[i]=in.nextInt();
		       //scanf("%d", (A + i));
		   }
		  while(true) {
		   System.out.print("몇 번째의 원소를 찾으십니까? : ");
		   index=in.nextInt();
//		   scanf("%d", &index);
		   
		   if(index>n || index<1) {
			   System.out.println("입력된 원소의 범위를 벗어납니다. 다시 입력해주세요");
		   }else {
			   print_result(A,n, index);
			   break;
		   }
		  }
	}
	static int Partition(int A[], int start, int end)
	{
	    //기본적으로 quicksort의 pivot 선정 후 교환 과정과 동일
	   //본 예제에서 pivot은 가장 왼쪽의 인덱스를 사용하기로 함

	   int pivot = A[start];
	   int low = start + 1, high = end;
	   int temp = 0;
	   while (low <= high)
	   {
	      while (low <= end && A[low] >= pivot)
	      {
	         low++;
	      }
	      while (high >= (start + 1) && A[high] <= pivot)
	      {
	         high--;
	      }
	      if (low <= high)
	      {
	         temp = A[low];
	         A[low] = A[high];
	         A[high] = temp;
	      }
	   }
	   temp = A[start];
	   A[start] = A[high];
	   A[high] = temp;

	   return high;
	}
	static int select_Prob(int A[], int start, int end, int select) {
		//찾고자 하는 인덱스가 범위 내에 존재할 경우
		   if (select > 0 && select <= end - start + 1) {
		      int pos = Partition(A, start, end);

		      if (pos - start == select - 1) {            //찾고자 하는 숫자를 찾은 경우
		         return A[pos];
		      }
		      else if (pos - start > select - 1) {      //찾고자 하는 숫자가 small group에 존재
		         return select_Prob(A, start, pos - 1, select);
		      }
		      else {                                            //찾고자 하는 숫자가 large group에 존재
		         return select_Prob(A, pos + 1, end, select - pos + start - 1);
		      }
		   }
		   return -1; // 탐색 실패했을 경우
		}
	static void print_result(int A[], int n, int index) {
		int value = select_Prob(A, 0, n - 1, index);
		System.out.println("찾고자 하는 "+index+ "번째 크기의 원소의 값은 "+value+" 입니다. ");
	}
}
