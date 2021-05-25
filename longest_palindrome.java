class Solution {
    public static String longestPalindrome(String s) {
        
        char[] arr = s.toCharArray();

        int idx=0, jdx=arr.length-1, i, j;
        int n=s.length() - 1;

        int count = 1;

        while(idx<jdx){
            i=idx;
            j=jdx;

            while(i<j){

                if(arr[i]==arr[j]){
                    
                    i++;
                    j--;
                }else{
                    break;
                }

                if(i==j+1 || i==j){

                    return s.substring(idx, jdx+1);
                }
            }
            
            if(jdx>=n){
                jdx = n - count;
                idx=0;
                count++;
            }else{
                idx++;
                jdx++;
            }

        }

        return s.substring(0, 1);
    }

    public static void main(String args[]){

        String txt = "cbbd";
        String res = longestPalindrome(txt);

        System.out.println(res);
    }
}
