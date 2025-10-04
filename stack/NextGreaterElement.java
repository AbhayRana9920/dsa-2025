// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
// https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        int n = arr.length;
        
        List<Integer> ans = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans.add(-1);
            }else if(st.size()>0 && st.peek()>arr[i]){
                ans.add(st.peek());
            }else if(st.size()>0 && st.peek()<=arr[i]){
                while(st.size()>0 && st.peek()<=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    ans.add(-1);
                }else{
                    ans.add(st.peek());
                }
            }
            
            st.push(arr[i]);
            
        }
        Collections.reverse(ans);
        
        return new ArrayList<>(ans);
    }
}
    
