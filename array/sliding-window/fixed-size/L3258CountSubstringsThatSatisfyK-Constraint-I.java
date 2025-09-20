//  https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/
public class l3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int count=0;
        int zero=0;
        int one=0;
        for(int i=0;i<n;i++){
            one=0;
            zero=0;
            for(int j=i;j<n;j++){
                char c=s.charAt(j);
                if(c=='1'){
                    one++;
                }
                else{
                    zero++;
                }
                if(one>k && zero>k){
                    break;
                }
                else{ count++; }
            }

        }
        return count;
    }
}
    

