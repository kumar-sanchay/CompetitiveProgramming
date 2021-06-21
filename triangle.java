import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        return cal(triangle, 0, 0);
    }
    
    public int cal(List<List<Integer>> triangle, int idx, int p){
        
        if(idx>=triangle.size()){
            // System.out.println(sum);
            return 0;    
        }
        
        List<Integer> l = triangle.get(idx);
        int v = Integer.MAX_VALUE;
        
        for(int i=0; i<p+2 && i<l.size(); i++){
           int val = l.get(i) + cal(triangle, idx+1, i);
            
           if(val<v){
               v = val;
           }
        }
        
        return v;
    }
}