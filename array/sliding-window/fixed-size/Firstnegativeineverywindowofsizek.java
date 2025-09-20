// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

import java.util.*;

class Firstnegativeineverywindowofsizek {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        int n = arr.length;
        int i=0;
        int j=0;
        List<Integer> neg = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        
        while(j<n){
            
           if(arr[j]<0){
               neg.add(arr[j]);  //calculation
           }
           
           if(j-i+1<k){ //window formation
               j++;
           }else if(j-i+1==k){
               if(neg.size()==0){
                   ans.add(0);
               }else{
                   ans.add(neg.get(0)); // result
               
                   if(arr[i]==neg.get(0)){ //decalculation at i
                       neg.remove(0);
                   }
               }
               i++;
               j++; // slide the window
           }
            
        }
        
        return ans;
        
    }
}
