package stringbuilder;

import java.util.*;

public class StringBuilderAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== StringBuilder Analyzer ===");

        // 1️⃣ Input string
        System.out.print("Enter initial string: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        System.out.println("Original StringBuilder: " + sb);

        // 2️⃣ Append
        sb.append("!!!");
        System.out.println("After append: " + sb);

        // 3️⃣ Insert
        sb.insert(0, "Start-");
        System.out.println("After insert: " + sb);

        // 4️⃣ Delete / DeleteCharAt
        if (sb.length() >= 6) {
            sb.delete(0, 6);
        }
        System.out.println("After delete(0,6): " + sb);

        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        System.out.println("After deleteCharAt(0): " + sb);

        // 5️⃣ Replace
        if (sb.length() >= 3) {
            sb.replace(0, 3, "XYZ");
        }
        System.out.println("After replace(0,3,'XYZ'): " + sb);

        // 6️⃣ Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);
        sb.reverse(); // restore

        // 7️⃣ CharAt / SetCharAt
        if (sb.length() > 0) {
            System.out.println("Char at 0: " + sb.charAt(0));
            sb.setCharAt(0, 'A');
            System.out.println("After setCharAt(0,'A'): " + sb);
        }

        // 8️⃣ Length / Capacity / EnsureCapacity / TrimToSize
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());

        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50), Capacity: " + sb.capacity());

        sb.trimToSize();
        System.out.println("After trimToSize(), Capacity: " + sb.capacity());

        // 9️⃣ Substring / ToString
        if (sb.length() >= 3) {
            System.out.println("Substring(0,3): " + sb.substring(0, 3));
        }

        String str = sb.toString();
        System.out.println("Converted to String: " + str);

        // 🔟 Frequency Count Example (vertical style)
        HashMap<Character, Integer> freq = new HashMap<>();
        char[] chars = sb.toString().toCharArray();

        for (char c : chars) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        System.out.println("Character Frequency: " + freq);

        // 1️⃣1️⃣ Palindrome Check
        String reversed = new StringBuilder(sb).reverse().toString();
        boolean isPalindrome = sb.toString().equalsIgnoreCase(reversed);
        System.out.println("Palindrome? " + isPalindrome);

        // 1️⃣2️⃣ Chaining Example
        sb.append(" Chain").insert(0, ">>").replace(2, 7, "Hello");
        System.out.println("After chaining operations: " + sb);
    }
}
