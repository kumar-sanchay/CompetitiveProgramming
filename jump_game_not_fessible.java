
class Solution{

    public static int jump(int[] num){
        int count = 0;

        count = solve(num, 0, 0);
        return count;
    }

    public static int solve(int[] num, int idx, int jumps){

        int max = num[idx];
        System.out.print(idx+" ");

        if(idx>=num.length-1){
            return jumps;
        }

        if(max==0)
            return jumps;
        int max_count = Integer.MAX_VALUE;

        for(int i=max; i>=1; i--){
            
            if(idx+i>=num.length || i+idx<=0){
                break;
            }

            int count = solve(num, idx+i, jumps+1);

            if(count<max_count)
                max_count = count;
        }

        return max_count;
    }

    public static void main(String main[]){

        int num[] = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        //int num[] = {2, 3, 1, 1, 4};
        System.out.println(jump(num));
    }
   
}