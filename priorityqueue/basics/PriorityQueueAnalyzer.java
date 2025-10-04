package basics;
import java.util.*;

public class PriorityQueueAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== PriorityQueue Analyzer ===");

        // 1️⃣ Input elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-Heap by default
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) pq.add(sc.nextInt());

        System.out.println("\nOriginal PriorityQueue (Min-Heap): " + pq);

        // 2️⃣ Peek
        System.out.println("Peek (smallest element): " + pq.peek());

        // 3️⃣ Poll (remove smallest)
        int removed = pq.poll();
        System.out.println("Poll (removed): " + removed);
        System.out.println("After poll: " + pq);

        // 4️⃣ Check contains
        System.out.print("Enter element to check contains: ");
        int key = sc.nextInt();
        System.out.println("Contains " + key + "? " + pq.contains(key));

        // 5️⃣ Size / isEmpty
        System.out.println("Size: " + pq.size());
        System.out.println("Is empty? " + pq.isEmpty());

        // 6️⃣ Remove specific element
        System.out.print("Enter element to remove: ");
        int rem = sc.nextInt();
        boolean removedSpecific = pq.remove(rem);
        System.out.println("Removed? " + removedSpecific);
        System.out.println("After removal: " + pq);

        // 7️⃣ Clear PQ
        PriorityQueue<Integer> pqCopy = new PriorityQueue<>(pq); // backup
        pq.clear();
        System.out.println("After clear(): " + pq);

        // 8️⃣ Max-Heap using Comparator
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.addAll(pqCopy);
        System.out.println("Max-Heap PriorityQueue: " + maxPQ);
        System.out.println("Peek (largest): " + maxPQ.peek());
        System.out.println("Poll (remove largest): " + maxPQ.poll());
        System.out.println("After poll: " + maxPQ);

        // 9️⃣ Bulk add
        System.out.println("Adding extra elements: 5, 50, 25");
        maxPQ.addAll(Arrays.asList(5, 50, 25));
        System.out.println("After addAll: " + maxPQ);

        // 🔟 Convert to List and sort
        List<Integer> sortedList = new ArrayList<>(maxPQ);
        Collections.sort(sortedList); // ascending
        System.out.println("Converted to sorted List (ascending): " + sortedList);
        Collections.reverse(sortedList);
        System.out.println("Reversed List (descending): " + sortedList);

        // 11️⃣ Frequency Count Example
        System.out.println("\nFrequency count example using PQ input array");
        int[] arr = {10, 20, 10, 30, 20, 10, 30};
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        System.out.println("Frequency Map: " + freqMap);

        // 12️⃣ Find Top K elements (using Max-Heap)
        int K = 3;
        PriorityQueue<Map.Entry<Integer,Integer>> topK = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        topK.addAll(freqMap.entrySet());
        System.out.println("Top " + K + " frequent elements:");
        for (int i=0;i<K && !topK.isEmpty();i++) {
            Map.Entry<Integer,Integer> entry = topK.poll();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
