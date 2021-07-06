import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            int n = ob.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
            }
            int c = Solution.ways(a, n);
            System.out.println(c);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int ways(int a[], int n) {
        
        
        Arrays.sort(a);
        int count = 0;
        for(int i=1; i<a.length-1; i++){
            int e, f, g;
            
            e = i;
            f = 0;
            g = a.length - 1;
            if(a[e]==Integer.MAX_VALUE)
                continue;
            
            while(f<g-1){
                if(a[f]==Integer.MAX_VALUE || f==e){
                    f++;
                    
                }else{
                    break;
                }
            }

            
            while(g>f){
                if(a[g]==Integer.MAX_VALUE || g==e){
                    g--;
                }else{
                    break;
                }
            }

            while(f<g){
                
                if(a[f]+a[g]==(-1 *a[e])){
                    count++;
                    System.out.println(a[e]+" "+a[f]+" "+a[g]);
                    a[e] = Integer.MAX_VALUE;
                    a[f] = Integer.MAX_VALUE;
                    a[g] = Integer.MAX_VALUE;
                    break;
                }                
                if(a[f]+a[g]>(-1 *a[e])){
                    g--;
                }else{
                    f++;
                }
            }
        }
        
        return count;
    }
}