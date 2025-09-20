// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10

import java.util.HashMap;

class  longestsubstringwithkuniquescharacter{
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = -1;
        int i = 0, j = 0;

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() > k) {
                    char c = s.charAt(i);
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                    i++;
                }
                if (map.size() == k) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }

            
        }

        return max;
    }
}
