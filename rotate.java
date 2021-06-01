class Solution {
    public void rotate(int[][] matrix) {
        
        int i1, i2, j1, j2, i3, i4, j3, j4;
        i1=0;
        i2=1;
        j1=1;
        j2=0;
        
        i3=0; j3=0;
        i4=0; j4=0;
        
        int N = matrix.length;
        
        while(j1<N && i2<N){
            
            i3=i1;
            j3=j1;
            
            i4=i2;
            j4=j2;
            
            while(i3<=i4 && j3>=j4){
                
                int temp = matrix[i3][j3];
                
                matrix[i3][j3] = matrix[i4][j4];
                matrix[i4][j4] = temp;
                
                i3 = i3 + 1;
                j3 = j3 - 1;
                
                j4 = j4 +1;
                i4 = i4 - 1;
            }
            j1++;
            i2++;
        }
        
        i1=N-1;
        i2=N-1;
        j1=N-1;
        j2=N-1;
        
        i3=0; j3=0;
        i4=0; j4=0;
        
        
        while(j1>0 && i2>0){
            
            i3=i1;
            j3=j1;
            
            i4=i2;
            j4=j2;
            
            while(i3>=i4 && j3<=j4){
                
                int temp = matrix[i3][j3];
                
                matrix[i3][j3] = matrix[i4][j4];
                matrix[i4][j4] = temp;
                
                i3 = i3 - 1;
                j3 = j3 + 1;
                
                j4 = j4 -1;
                i4 = i4 + 1;
            }
            j1--;
            i2--;
        }
    
//         for(int a[]: matrix){
//             for(int b: a)
//                 System.out.print(b+" ");
//             System.out.println();
//         }
        
        // System.out.println();
        
        for(int i=0; i<N; i++){
            int e = 0;
            int f = N-1;
            
            while(e<f){
                int t = matrix[i][e];
                matrix[i][e] = matrix[i][f];
                matrix[i][f] = t;
                
                e++;
                f--;
            }
        }
        
        // for(int a[]: matrix){
        //     for(int b: a)
        //         System.out.print(b+" ");
        //     System.out.println();
        // }
    }
}