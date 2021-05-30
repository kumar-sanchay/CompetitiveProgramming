import java.util.Arrays;

class Solution{

    public static int[][] find(int n){

        int mat[][] = new int[n][n];

        for(int i=0; i<n; i++)
            Arrays.fill(mat[i], -1);

        int x_move[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y_move[] = {1, 2, 2, 1, -1, -2, -2, -1};

        mat[0][0] = 0;

        solveUtil(0, 0, 1, mat, x_move, y_move, n);

        return mat;
        

    }

    public static boolean isSafe(int n, int x, int y, int mat[][]){

        return (x<n && x>=0 && y<n && y>=0 && mat[x][y]==-1);
    }

    public static boolean solveUtil(int x, int y, int move, int mat[][], int x_move[], int y_move[], int n){

        int next_x, next_y;

        if(move == n*n) return true;

        for(int i=0; i<8; i++){

            next_x = x + x_move[i];
            next_y = y + y_move[i];

            if(isSafe(n, next_x, next_y, mat)){
                mat[next_x][next_y] = move;

                if(solveUtil(next_x, next_y, move+1, mat, x_move, y_move, n)){
                    return true;
                }else{
                    mat[next_x][next_y] = -1;
                }
            }
        }

        return false;

    }

    public static void main(String args[]){
        int n = 8;

        int mat[][] = find(n);

        for(int[] i: mat){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }   
}