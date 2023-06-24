package studyAlgo;

public class bubleSort {
	
	static void bubleSorting(int[] arr) {
		int temp;
		int chg;
		
		for(int i=0;i<arr.length;i++) {
			chg=0;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					chg=1;
				}
//			       if(chg==1) {
//		    	   printArray(A);
//		       }모든 과정 보일 때
			}
			if(chg==1)
				printArray(arr);
		}
		
	}
	static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int array[] = { 90, 20, 70, 60,55, 32, 47, 12, 88, 59};
	     
	    System.out.println("Before sorting : ");
	    for(int i = 0; i < array.length; i++) 
	      System.out.print(array[i]+" ");
	    System.out.println();
	    
	    System.out.println();
	    bubleSorting(array);
	    System.out.println();
	    System.out.println("After sorting : ");
		 
	    for (int i = 0; i < array.length; i++) 
	      System.out.print(array[i]+" ");

	}

}
