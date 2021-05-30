

class Solution{

    public static int[][] solve(int maze[][]){

        int N = maze.length;
        int[][] sol = new int[N][N];

        solveUtil(0, 0, N, maze, sol);

        return sol;
    }

    public static boolean isSafe(int x, int y, int N, int maze[][]){

        return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==1);
    }

    public static boolean solveUtil(int x, int y, int N, int maze[][], int sol[][]){

        if(x==N-1 && y==N-1 && maze[x][y]==1){
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(x, y, N, maze)){

            if(sol[x][y]==1){
                return false;
            }

            sol[x][y] = 1;

            if(solveUtil(x+1, y, N, maze, sol)){
                
                return true;
            }

            if(solveUtil(x, y+1, N, maze, sol)){
                return true;
            }

            if(solveUtil(x-1, y, N, maze, sol)){
                return true;
            }

            if(solveUtil(x, y-1, N, maze, sol)){
                return true;
            }

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]){

        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int sol[][] = solve(maze);

        for(int i[]: sol){
            for(int a: i){
                System.out.print(a+" ");
            }
            System.out.println();
        }
            

    }
}
