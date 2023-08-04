/**
 * Sorting demonstrates sorting and searching on an array 
 * of objects.
 *
 * @author Java Foundations
 * @version 4.0 
 */
import java.util.Arrays;
public class Sorting 
{
	/**
	 * Sorts the specified array of integers using the selection
	 * sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void selectionSort(T[] data)
	{
		int min;
		T temp;

		for (int index = 0; index < data.length - 1; index++)
		{
			min = index;
			for (int scan = index + 1; scan < data.length; scan++)
				if (data[scan].compareTo(data[min]) < 0)
					min = scan;

			swap(data, min, index);
		}
	}

	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
	void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	/**
	 * Sorts the specified array of objects using an insertion
	 * sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void insertionSort(T[] data)
	{
		for (int index = 1; index < data.length; index++)
		{
			T key = data[index];
			int position = index;

			// shift larger values to the right 
			while (position > 0 && data[position-1].compareTo(key) > 0)
			{
				data[position] = data[position - 1];
				position--;
			}

			data[position] = key;
		}
	}

	/**
	 * Sorts the specified array of objects using a bubble sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void bubbleSort(T[] data)
	{
		int position, scan;
		int compareCounter = 0;
		int swapCounter = 0;

		for (position =  data.length - 1; position >= 0; position--)
		{
			for (scan = 0; scan <= position - 1; scan++)
			{
				compareCounter++;
				if (data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);
					swapCounter++;
			}
		}
		System.out.println("Comparisons: " + compareCounter);
		System.out.println("Swaps: " + swapCounter);
	}
	
	public static <T extends Comparable<T>> 
	void shellSort(T[] data) //array of objects 
    {
		int pass = 0;
		int gap; //initialize gap
		int size = data.length; // set size equal to the legth of the array of objects data
		gap = size/2; // initalize gap = size/2
		//System.out.println("gap "+ gap);
		
		int compareCounter = 0;
		int swapCounter = 0;
		boolean swapflag;
		
		do {
			swapflag = true; // initalize boolean variable swapflag to true
			do {
				swapflag = false; // do until swap flag is false
				for (int s = 0; s < (size - gap); s++){ //when scan is less than size of the gap
					if (data[s].compareTo(data[s + gap]) > 0){ //if the s posistion number of the data is less than the 
						swap(data, s, s + gap);
						swapflag = true;
						swapCounter++;
					}
					compareCounter++;//Everttune the loop runs, compareTo is called
				}
				pass ++;//a pass is made per for loop
				System.out.println("Array After This Pass: " + "#" + pass+ "  " + Arrays.toString(data));// Include an output of the array any time a swap occurs to demonstrate that your code works correctly
			} while (swapflag == true);
			gap = gap/2;
		} while (gap > 0);
        System.out.println("Array After Sorting: " + Arrays.toString(data)); 
		System.out.println("Comparisons: " + compareCounter);
		System.out.println("Swaps: " + swapCounter);
		//System.out.println("pass: " + pass);
	}

	/* - stop when the list is sorted
	 * - include outputs of the array for each pass
	 * - driver test both methods with set of 10 integers, and 10 sorted sets of 10 integers
	 */
	public static <T extends Comparable<T>> 
	void bubbleSort2(T[] data) 
	{
		int position = data.length-1; //the highest possible in the array 
		int scan = 0;
		int swapCounter = 0;
		int compareCounter =0;
		//int pass = 0;// explained in bubbleSort
		//for (position =  data.length - 1; position >= 0; position--)
		boolean swapflag = true; // introducing swapflag for the while loop
		do{ //changing the for loop in the example code into while loop enables swap flag check, which enables the code to stop after sorted
			swapflag = false;//set swap flag to false such that if no swap occurs, no more while loops will run

			for (scan = 0; scan <= position - 1; scan++){
				compareCounter++; //everytime loop runs if statement, compareTo is called

				if (data[scan].compareTo(data[scan + 1]) > 0){
					swap(data, scan, scan + 1);
					swapflag = true;
					swapCounter++;
				}
			}
			//pass++; //count up after each pass through the array

			position--;
		} while (swapflag == true && position >= 0);

		System.out.println("Array After Sorting: " + Arrays.toString(data));
		System.out.println("Comparisons: " + compareCounter);
		System.out.println("Swaps: " + swapCounter);
		//System.out.println("Pass: " + pass);
		
	}
	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void quickSort(T[] data)
	{
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm. 
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> 
	void quickSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max);

			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);

			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> 
	int partition(T[] data, int min, int max)
	{
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		// use the middle data value as the partition element
		partitionelement = data[middle];
		
		// move it out of the way for now
		swap(data, middle, min);

		left = min;
		right = max;

		while (left < right)
		{
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
				left++;

			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
				right--;

			// swap the elements
			if (left < right)
				swap(data, left, right);
		}

		// move the partition element into place
		swap(data, min, right);

		return right;
	}
	
	/**
	 * Sorts the specified array of objects using the merge sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>>
	void mergeSort(T[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
	 *
	 * @param data the array to be sorted
	 * @param min  the index of the first element 
	 * @param max  the index of the last element
	 */
	private static <T extends Comparable<T>>
	void mergeSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid + 1, max);
			merge(data, min, mid, max);
		}
	}

	/**
	 * Merges two sorted subarrays of the specified array.
	 *
	 * @param data the array to be sorted
	 * @param first the beginning index of the first subarray 
	 * @param mid the ending index fo the first subarray
	 * @param last the ending index of the second subarray
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
	void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);

		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid + 1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array

		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}

		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}

		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}

		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
	}
}


