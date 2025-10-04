package basics;

import java.util.*;

public class StackAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Basic Stack Operations ===");

        // 1️⃣ Create a Stack
        Stack<Integer> stack = new Stack<>();

        // 2️⃣ Push elements onto stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("After push: " + stack);

        // 3️⃣ Peek (view top element without removing)
        System.out.println("Top element (peek): " + stack.peek());

        // 4️⃣ Pop (remove top element)
        int popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after pop: " + stack);

        // 5️⃣ Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // 6️⃣ Stack size
        System.out.println("Stack size: " + stack.size());

        // 7️⃣ Search for element (returns 1-based position from top)
        int pos = stack.search(20);
        if(pos != -1) System.out.println("Element 20 found at position (from top): " + pos);
        else System.out.println("Element 20 not found");

        // 8️⃣ Iteration (from bottom to top)
        System.out.println("Iterating from bottom to top:");
        for(int x : stack) System.out.println(x);

        // 9️⃣ Iteration (from top to bottom using ListIterator)
        System.out.println("Iterating from top to bottom:");
        ListIterator<Integer> it = stack.listIterator(stack.size());
        while(it.hasPrevious()) {
            System.out.println(it.previous());
        }

        // ================= Advanced Stack Operations =================
        System.out.println("\n=== Advanced Stack Operations ===");

        // 1️⃣ Using ArrayDeque as Stack (more efficient than Stack class)
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(100); // push
        deque.push(200);
        deque.push(300);
        System.out.println("ArrayDeque stack: " + deque);
        System.out.println("ArrayDeque peek: " + deque.peek());
        System.out.println("ArrayDeque pop: " + deque.pop());

        // 2️⃣ Convert stack to ArrayList
        ArrayList<Integer> stackList = new ArrayList<>(stack);
        System.out.println("Stack converted to ArrayList: " + stackList);

        // 3️⃣ Reverse the stack (without modifying original)
        ArrayList<Integer> reversed = new ArrayList<>(stack);
        Collections.reverse(reversed);
        System.out.println("Reversed stack view: " + reversed);

        // 4️⃣ Find max and min in stack
        int max = Collections.max(stack);
        int min = Collections.min(stack);
        System.out.println("Max element in stack: " + max);
        System.out.println("Min element in stack: " + min);

        // 5️⃣ Frequency of each element in stack
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int x : stack) freqMap.put(x, freqMap.getOrDefault(x,0)+1);
        System.out.println("Frequency map of stack elements: " + freqMap);

        // 6️⃣ Clear the stack
        stack.clear();
        System.out.println("Stack after clear(): " + stack);
    }
}
