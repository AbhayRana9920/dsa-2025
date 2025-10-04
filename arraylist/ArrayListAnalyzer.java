import java.util.*;

public class ArrayListAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Input and Creation
        System.out.print("Enter size of ArrayList: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        System.out.println("\nOriginal ArrayList: " + list);

        // 2️⃣ Add and Insert Elements
        list.add(100); // Add at end
        list.add(1, 50); // Add at specific index
        System.out.println("After adding elements: " + list);

        // 3️⃣ Access and Update Elements
        System.out.println("Element at index 2: " + list.get(2));
        list.set(2, 999);
        System.out.println("After update: " + list);

        // 4️⃣ Remove Elements
        list.remove(1); // by index
        list.remove(Integer.valueOf(100)); // by value
        System.out.println("After removals: " + list);

        // 5️⃣ Search Elements
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        if (list.contains(key))
            System.out.println(key + " found at index " + list.indexOf(key));
        else
            System.out.println(key + " not found.");

        // 6️⃣ Sort and Reverse
        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        Collections.reverse(list);
        System.out.println("Reversed list: " + list);

        // 7️⃣ Find Max and Min
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Max: " + max + ", Min: " + min);

        // 8️⃣ Copy to Another List
        ArrayList<Integer> copy = new ArrayList<>(list);
        System.out.println("Copied list: " + copy);

        // 9️⃣ Check Equality
        System.out.println("Lists equal? " + list.equals(copy));

        // 🔟 Remove Duplicates using HashSet
        ArrayList<Integer> unique = removeDuplicates(list);
        System.out.println("After removing duplicates: " + unique);

        // 11️⃣ Frequency of Each Element
        countFrequency(list);

        // 12️⃣ Convert ArrayList to Array
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println("Converted to Array: " + Arrays.toString(arr));

        // 13️⃣ Convert Array to ArrayList
        ArrayList<Integer> fromArray = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Converted back to ArrayList: " + fromArray);

        // 14️⃣ SubList (Partial View)
        if (list.size() >= 3) {
            List<Integer> sub = list.subList(0, 3);
            System.out.println("SubList (0 to 2): " + sub);
        }

        // 15️⃣ Merge Two ArrayLists
        ArrayList<Integer> extra = new ArrayList<>(Arrays.asList(5, 10, 15));
        list.addAll(extra);
        System.out.println("After merging: " + list);

        // 16️⃣ Clear All Elements
        list.clear();
        System.out.println("After clear(), list = " + list);
    }

    // Helper: Remove duplicates
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Helper: Count frequency
    public static void countFrequency(ArrayList<Integer> list) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : list)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        System.out.println("Element Frequencies:");
        for (Map.Entry<Integer, Integer> e : freq.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());
    }
}
