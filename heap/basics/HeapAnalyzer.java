package basics;
import java.util.*;

public class HeapAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Heap Analyzer ===");

        // 1️⃣ Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        System.out.println("Min-Heap elements: " + minHeap);

        // Peek / Poll
        System.out.println("Min element (peek): " + minHeap.peek());
        System.out.println("Remove min element (poll): " + minHeap.poll());
        System.out.println("Min-Heap after poll: " + minHeap);

        // 2️⃣ Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);
        System.out.println("Max-Heap elements: " + maxHeap);
        System.out.println("Max element (peek): " + maxHeap.peek());
        System.out.println("Remove max element (poll): " + maxHeap.poll());
        System.out.println("Max-Heap after poll: " + maxHeap);

        // 3️⃣ Heap from array (heapify)
        int[] arr = {50, 10, 40, 20, 30};
        PriorityQueue<Integer> heapFromArray = new PriorityQueue<>();
        for (int x : arr) {
            heapFromArray.add(x);
        }
        System.out.println("Heap from array: " + heapFromArray);

        // 4️⃣ Custom object heap
        class Student {
            String name;
            int marks;

            Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }

            public String toString() {
                return name + "(" + marks + ")";
            }
        }

        PriorityQueue<Student> studentHeap = new PriorityQueue<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.marks - s2.marks; // Min-heap by marks
                    }
                }
        );

        studentHeap.add(new Student("Alice", 85));
        studentHeap.add(new Student("Bob", 95));
        studentHeap.add(new Student("Charlie", 75));

        System.out.println("Student Min-Heap by marks: " + studentHeap);
        System.out.println("Top student (peek): " + studentHeap.peek());
        System.out.println("Remove top student (poll): " + studentHeap.poll());
        System.out.println("Student Heap after poll: " + studentHeap);

        // 5️⃣ Remove specific element
        minHeap.remove(20);
        System.out.println("Min-Heap after removing 20: " + minHeap);

        // 6️⃣ Convert heap to array
        Integer[] heapArr = minHeap.toArray(new Integer[0]);
        System.out.println("Heap as array: " + Arrays.toString(heapArr));

        // 7️⃣ Size / isEmpty
        System.out.println("Min-Heap size: " + minHeap.size());
        System.out.println("Is Min-Heap empty? " + minHeap.isEmpty());
    }
}

