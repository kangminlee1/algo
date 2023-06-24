import java.util.Scanner;
public class IsertionSortEX {
	/**
	   1. 기준을 2번째 index로 잡는다.
	   2. 기준이 되는 값과 바로 이전 값과 비교
	   3. 이전 값이 더 크다면 index가 0~이전 index의 값과 
	      비교하여 들어갈 자리를 찾는다.
	   */

	  public static void InsertionSort(int A[]) {
	    int i, j, key; 
	    for(j=1; j< A.length; j++){
	      key = A[j];
	      i= j-1;
	      while(i>=0 && A[i]>key ){ 
	      // 바로 이전값이 더 크다면 0~이전index값 비교
	        A[i+1] = A[i];
	        i = i-1;//index가 0인 자리까지 찾기위해 i-1을 해준다.
	      }
	      A[i+1] = key;
	    }
	 }


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		  int i;
		    int array[] = new int[10];
		     
		    System.out.println("Unsorted list of numbers : ");
		    for(i = 0; i < array.length; i++) 
		      array[i]=in.nextInt();

		    System.out.println();
		    InsertionSort(array);
		 
		    System.out.println("Sorted list of numbers");
		 
		    for (i = 0; i < array.length; i++) 
		      System.out.println(array[i]);
		  }
		}

