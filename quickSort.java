import java.util.Random;

public class quickSort {
	
	public static void sort(int[] arr, String pivotType) {
        
        quickssort(arr, 0, arr.length - 1, pivotType);
    }

    private static void quickssort(int[] arr, int left, int right, String pivotType) {// It partitions the array around a pivot element, and then recursively sorts the two resulting sub-arrays.
        if (left < right) {

        	int pivotIndex = choosePivot(arr, left, right, pivotType);// Choose the pivot element using the chosen pivot type
        	int partitionIndex = partition(arr, left, right, pivotIndex); // Partition the array around the pivot element

        	quickssort(arr, left, partitionIndex - 1, pivotType);// Recursively sort the sub-arrays
        	quickssort(arr, partitionIndex + 1, right, pivotType);// Recursively sort the sub-arrays
        }
    }

    private static int choosePivot(int[] arr, int left, int right, String pivotType) 
    {
        if (pivotType.equals("FirstElement")) //choose the first element as the pivot and return its index
        {
            return left;
        } 
        else if (pivotType.equals("RandomElement")) //choose a random element as the pivot, choose a random index within the range and return it
        {
            Random rand = new Random();
            return rand.nextInt(right - left)+ left;
        } 
        else if (pivotType.equals("MidOfFirstMidLastElement")) //choose the median of the first, middle, and last elements as the pivot, compute the median and return its index
        {
            int mid = (left + right) / 2;
            if ((arr[left] > arr[mid] && arr[left] < arr[right]) || (arr[left] < arr[mid] && arr[left] > arr[right])) 
            {
            	return left;
            }
            else if ((arr[mid] > arr[left] && arr[mid] < arr[right]) || (arr[mid] < arr[left] && arr[mid] > arr[right])) 
            {
            	return mid;
            }
            else
            	return right;
        }
        else
        	return -1;
    }
 // This method partitions the array around the pivot element, placing all elements smaller than the pivot to the left, and all elements larger than the pivot to the right.
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex]; // Assigning the value of arr[pivotIndex] to pivotValue
        swap(arr, pivotIndex, right);// Swaping the pivot element with the rightmost element to simplify the partitioning step
        int k = left;
        
        for (int i = left; i < right; i++) {//swapping any elements that are smaller than the pivot with the k
            if (arr[i] < pivotValue) {// Checking if the value of arr[i] is less than pivotValue
                swap(arr, i, k);// Swapping the values of arr[i] and arr[k] and incrementing k
                k++;
            }
        }
        swap(arr, k, right);
        return k;
    }

    
    private static void swap(int[] arr, int i, int j) {//
        int temp = arr[i];// Assigning the value of arr[i] to temp
        arr[i] = arr[j];// Swapping the values of arr[i] and arr[j]
        arr[j] = temp;
    }
}
	
	

