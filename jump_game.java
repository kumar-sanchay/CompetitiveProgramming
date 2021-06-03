
class Solution{

    public int jump(int[] nums) {
    
    int r = -1, len=nums.length-1;
    int jump = 0;
    int next = 0;
        
    for(int i=0; next<len; i++){

        if(r<i){
            r = next;
            jump++;
        }
        
        next = Math.max(next, nums[i]+i);
        
    }
    return jump;
    }
}
