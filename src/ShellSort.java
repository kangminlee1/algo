
public class ShellSort {

	/* function to sort arr using shellSort */
	   int sort(int arr[])
	   {
	      int n = arr.length;
	      // Start with a big gap, then reduce the gap
	     for (int gap = n/2; gap > 0; gap /= 2)
	     {
	         for (int i = gap; i < n; i += 1)
	         {
	            int temp = arr[i];
	            int j;
	            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
		arr[j] = arr[j - gap];

	             // put temp (the original a[i]) in its correct
	             // location
		arr[j] = temp;
	         }
	     }
	     return 0;
	   } 
	   static void printArray(int arr[])
	   {

		      int n = arr.length;
		      for (int i=0; i<n; ++i)
		         System.out.print(arr[i] + " ");

		      System.out.println();

		   }
		 // Driver method
		   public static void main(String args[])
		   {
			int arr[] = {33,10,2,4,20,35,12,3,71,54};
			System.out.println("Array before sorting");
			printArray(arr);
			ShellSort ob = new ShellSort();
			ob.sort(arr);
			System.out.println("Array after sorting");
			printArray(arr);
		   }
		}
