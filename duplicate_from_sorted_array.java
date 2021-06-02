class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j = 1;
        
        int d = 1;
        
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            d++;
            int p = nums[i];
            if(prev==nums[i]){
                
                
                if(d>2){
                    nums[i] = Integer.MAX_VALUE;
                }else{
                    j++;
                }
            }else{
                d=1;
                j++;
            }
            
            prev=p;
        }
        
        Arrays.sort(nums);
        return j;
    }
}