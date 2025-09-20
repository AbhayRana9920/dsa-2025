// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

public class MaxSumSubarrayofsizeK {
    public int maximumSumSubarray(int[] arr, int k) {
        int n =  arr.length;
        int sum = 0;
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        while(j<n){
            sum = sum + arr[j]; //calculation
            
            if(j-i+1<k){ // window formation
                j++;
            }else if(j-i+1==k){
                max = Math.max(max,sum); // result
                sum = sum - arr[i]; //decalculation at i
                i++; //slide the window
                j++; //slide the window
            }
        }
        
        return max;
    }
}

