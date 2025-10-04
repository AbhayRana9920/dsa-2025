package basics;

import java.util.*;

public class LinkedListAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Basic LinkedList Operations ===");

        // 1️⃣ Create LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // 2️⃣ Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20); // duplicate allowed
        list.add(null); // null allowed
        System.out.println("After adding elements: " + list);

        // 3️⃣ Add at index
        list.add(1, 15);
        System.out.println("After adding 15 at index 1: " + list);

        // 4️⃣ Add first / last
        list.addFirst(5);
        list.addLast(50);
        System.out.println("After addFirst and addLast: " + list);

        // 5️⃣ Remove by index / value
        list.remove(1); // remove index 1
        list.remove(Integer.valueOf(20)); // remove first occurrence of 20
        System.out.println("After removals: " + list);

        // 6️⃣ Remove first / last
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst and removeLast: " + list);

        // 7️⃣ Get / Set
        System.out.println("Element at index 1: " + list.get(1));
        list.set(1, 25);
        System.out.println("After set index 1 to 25: " + list);

        // 8️⃣ Contains
        System.out.println("Contains 30? " + list.contains(30));

        // 9️⃣ isEmpty / size
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("Size of list: " + list.size());

        // 🔟 Iteration
        System.out.println("Iterating elements:");
        for(int x : list) System.out.println(x);

        // Clear
        LinkedList<Integer> tempList = new LinkedList<>(list); // backup
        list.clear();
        System.out.println("After clear(): " + list);

        // ================= Advanced LinkedList Operations =================
        System.out.println("\n=== Advanced LinkedList Operations ===");

        list = new LinkedList<>(tempList); // restore elements

        // 1️⃣ Stack-like operations
        list.push(100);
        list.push(200);
        System.out.println("After push: " + list);
        System.out.println("Peek top: " + list.peek());
        list.pop();
        System.out.println("After pop: " + list);

        // 2️⃣ Queue-like operations
        list.offer(300);
        list.offer(400);
        System.out.println("After offer: " + list);
        System.out.println("Poll: " + list.poll());
        System.out.println("Peek: " + list.peek());

        // 3️⃣ PeekFirst / PeekLast / PollFirst / PollLast
        System.out.println("PeekFirst: " + list.peekFirst());
        System.out.println("PeekLast: " + list.peekLast());
        System.out.println("PollFirst: " + list.pollFirst());
        System.out.println("PollLast: " + list.pollLast());
        System.out.println("After polling: " + list);

        // 4️⃣ AddAll / removeAll / retainAll
        LinkedList<Integer> other = new LinkedList<>(Arrays.asList(25,30,50));
        list.addAll(other);
        System.out.println("After addAll: " + list);
        list.removeAll(Arrays.asList(25));
        System.out.println("After removeAll 25: " + list);
        list.retainAll(Arrays.asList(30,50));
        System.out.println("After retainAll [30,50]: " + list);

        // 5️⃣ Sorting / Reverse
        list.add(10);
        list.add(20);
        Collections.sort(list);
        System.out.println("After sort: " + list);
        Collections.reverse(list);
        System.out.println("After reverse: " + list);

        // 6️⃣ Convert to array / ArrayList
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println("Converted to array: " + Arrays.toString(arr));
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        System.out.println("Converted to ArrayList: " + arrayList);

        // 7️⃣ Frequency count
        int[] inputArr = {10,20,30,20,10,30,30};
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int x : inputArr) freq.put(x, freq.getOrDefault(x,0)+1);
        System.out.println("Frequency map: " + freq);
    }
}
