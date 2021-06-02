class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j = 0;
        
        int d = 0;
        
        
        
        for(int i=0; i<nums.length-1; i++){
            
            if(i==nums.length-3)
                j++;
            d++;
            if(nums[i]==nums[i+1]){
                
                
                if(d>2){
                    nums[i] = Integer.MAX_VALUE;
                }else{
                    j++;
                }
            }else{
                if(d>2){
                    nums[i] = Integer.MAX_VALUE;
                }else{
                    j++;    
                }
                d=0;
            }    
        }
        
        Arrays.sort(nums);
        return j;
    }
}
