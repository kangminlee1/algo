
public class SelectionSortEx {
	public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            int chg;
            chg=0;
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
                if(index!=i) {
                	chg=1;
                }
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber; 
            
            if(chg==1) {
            	printArray(arr);
            }
        }  

    }  
	
	public static void printArray(int[] arr) {
		for(int k=0;k<arr.length;k++) {
        	//if(arr[k]==k+1)
        	System.out.print(arr[k]+" ");
        }
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr1 = { 9,4,3,10,5,8,7,6,2,1 };  
	        System.out.println("Before Selection Sort");  
	        for(int i:arr1){  
	            System.out.print(i+" ");  
	        }  
	        System.out.println(); 
	        System.out.println(); 
	          
	        selectionSort(arr1);
	 
	        System.out.println("After Selection Sort");  
	        for(int i:arr1){  
	            System.out.print(i+" ");  
	        }  
	    }  
	}
