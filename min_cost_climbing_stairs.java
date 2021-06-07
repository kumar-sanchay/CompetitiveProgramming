import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int cache[] = new int[cost.length];
        Arrays.fill(cache, -1);
        
        int a = f(cost, 0, cache);
        int b = f(cost, 1, cache);
        
        
        System.out.println(b);
        if(a<b)
            return a;
        else 
            return b;
    }

    public static int f(int cost[], int idx, int cache[]){
        
        if(cache[idx]!=-1)
            return cache[idx];
        
        int n = cost.length -1;
        if(idx>=n-1)
            return cost[idx];

        int res = cost[idx] + Math.min(f(cost, idx+1, cache), f(cost, idx+2, cache));
        
        cache[idx] = res;
        return res;
    }
}