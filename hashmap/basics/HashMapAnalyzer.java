package basics;
import java.util.*;

public class HashMapAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println("=== Basic HashMap Operations ===");

        // 2️⃣ Add / Put key-value pairs
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(null, "NullKey"); // null key allowed
        map.put(4, null);         // null value allowed
        System.out.println("After adding entries: " + map);

        // 3️⃣ Access values (get, getOrDefault)
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 5 (default): " + map.getOrDefault(5, "Not Found"));

        // 4️⃣ Remove entries
        map.remove(1); // remove by key
        map.remove(3, "Charlie"); // remove by key-value pair
        System.out.println("After removals: " + map);

        // 5️⃣ Check if key/value exists
        System.out.println("Contains key 2? " + map.containsKey(2));
        System.out.println("Contains value 'Alice'? " + map.containsValue("Alice"));

        // 6️⃣ Size and empty check
        System.out.println("Size of map: " + map.size());
        System.out.println("Is map empty? " + map.isEmpty());

        // 7️⃣ Iterate over map
        System.out.println("Iterate keys:");
        for (Integer k : map.keySet()) System.out.println(k);

        System.out.println("Iterate values:");
        for (String v : map.values()) System.out.println(v);

        System.out.println("Iterate entries (key -> value):");
        for (Map.Entry<Integer, String> e : map.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());

        // Clear map
        map.clear();
        System.out.println("After clear(): " + map);

        // ================= Advanced Methods =================
        System.out.println("\n=== Advanced HashMap Operations ===");

        // Re-add entries for advanced examples
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(4, "David");
        System.out.println("Map reset: " + map);

        // 1️⃣ putIfAbsent
        map.putIfAbsent(2, "NewBob"); // won't overwrite existing
        map.putIfAbsent(5, "Eve");    // adds new
        System.out.println("After putIfAbsent: " + map);

        // 2️⃣ replace / replaceAll
        map.replace(1, "AliceReplaced");
        map.replaceAll((k,v) -> v.toUpperCase());
        System.out.println("After replaceAll: " + map);

        // 3️⃣ compute / computeIfAbsent / computeIfPresent
        map.compute(2, (k,v) -> v + "_COMPUTED"); 
        map.computeIfAbsent(6, k -> "Frank"); 
        map.computeIfPresent(3, (k,v) -> v + "_UPDATED"); 
        System.out.println("After compute operations: " + map);

        // 4️⃣ merge
        HashMap<Integer, String> extra = new HashMap<>();
        extra.put(2, "Extra2");
        extra.put(7, "Extra7");
        for(Map.Entry<Integer,String> e : extra.entrySet()) {
            map.merge(e.getKey(), e.getValue(), (oldV,newV) -> oldV + "+" + newV);
        }
        System.out.println("After merge: " + map);

        // 5️⃣ removeIf
        map.entrySet().removeIf(e -> e.getValue().contains("EXTRA"));
        System.out.println("After removeIf condition: " + map);

        // 6️⃣ Clone / Copy
        HashMap<Integer, String> cloneMap = (HashMap<Integer,String>) map.clone();
        System.out.println("Cloned map: " + cloneMap);

        // 7️⃣ Sorting by key and value (optional)
        System.out.println("Sorted by keys:");
        map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(System.out::println);

        System.out.println("Sorted by values:");
        map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);

        // 8️⃣ Frequency Count Example
        int[] arr = {1,2,2,3,1,3,3};
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int x : arr) freqMap.put(x, freqMap.getOrDefault(x,0)+1);
        System.out.println("Frequency Map: " + freqMap);
    }
}
