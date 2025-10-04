package basics;
import java.util.*;

public class ArrayDequeAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ArrayDeque Analyzer ===");

        // 1️⃣ Create ArrayDeque
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // 2️⃣ Add / Offer elements
        dq.addFirst(10);
        dq.addLast(20);
        dq.offerFirst(5);
        dq.offerLast(25);
        System.out.println("After add/offer: " + dq);

        // 3️⃣ Remove / Poll elements
        int removedFirst = dq.removeFirst();
        int removedLast = dq.removeLast();
        System.out.println("Removed first: " + removedFirst + ", last: " + removedLast);

        int polledFirst = dq.pollFirst();
        int polledLast = dq.pollLast();
        System.out.println("Polled first: " + polledFirst + ", last: " + polledLast);
        System.out.println("ArrayDeque after removals: " + dq);

        // 4️⃣ Push / Pop (Stack behavior)
        dq.push(50);
        dq.push(60);
        System.out.println("After push: " + dq);

        int popped = dq.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("After pop: " + dq);

        // 5️⃣ Peek First / Last
        System.out.println("Peek First: " + dq.peekFirst());
        System.out.println("Peek Last: " + dq.peekLast());

        // 6️⃣ Contains / Remove(Object)
        dq.add(70);
        dq.add(80);
        System.out.println("Contains 70? " + dq.contains(70));
        dq.remove(70);
        System.out.println("After removing 70: " + dq);

        // 7️⃣ Iteration
        System.out.println("Iterating ArrayDeque:");
        for (Integer x : dq) {
            System.out.println(x);
        }

        // 8️⃣ Size / isEmpty
        System.out.println("Size: " + dq.size());
        System.out.println("Is empty? " + dq.isEmpty());

        // 9️⃣ Convert to array / list
        Integer[] arr = dq.toArray(new Integer[0]);
        System.out.println("Converted to array: " + Arrays.toString(arr));

        ArrayList<Integer> list = new ArrayList<>(dq);
        System.out.println("Converted to ArrayList: " + list);

        // 🔟 Custom operation: Reverse deque using stack
        Stack<Integer> stack = new Stack<>();
        for (Integer x : dq) {
            stack.push(x);
        }

        ArrayDeque<Integer> reversed = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            reversed.add(stack.pop());
        }
        System.out.println("Reversed ArrayDeque: " + reversed);
    }
}
