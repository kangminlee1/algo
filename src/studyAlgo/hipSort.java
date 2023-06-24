package studyAlgo;

public class hipSort {
	
	static void downHeap(int[] arr,int heapSize, int i) {
		int left=2*i+1;
		int right=2*i+2;
		int largest=i;
		
		if(left<heapSize&&arr[left]>arr[largest])
			largest=left;
		if(right<heapSize&&arr[right]>arr[largest])
			largest=right;
		if(largest!= i) {
			int temp = arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			downHeap(arr, heapSize, largest);
		}
		
	}
	
	static void heapSorting(int[] arr, int n) {
		for(int i=n/2-1;i>=0;i--) {
			downHeap(arr,n,i);
		}
		for(int i=n-1;i>=0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			downHeap(arr, i, 0);
		}
	}
	

	public static void main(String[] args) {
		int[] arr= {50,40,80,90,70,10,30,100,20,60};
		
		heapSorting(arr, arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
