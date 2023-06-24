
public class BubbleSortEx {
	public static void BubbleSorting(int A[]) {

		   int temp = 0; 
		   int chg=0;
		   
		   for(int i =0; i <A.length; i++) {
		       chg=0;
		       for(int j=0;j<A.length-i-1;j++) {
		         if (A[j] > A[j+1])
		         {
		            temp       = A[j];
		            A[j]   = A[j+1];
		            A[j+1] = temp;
		            chg=1;
		         }
//			       if(chg==1) {
//			    	   printArray(A);
//			       }모든 과정 보일 때

		       }
		       if(chg==1) {
		    	   printArray(A);
		       }
		}
	}
	
	public static void printArray(int A[]) {
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		  int i;
		    int array[] = { 90, 20, 70, 60,55, 32, 47, 12, 88, 59};
		     
		    System.out.println("Before sorting : ");
		    for(i = 0; i < array.length; i++) 
		      System.out.print(array[i]+" ");
		    System.out.println();
		    
		    System.out.println();
		    BubbleSorting(array);
		    System.out.println();
		    System.out.println("After sorting : ");
			 
		    for (i = 0; i < array.length; i++) 
		      System.out.print(array[i]+" ");

	}

}
