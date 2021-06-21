import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int cache[] = new int[triangle.size()];
        Arrays.fill(cache, Integer.MAX_VALUE);
        return cal(triangle, 0, 0, cache);
    }
    
    public int cal(List<List<Integer>> triangle, int idx, int p, int[] cache){
        
        if(idx>=triangle.size()){
            // System.out.println(sum);
            return 0;    
        }
        
        // if(cache[idx]!=Integer.MAX_VALUE){
        //     return cache[idx];
        // }
        
        List<Integer> l = triangle.get(idx);
        int v = Integer.MAX_VALUE;
        
        for(int i=p; i<p+2 && i<l.size(); i++){
           int val = l.get(i) + cal(triangle, idx+1, i, cache);
            
           if(val<v){
               v = val;
           }
        }
        cache[idx] = v;
        return v;
    }
}