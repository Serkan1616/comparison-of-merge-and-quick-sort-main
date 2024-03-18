import java.util.Iterator;
import java.util.Random;

public class SortingClass {

	public static void main(String[] args) {
		
		String[] arrType = {"equal", "random", "increasing", "decreasing"};
		String[] mergeParts = {"twoparts", "threeparts"};
		String[] quickParts = {"FirstElement", "RandomElement", "MidOfFirstMidLastElement"};
		int[] size = new int[]{1000, 10000, 100000};
		
		
		for (int i = 0; i < arrType.length; i++) {//that for loops uses all types and sizes arrays and merge sort algorithm requirements and write to console
		    String type = arrType[i];
		    for (int j = 0; j < mergeParts.length; j++) {
		        String parts = mergeParts[j];
		        for (int k = 0; k < size.length; k++) {
		            int n = size[k];
		            estimatedtimeforMerge(n, type, parts);
		        }
		    }
		}
		System.out.println();
		
		for (int i = 0; i < arrType.length; i++) {//that for loops uses all types and sizes arrays and quick sort algorithm requirements and write to console
		    String type = arrType[i];
		    for (int j = 0; j < quickParts.length; j++) {
		        String parts = quickParts[j];
		        for (int k = 0; k < size.length; k++) {
		            int n = size[k];
		            estimatedtimeforQuick(n, type, parts);
		        }
		    }
		}
		
	}
	
	public static void estimatedtimeforMerge(int size, String type, String mergeType) //this method calculate the estimated time for merge sort
	{
		mergeSort m = new mergeSort();
		int arr[] = arrimplement(size, type); // array producing according to size and type
		double startTime = System.nanoTime();
		m.sort(arr, mergeType); // merge sort algorithm
		double finish = System.nanoTime();
		double estimatedTime = (finish - startTime) ;
		System.out.println("merge-" + mergeType + "-" + type + "-" + size + ": "+ estimatedTime / 1000000);
	}
	public static void estimatedtimeforQuick(int size, String type, String mergeType) //this method calculate the estimated time for quick sort
	{
		quickSort q = new quickSort();
		int arr[] = arrimplement(size, type);// array producing according to size and type
		double startTime = System.nanoTime();
		q.sort(arr, mergeType); //quick sort algorithm
		double finish = System.nanoTime();
		double estimatedTime = (finish - startTime) ;
		System.out.println("quick-" + mergeType + "-" + type + "-" + size + ": "+ estimatedTime /1000000);
	}
	
	public static int[] arrimplement(int size, String type)//this method produce arrays accoridng to types and sizes
	{
		Random random = new Random();
		if (type == "equal") { // if type is equal all array elements are equal
			int[] arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 5;
			}
			return arr;
		}
		else if (type == "random") { //if type is random all array elements are randomly chosen
			int[] arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = random.nextInt();
			}
			return arr;
		}
		else if (type == "increasing") {// if type is increasing array elements are increasing 
			int[] arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			return arr;
		}
		else if (type == "decreasing") {// if type is increasing array elements are decreasing 
			int[] arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = size--;
			}
			return arr;
		}
		else
			return null;
	}
	
	
	
	
 }
