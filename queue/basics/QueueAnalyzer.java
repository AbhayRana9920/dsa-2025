package basics;
import java.util.*;

public class QueueAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Queue Analyzer ===");

        // 1️⃣ Create Queue
        Queue<Integer> queue = new LinkedList<>();

        // 2️⃣ Add elements
        queue.add(10);
        queue.add(20);
        queue.offer(30);
        queue.offer(40);
        System.out.println("Queue after add/offer: " + queue);

        // 3️⃣ Remove / Poll
        int removed = queue.remove(); // throws exception if empty
        System.out.println("Removed element (remove): " + removed);
        int polled = queue.poll();    // returns null if empty
        System.out.println("Removed element (poll): " + polled);
        System.out.println("Queue after removal: " + queue);

        // 4️⃣ Peek / Element
        int headPeek = queue.peek();     // returns null if empty
        int headElement = queue.element(); // throws exception if empty
        System.out.println("Head element (peek): " + headPeek);
        System.out.println("Head element (element): " + headElement);

        // 5️⃣ isEmpty / size
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());

        // 6️⃣ Iteration
        System.out.println("Iterating queue elements:");
        for (Integer x : queue) {
            System.out.println(x);
        }

        // 7️⃣ PriorityQueue (min-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.add(30);
        System.out.println("PriorityQueue elements: " + pq);
        System.out.println("PriorityQueue poll(): " + pq.poll()); // removes smallest
        System.out.println("PriorityQueue after poll: " + pq);

        // 8️⃣ Reverse Queue using Stack
        Queue<Integer> reverseQueue = new LinkedList<>();
        reverseQueue.addAll(queue); // copy elements
        Stack<Integer> stack = new Stack<>();
        while (!reverseQueue.isEmpty()) {
            stack.push(reverseQueue.poll());
        }
        Queue<Integer> reversed = new LinkedList<>();
        while (!stack.isEmpty()) {
            reversed.add(stack.pop());
        }
        System.out.println("Reversed Queue: " + reversed);

        // 9️⃣ Merge Queues
        Queue<Integer> anotherQueue = new LinkedList<>();
        anotherQueue.add(100);
        anotherQueue.add(200);
        queue.addAll(anotherQueue);
        System.out.println("Queue after merging anotherQueue: " + queue);

        // 🔟 Custom Queue Example
        CustomQueue customQueue = new CustomQueue(5);
        customQueue.enqueue(1);
        customQueue.enqueue(2);
        customQueue.enqueue(3);
        System.out.println("CustomQueue after enqueue: " + customQueue);
        customQueue.dequeue();
        System.out.println("CustomQueue after dequeue: " + customQueue);
    }
}

// User-defined queue using array
class CustomQueue {
    int[] arr;
    int front, rear, size, capacity;

    CustomQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
        rear = -1;
    }

    void enqueue(int val) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = val;
        size++;
    }

    int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[(front + i) % capacity]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
