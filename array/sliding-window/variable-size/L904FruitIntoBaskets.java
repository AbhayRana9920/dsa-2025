// https://leetcode.com/problems/fruit-into-baskets/description/
// https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12




import java.util.HashMap;

public class L904FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i=0;
        int j=0;
        int max = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        if(n==1){
            return 1;
        }

        while(j<n){
            int num = fruits[j];
            if(map.containsKey(num)){
                map.put(num , map.get(num)+1);
            }else{
                map.put(num,1);
            }

            if(map.size()<=2){
                max = Math.max(j-i+1,max);
                j++;
            }else if(map.size()>2){
                while(map.size()>2){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i])==0){
                        map.remove(fruits[i]);
                    }
                    i++;
                }

                j++;
            }
        }

        return max;
    }

}
