import java.util.*;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== String Analyzer ===");

        // 1️⃣ Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Original String: " + str);

        // 2️⃣ Length and empty check
        System.out.println("Length: " + str.length());
        System.out.println("Is empty? " + str.isEmpty());

        // 3️⃣ charAt
        System.out.print("Characters in string: ");
        for (int i = 0; i < str.length(); i++) System.out.print(str.charAt(i) + " ");
        System.out.println();

        // 4️⃣ substring
        if (str.length() >= 3) System.out.println("Substring(0,3): " + str.substring(0,3));

        // 5️⃣ toUpperCase / toLowerCase / trim
        System.out.println("UpperCase: " + str.toUpperCase());
        System.out.println("LowerCase: " + str.toLowerCase());
        System.out.println("Trimmed: '" + str.trim() + "'");

        // 6️⃣ contains / startsWith / endsWith / indexOf / lastIndexOf
        System.out.println("Contains 'a'? " + str.contains("a"));
        System.out.println("Starts with 'H'? " + str.startsWith("H"));
        System.out.println("Ends with 'o'? " + str.endsWith("o"));
        System.out.println("Index of 'e': " + str.indexOf('e'));
        System.out.println("Last index of 'l': " + str.lastIndexOf('l'));

        // 7️⃣ replace / replaceAll
        System.out.println("Replace 'a' with 'x': " + str.replace('a','x'));
        System.out.println("Replace all digits with #: " + str.replaceAll("\\d","#"));

        // 8️⃣ Split
        String[] words = str.split(" ");
        System.out.println("Split words: " + Arrays.toString(words));

        // 9️⃣ Convert to char array
        char[] arr = str.toCharArray();
        System.out.println("Char Array: " + Arrays.toString(arr));

        // 🔟 Reverse using StringBuilder
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed String: " + reversed);

        // 1️⃣1️⃣ Palindrome check
        boolean isPalindrome = str.equalsIgnoreCase(reversed);
        System.out.println("Palindrome? " + isPalindrome);

        // 1️⃣2️⃣ Frequency count of characters
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        System.out.println("Character Frequency: " + freqMap);

        // 1️⃣3️⃣ Anagram check example
        System.out.print("Enter another string to check anagram: ");
        String str2 = sc.nextLine();
        boolean isAnagram = checkAnagram(str,str2);
        System.out.println("Are they anagrams? " + isAnagram);

        // 1️⃣4️⃣ StringBuilder operations
        StringBuilder sb = new StringBuilder(str);
        sb.append("!!!");
        System.out.println("After append: " + sb);
        sb.insert(0,"Start-");
        System.out.println("After insert: " + sb);
        sb.delete(0,6);
        System.out.println("After delete: " + sb);
        sb.replace(0,3,"XYZ");
        System.out.println("After replace: " + sb);
    }

    // Helper: Check anagram
    public static boolean checkAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s","").toLowerCase();
        s2 = s2.replaceAll("\\s","").toLowerCase();
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}
