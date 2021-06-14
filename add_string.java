class Solution {
    public String addStrings(String num1, String num2) {
        
        char a[] = num1.toCharArray();
        char b[] = num2.toCharArray();
        
        int m = a.length -1;
        int n = b.length -1;
        
        int carry = 0;
        String ans = "";
        
        while(m>=0&&n>=0){
            int res = Integer.parseInt(String.valueOf(a[m])) + Integer.parseInt(String.valueOf(b[n]));
            res += carry;
            carry = 0;
            int rem = res % 10;
            carry = res / 10; 
            ans = String.valueOf(rem) + ans;
            m--;
            n--;
        }
        
        while(m>=0){
            int res = Integer.parseInt(String.valueOf(a[m]));
            res += carry;
            carry = 0;
            int rem = res % 10;
            carry = res / 10;
            
            ans = String.valueOf(rem) + ans;
            m--;
        }
        
        while(n>=0){
            int res = Integer.parseInt(String.valueOf(b[n]));
            res += carry;
            carry = 0;
            int rem = res % 10;
            carry = res / 10;
            
            ans = String.valueOf(rem) + ans;
            n--;
        }
        
        if(carry>0){
            ans = String.valueOf(carry) + ans;
        }
            
        return ans;
    }
}