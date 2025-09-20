// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1



public class CountOccurencesofAnagrams {
    // User function Template for Java


    int search(String pat, String txt) {
        // code here
        
        int n = txt.length();
        int np = pat.length();
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<np;i++){
            char c = pat.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int i=0;
        int j=0;
        int ans = 0;
        
        int count = map.size();
        
        while(j<n){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            
            if(j-i+1<np){
                j++;
            }else if(j-i+1==np){
                if(count==0){
                    ans++;
                }
                char chh = txt.charAt(i);
                
                if(map.containsKey(chh)){
                    int freq = map.get(chh);
                    if(freq==0){
                        count++;
                    }
                    map.put(chh,freq+1);
                }
                
                i++;
                j++;
            }
        }
        
        
        return ans;
    }

}
