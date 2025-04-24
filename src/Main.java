// This program generates 10,000 random numbers between 1 and 100, sorts them using merge sort, and displays the result.

public class Main {

    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000); // Generate random numbers
        mergesort(numbers, 0, numbers.length - 1); // Sort the numbers using merge sort
        display(numbers); // Display the sorted numbers
    }

    // Generate an array filled with random integers between 'low' and 'high'
    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = low + (int)(Math.random() * (high - low + 1));
        }
        return result;
    }

    // Recursive merge sort function
    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            // Sort the left and right halves
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);

            // Merge the sorted halves
            merge(a, low, mid, high);
        }
    }

    // Merge two sorted subarrays back into the original array
    public static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) left[i] = a[low + i];
        for (int j = 0; j < n2; j++) right[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = low;

        // Merge temp arrays back into a[]
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) a[k++] = left[i++];
        while (j < n2) a[k++] = right[j++];
    }

    // Display all elements in the array
    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if ((i + 1) % 10 == 0) 
            System.out.println(); // print 10 numbers per line 
        }
    }
    
    
}
