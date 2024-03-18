
public class mergeSort {
	
	public static void sort(int[] arr, String numberOfPartitions) {
        
        if (numberOfPartitions.equals("twoparts")) 
        {
            sortTwoParts(arr, 0, arr.length - 1);
        } 
        else if (numberOfPartitions.equals("threeparts")) 
        {
            sortThreeParts(arr, 0, arr.length - 1);
        }
    }
    
    private static void sortTwoParts(int[] arr, int left, int right) {
        if (left < right) { // if the array has at least two element 
            int mid = left + (right - left) / 2;// calculate mid index
            sortTwoParts(arr, left, mid); // divide and sort left sub array again
            sortTwoParts(arr, mid + 1, right); // divide and sort right sub array again
            merge1(arr, left, mid, right); // merge two subarrau
        }
    }
    
    private static void sortThreeParts(int[] arr, int left, int right) {
    	if (right - left < 2) { //If the length of the sub array is less than 2, then the array is already sorted and the method returns.
            return;
        }
        int mid1 = left + ((right - left) / 3);
        int mid2 = left + 2 * ((right - left) / 3) + 1;//Divide the sub-array into three parts using the first and second midpoints.
        
        
        sortThreeParts(arr, left, mid1);
        sortThreeParts(arr, mid1, mid2);
        sortThreeParts(arr, mid2, right);//Recursive merge sort on three sub arrays.
        
        merge2(arr, left, mid1, mid2, right); //Merge three sorted subarrays.
    }
    
    private static void merge1(int[] arr, int left, int mid, int right)
    {
        int n1 = mid - left + 1; // find the left sub array size
        int n2 = right - mid; //  find the right sub array size
        int[] leftArr = new int[n1]; // creating the temp array for left subarray
        int[] rightArr = new int[n2]; // creating the temp array for right subarray
        
        for (int i = 0; i < n1; ++i) 
        {
            leftArr[i] = arr[left + i]; // copying data to temp array
        }
        for (int j = 0; j < n2; ++j) 
        {
            rightArr[j] = arr[mid + 1 + j]; // copying data to temp array
        }
        int i = 0, j = 0;// Initial indexes of first and second subarrays
        int k = left;
        while (i < n1 && j < n2) // compare and merge the left and right subarrays
        {
            if (leftArr[i] <= rightArr[j]) 
            {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1)  // Copy remaining elements of leftarr if any
        { 
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) // Copy remaining elements of rightarr if any
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    private static void merge2(int[] arr, int left, int mid1, int mid2, int right) {
    	
    	int[] temp = new int[right - left]; //Creating a temporary array to store the sorted elements.
        int i = left, j = mid1, k = mid2, x = 0;  //initializing variables to traverse the sub arrays.
       
        while (i < mid1 && j < mid2 && k < right) //While all three sub-arrays have elements, compare the smallest elements and add them to the temporary array.
        {
            if (arr[i] < arr[j]) 
            {
                if (arr[i] < arr[k]) { //Compare the smallest element between sub-arrays and add it to the temporary array.
                    temp[x++] = arr[i++];
                } else {
                    temp[x++] = arr[k++];
                }
            } 
            else 
            {
                if (arr[j] < arr[k]) {
                    temp[x++] = arr[j++];
                } else {
                    temp[x++] = arr[k++];
                }
            }
        }
        while (i < mid1 && j < mid2) {  // handle the case where there are elements remaining in only two of the sub-ranges. 
            if (arr[i] < arr[j]) {		//simply add any remaining elements to the temporary array
                temp[x++] = arr[i++];
            } else {
                temp[x++] = arr[j++];
            }
        }
        while (j < mid2 && k < right) { // handle the case where there are elements remaining in only two of the sub-ranges. 
            if (arr[j] < arr[k]) {		//simply add any remaining elements to the temporary array
                temp[x++] = arr[j++];
            } else {
                temp[x++] = arr[k++];
            }
        }
        while (i < mid1 && k < right) {// handle the case where there are elements remaining in only two of the sub-ranges. 
            if (arr[i] < arr[k]) {      //simply add any remaining elements to the temporary array
                temp[x++] = arr[i++];
            } else {
                temp[x++] = arr[k++];
            }
        }
        while (i < mid1) {  //Adding remaining elements from a single sub-array.
            temp[x++] = arr[i++];
        }
        while (j < mid2) { //Adding remaining elements from a single sub-array.
            temp[x++] = arr[j++];
        }
        while (k < right) { //Adding remaining elements from a single sub-array.
            temp[x++] = arr[k++];
        }
        for (i = left; i < right; i++) { //Copy the sorted elements from the temporary array to the original array.
            arr[i] = temp[i - left];
        }
    }
    
    
}
