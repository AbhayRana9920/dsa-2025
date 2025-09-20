// https://leetcode.com/problems/minimum-window-substring/
// https://www.youtube.com/watch?v=iwv1llyN6mo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=13




class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int i = 0;
        int j = 0;

        int start = -1;
        int end = -1;

        String ans = "";
        int min = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the map with characters from t
        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();

        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            // if (count > 0) {
            // j++;
            if (count == 0) {
                // Only update the result if a valid window is found

                // Shrink the window from the left
                while (count == 0) {
                    if (j - i + 1 < min) {
                        start = i;
                        end = j;
                        min = j - i + 1;
                    }
                    char cc = s.charAt(i);
                    if (map.containsKey(cc)) {
                        map.put(cc, map.get(cc) + 1);
                        if (map.get(cc) > 0) {
                            count++;
                        }
                    }
                    i++;
                }

            }
            j++;
        }
        if (start == -1) {
            return ans;
        }
        ans = s.substring(start, end + 1);
        return ans;
    }
}
