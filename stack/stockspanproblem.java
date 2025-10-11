// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
// https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(st.size()==0){
                ans.add(-1);
            }else if(st.size()>0 && arr[st.peek()]>arr[i]){
                ans.add(st.peek());
            }else if(st.size()>0 && arr[st.peek()]<=arr[i]){
                while(st.size()>0 && arr[st.peek()]<=arr[i]){
                    st.pop();
                }
                
                if(st.size()==0){
                    ans.add(-1);
                }else{
                    ans.add(st.peek());
                }
            }
            
            st.push(i);
        }
        
        for(int i=0;i<n;i++){
            ans.set(i,i-ans.get(i));
        }
        
        return ans;
    }
}