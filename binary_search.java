class Solution {
    public int search(int[] nums, int target) {
        
        
        int c = (int)nums.length/2;
        
        if(target<=nums[c]){
            
            for(int i=0; i<=c; i++){
                if(nums[i]==target)
                    return i;
            }
        }else{
            for(int i=c; i<nums.length; i++){
                if(nums[i]==target)
                    return i;
            }
        }
        
        return -1;
    }
}