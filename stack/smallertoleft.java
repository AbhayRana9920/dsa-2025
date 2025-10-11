// https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1



class Solution {
    public int[] leftSmaller(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            if(st.size()==0){
                nums[i]=-1;
            }else if(st.size()>0 && st.peek()<arr[i]){
                nums[i]=st.peek();
            }else if(st.size()>0 && st.peek()>=arr[i]){
                while(st.size()>0 && st.peek()>=arr[i]){
                    st.pop();
                }
                
                if(st.size()==0){
                    nums[i]=-1;
                }else{
                    nums[i]=st.peek();
                }
            }
            
            st.push(arr[i]);
        }
        
        return nums;
    }
}
