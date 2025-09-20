// https://leetcode.com/problems/sliding-subarray-beauty/


import java.util.*;
public class L2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n-k+1];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i=0;
        int j=0;
        int idx = 0;

        while(j<n){
            if(nums[j]<0){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(getCount(map)<x){
                    ans[idx] = 0;
                    idx++;
                }else{
                    ans[idx] = getXthSmallest(map,x);
                    idx++;    
                }
                if (nums[i] < 0){
                        map.put(nums[i],map.get(nums[i])-1);
                        if(map.get(nums[i])==0){
                            map.remove(nums[i]);
                        }
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    private int getCount(TreeMap<Integer,Integer> map){
        int count = 0;

        for(int v : map.values()){
            count += v;
        }

        return count;
    }

    private int getXthSmallest(TreeMap<Integer,Integer> map, int x){
        int count = 0;

        for(var entry : map.entrySet()){
            count += entry.getValue();

            if(count>=x){
                return entry.getKey();
            }
        }

        return 0;
    }

    
}
