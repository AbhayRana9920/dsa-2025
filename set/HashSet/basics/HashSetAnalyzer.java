package HashSet.basics;

import java.util.*;
import java.util.stream.Collectors;

public class HashSetAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Basic HashSet Operations ===");

        // 1️⃣ Create a HashSet
        HashSet<Integer> set = new HashSet<>();

        // 2️⃣ Add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // duplicate, will not be added
        set.add(null); // only one null allowed
        System.out.println("After adding elements: " + set);

        // 3️⃣ Remove an element
        set.remove(10);
        System.out.println("After removing 10: " + set);

        // 4️⃣ Check if element exists
        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Contains 50? " + set.contains(50));

        // 5️⃣ Check if set is empty
        System.out.println("Is set empty? " + set.isEmpty());

        // 6️⃣ Size of set
        System.out.println("Size of set: " + set.size());

        // 7️⃣ Iterate over set
        System.out.println("Iterating over set:");
        for (int x : set) System.out.println(x);

        // 8️⃣ Clear the set
        HashSet<Integer> tempSet = new HashSet<>(set); // save copy for later
        set.clear();
        System.out.println("After clear(): " + set);

        // ================= Advanced HashSet Operations =================
        System.out.println("\n=== Advanced HashSet Operations ===");

        set = new HashSet<>(tempSet); // restore elements

        // 1️⃣ AddAll (union)
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(40,50,60));
        set.addAll(set2);
        System.out.println("After addAll (union): " + set);

        // 2️⃣ removeAll (difference)
        set.removeAll(Arrays.asList(20,40));
        System.out.println("After removeAll (difference): " + set);

        // 3️⃣ retainAll (intersection)
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(30,50,70));
        set.retainAll(set3);
        System.out.println("After retainAll (intersection): " + set);

        // 4️⃣ Convert to List and sort
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("Sorted set elements: " + list);

        // 5️⃣ Remove elements conditionally
        set.removeIf(x -> x % 2 == 0); // remove even numbers
        System.out.println("After removeIf (remove even numbers): " + set);

        // 6️⃣ Clone / Copy
        HashSet<Integer> cloneSet = (HashSet<Integer>) set.clone();
        System.out.println("Cloned set: " + cloneSet);

        // 7️⃣ Convert to array
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println("Set converted to array: " + Arrays.toString(arr));

        // 8️⃣ Using Java Streams (filter)
        Set<Integer> filtered = set.stream()
                                   .filter(x -> x > 25)
                                   .collect(Collectors.toSet());
        System.out.println("Filtered set (>25): " + filtered);

        // 9️⃣ Convert to TreeSet (sorted set)
        TreeSet<Integer> tree = new TreeSet<>(set);
        System.out.println("TreeSet (sorted set): " + tree);

        // 🔟 Frequency count example (array -> HashMap)
        int[] arrInput = {10,20,30,20,10,30,30};
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int x : arrInput) freqMap.put(x, freqMap.getOrDefault(x,0)+1);
        System.out.println("Frequency map from array: " + freqMap);

        // 1️⃣1️⃣ Manual union / intersection / difference examples
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(2,3,4));

        // Manual union
        HashSet<Integer> union = new HashSet<>(a);
        for(int x : b) union.add(x);
        System.out.println("Manual union: " + union);

        // Manual intersection
        HashSet<Integer> intersection = new HashSet<>();
        for(int x : a) if(b.contains(x)) intersection.add(x);
        System.out.println("Manual intersection: " + intersection);

        // Manual difference
        HashSet<Integer> difference = new HashSet<>(a);
        for(int x : b) difference.remove(x);
        System.out.println("Manual difference: " + difference);
    }
}
