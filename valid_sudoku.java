import java.util.*;

class Solution{

    public static boolean isValidSudoku(char[][] board){

        HashSet<Character>[] row_hash = new HashSet[9];
        HashSet<Character>[] col_hash = new HashSet[9];
        
        int x[] = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        int y[] = {0, 1, 2, 0, 1, 2, 0, 1, 2};

        for(int i=0; i<9; i++){
            row_hash[i] = new HashSet<>();
            col_hash[i] = new HashSet<>();
        }

        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){

                if(!check(board, i, j, x, y, row_hash, col_hash)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean check(char mat[][], int x, int y, int[] x_map, int[] y_map, HashSet<Character>[] row_hash, HashSet<Character>[] col_hash){

        int next_x, next_y;
        HashSet<Character> hash = new HashSet<>();

        for(int i=0; i<9; i++){

            next_x = x + x_map[i];
            next_y = y + y_map[i];

            if(row_hash[next_x].contains(mat[next_x][next_y]))
                return false;
            else{
                if(mat[next_x][next_y]!='.')
                row_hash[next_x].add(mat[next_x][next_y]);
            }
            
            if(col_hash[next_y].contains(mat[next_x][next_y]))
                return false;
            else{
                if(mat[next_x][next_y]!='.')
                col_hash[next_y].add(mat[next_x][next_y]);
            }

            if(hash.contains(mat[next_x][next_y]))
                return false;
            else{
                if(mat[next_x][next_y]!='.')
                hash.add(mat[next_x][next_y]);
            }
                
        }
        return true;
    }

    public static void main(String args[]){

        String[][] a = {{"5","3",".",".","7",".",".",".","."}
        ,{"6",".",".","1","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","6","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".","6",".",".",".",".","2","8","."}
        ,{".",".",".","4","1","9",".",".","5"}
        ,{".",".",".",".","8",".",".","7","9"}};

        char[][] b = new char[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                b[i][j] = a[i][j].charAt(0);

            }
        }

        System.out.println(isValidSudoku(b));
    }
}