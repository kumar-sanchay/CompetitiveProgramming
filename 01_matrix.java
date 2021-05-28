import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int a[] = Arrays.copyOf(nums, nums.length);
        
        for(int i=0; i<nums.length; i++){
            nums[i] = target - nums[i];
        }

        Arrays.sort(nums);

        int sum = (nums[0]+target) + (nums[1]+target) + (nums[2]+target);
        return sum;
    }


    public static void main(String args[]){

    }
}
