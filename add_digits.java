class Solution {
    public int addDigits(int num) {
        
        int res = 0;
        
        while(num>0){
            int rem = num % 10;
            res += rem;
            num/=10;
            
            if(num<=0){
                int check = res / 10;
                if(check>0){
                    num = res;
                    res = 0;
                }
            }
        }
        
        return res;
    }
}