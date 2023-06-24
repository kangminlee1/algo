import java.util.Scanner;

public class MargeSortEx {
	static int[] target=new int[10];
	static int[] temp=new int[10];

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.print("정수 10개 입력: ");
		for(int i=0;i<10;i++) {
			target[i]=in.nextInt();
		}
		
		System.out.println("--------------------");
		System.out.print("정렬되기 전 숫자는 ");
		for(int i=0;i<10;i++) {
			System.out.print(target[i]+", ");
		}
	
		System.out.println();
		System.out.println("--------------------");
		System.out.print("정렬 된 이후에 수는 ");
		
		MergeSort(10, 0, 9); 
		   for (int i=0; i < 10; i++) { 
		      System.out.print(target[i]+", "); 
		   } 
		
		

	}
	static void Merge(int size, int s, int m, int e) {
		for(int i=s; i<=e;i++) 
			temp[i]=target[i];
				
			int tempLeft=s;
			int tempRight= m+1;
			int current=s;
			
			while(tempLeft<=m && tempRight <=e) {
				if (temp[tempLeft] <= temp[tempRight]) 
			      { 
			         target[current] = temp[tempLeft]; 
			         tempLeft++; 
			      } else { 
			           target[current] = temp[tempRight]; 
			           tempRight++; 
			      } 
			      current++; 
			   } 
			   int remaing = m - tempLeft; 
			   for (int i = 0; i <= remaing; i++) 
			   { 
			       target[current + i] = temp[tempLeft + i]; 
			   } 
	
	}
	
	static void MergeSort(int size, int s, int e) 
	{ 
	   if (s < e) { 
	      int m = (s + e) / 2; 
	      MergeSort(m - s + 1, s, m); 
	      MergeSort(e - m, m + 1, e); 
	      Merge(size, s, m, e); 
	   } 

	} 

}
