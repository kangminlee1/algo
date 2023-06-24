package studyAlgo;

public class selectionSort {
	
	static void selectionSorting(int[] arr) {
		int temp=0;
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j-1]>arr[j]) {
				temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
				}
				else break;
			}
		}
		
	}

	
	static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr= {10,50,60,70,40,30,20,80,100,90};
		
		selectionSorting(arr);
		
		printArray(arr);
		
	}

}
