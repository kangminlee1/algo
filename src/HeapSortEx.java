
public class HeapSortEx {

	public void sort(int arr[])
	{
		int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            //printArray(arr);
            }
            
	 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
           // Move current root to end
	       int temp = arr[0];
	       arr[0] = arr[i];
	       arr[i] = temp;
	       // call max heapify on the reduced heap
           heapify(arr, i, 0);
        }
    }
// To heapify a subtree rooted with node i which is
// an index in arr[]. n is size of heap
// To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
	 
        if (l < n && arr[l] > arr[largest])  // If left child is larger than root
            largest = l;
 
        if (r < n && arr[r] > arr[largest]) // If right child is larger than largest so far
            largest = r;
	 
        if (largest != i) // If largest is not root
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);  // Recursively heapify the affected sub-tree 
        }
    }
   static void printArray(int arr[]) /* A utility function to print array of size n */
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

	public static void main(String[] args) {
		 int arr[] = {9,4,3,10,5,8,7,6,2,1};
	        //int n = arr.length;
	 
	        HeapSortEx ob = new HeapSortEx();
	        ob.sort(arr);
	 
	        System.out.println("Sorted array is");
	        printArray(arr);
	    }
}
