
class Solution {
    public static int m = 0;

    public static int knightDialer(int n) {
     
        
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // . 0 #

        int mat[][] = new int[4][4];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                if(j==3){
                    mat[i][j] = -2;
                    continue;
                }
                if(i==3 && j==0|| i==3 && j==2){
                    mat[i][j] = -2;
                    continue;
                }
                mat[i][j] = -1;
            }
        }

        int x_move[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y_move[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int max = 0;

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                
                
                int temp[][] = mat.clone();
                
                // if(temp[i][j]==-2){
                //     continue;
                // }

                temp[i][j] = 0;
                boolean res = solveUtil(i, j, 1, x_move, y_move, temp, 1, n);
                printMat(temp);
                // System.out.println(i+", "+j+" : "+res);
                if(res){
                    max+=1;
                }
            }
        }



        return max;
    }

    public static boolean isSafe(int x, int y, int N, int mat[][]){

        return (x>=0 && x<N && y>=0 && y<N && mat[x][y]==-1);
    }

    public static void printMat(int mat[][]){
        for(int i[]: mat){
            for(int a: i)
                System.out.print(a+" ");
            System.out.println();
        }
            
    }

    public static boolean solveUtil(int x, int y, int move, int[] x_move, int[] y_move, int mat[][], int n, int N){

        int next_x, next_y;

        if(move==4*4)
            return true;

        for(int i=0; i<8; i++){

            next_x = x + x_move[i];
            next_y = y + y_move[i];

            if(isSafe(next_x, next_y, 4, mat)){
                
                mat[next_x][next_y] = move;
                
                if(solveUtil(next_x, next_y, move+1, x_move, y_move, mat, n+1, N)){
                    return true;
                }else{
                    mat[next_x][next_y] = -1;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){

        int ans = knightDialer(1);

        System.out.println(ans);
    }

}
