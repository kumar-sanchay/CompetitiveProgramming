class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int idx = 0;
        int max = 0;
        while(idx<nums.length){
            int b = 0;
            int count = 0;
            for(int i=idx; i<nums.length; i++){
                
                if(nums[i]==0){
                    
                    if(b>=k) break;
                    b++;
                }
                
                count++;
            }
            
            if(max<count){
                max=count;
            }
            
            idx++;
        }
        
        return max;
    }
}