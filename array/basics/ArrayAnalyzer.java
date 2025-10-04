import java.util.*;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Input array
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));

        // 2️⃣ Sum and Average
        int sum = 0;
        for (int num : arr) sum += num;
        double avg = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        // 3️⃣ Find Max and Min
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Max: " + max + ", Min: " + min);

        // 4️⃣ Sort array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));

        // 5️⃣ Reverse array (two-pointer)
        int[] reversed = sorted.clone();
        for (int i = 0, j = reversed.length - 1; i < j; i++, j--) {
            int temp = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = temp;
        }
        System.out.println("Reversed Array: " + Arrays.toString(reversed));

        // 6️⃣ Linear Search
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Found (Linear Search) at index " + i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found (Linear Search)");

        // 7️⃣ Binary Search (on sorted array)
        int pos = Arrays.binarySearch(sorted, key);
        if (pos >= 0)
            System.out.println("Found (Binary Search) at index " + pos + " in sorted array");
        else
            System.out.println("Not found (Binary Search)");

        // 8️⃣ Copy array
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copied Array: " + Arrays.toString(copy));

        // 9️⃣ Check equality
        System.out.println("Arrays equal? " + Arrays.equals(arr, copy));

        // 🔟 Remove Duplicates (for sorted array)
        int[] unique = removeDuplicates(sorted);
        System.out.println("Array without Duplicates: " + Arrays.toString(unique));

        // 11️⃣ Find Second Largest Element
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second Largest Element: " + secondLargest);

        // 12️⃣ Missing Number (1–n+1 range)
        if (isSequential(arr)) {
            int missing = findMissingNumber(arr);
            System.out.println("Missing Number: " + missing);
        } else {
            System.out.println("Skipping missing number (array not sequential 1–n)");
        }
    }

    // Helper: Remove duplicates (for sorted array)
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return arr;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) arr[++j] = arr[i];
        }
        return Arrays.copyOf(arr, j + 1);
    }

    // Helper: Second largest
    public static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second && x != first) {
                second = x;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }

    // Helper: Check if array is sequential (1 to n)
    public static boolean isSequential(int[] arr) {
        for (int x : arr)
            if (x <= 0) return false;
        return true;
    }

    // Helper: Find missing number from 1–n range
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        for (int x : arr) total -= x;
        return total;
    }
}
