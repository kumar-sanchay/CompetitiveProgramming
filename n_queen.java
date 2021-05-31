import java.util.Arrays;

class Solution{


    public static int solve(int n){

        int mat[][] = new int[n][n];

        int max = 0;
        
        for(int i=0; i<n; i++){

            int[][] temp = new int[n][n];
            if(safeUtil(temp, i, n, 0)){                
                max++;

                for(int a[]: temp){
                    for(int b: a)
                        System.out.print(b+" ");
                    System.out.println();
                }
                System.out.println();
            }
        }

        return max;
    }
    
    public static boolean isSafe(int[][] mat, int x, int y, int N){

        if(!(x>=0 && x<N && y>=0 && y<N))
            return false;

        for(int i=0; i<N; i++){
            if(mat[x][i]==1)
                return false;
        }
        int i, j;
        for(i=x, j=y; i>=0 && j>=0; i--, j--){
            if(mat[i][j]==1)
                return false;
        }

        for(i=x, j=y; i<N && j>=0; i++, j--){
            if(mat[i][j]==1)
                return false;
        }

        return true;

    }
    

    public static boolean safeUtil(int[][] mat, int row, int n, int m){

        if(row>=n && m==n)
            return true;
        
        if(row>=n)
            return false;
        
        int next_x, next_y;

        for(int i=0; i<n; i++){

            next_x = row + 1;
            next_y = i;

            if(isSafe(mat, next_x, next_y, n)){

                mat[next_x][next_y] = 1;
                
                if(safeUtil(mat, next_x, n, m+1))
                    return true;

                mat[i][next_x] = 0;
            }
        }

        return false;
    }
    public static void main(String args[]){

        int mat = solve(4);
        System.out.println(mat);
    }
}
