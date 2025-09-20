// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1561370867/
// https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);  //calculation
            } else {
                map.put(ch, 1);
            }

            if (map.size() == j - i + 1) {   // window hit
                ans = Math.max(ans, j - i + 1); // result
                j++;
            }else if (map.size() < j - i + 1) { //decalculation
                while (map.size() < j - i + 1) {
                    char c = s.charAt(i);
                    int f = map.get(c);
                    map.put(c, f - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                    i++;
                }
                j++;
            }
        }

        return ans;
    }
}