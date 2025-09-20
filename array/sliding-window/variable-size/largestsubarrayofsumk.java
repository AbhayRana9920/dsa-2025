// https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8


public class largestsubarrayofsumk {
    int largestSubarray(int[] arr, int k){
        int max = 0, sum = 0, i = 0, j = 0;
        while(j < arr.length){
            sum += arr[j];
            if(sum < k){
                j++;
            }
            else if(sum == k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else{
                while(sum > k){
                    sum -= arr[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }
                }
                j++;
            }
        }
        return max;
    }


}
