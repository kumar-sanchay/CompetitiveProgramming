import java.util.*;

class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        int RR = mat.length;
        int CC = mat[0].length;

        int result[][] = new int[mat.length][mat[0].length];

        for(int idx=0; idx<mat.length; idx++){
            for(int jdx=0; jdx<mat[idx].length; jdx++){
                
                LinkedList<Integer> rq = new LinkedList<>();
                LinkedList<Integer> cq = new LinkedList<>();

                boolean visited[][] = new boolean[mat.length][mat[0].length];
                int nodes_in_next_layer = 0;
                int nodes_left_in_layer = 1;
                
                int src = mat[idx][jdx];
                rq.add(idx);
                cq.add(jdx);
                int move_count = 0;

                visited[idx][jdx] = true;

                while(rq.size()>0){
                    int min_count = 0;
                    int r = rq.poll();
                    int c = cq.poll();

                    if(mat[idx][jdx]==0){
                        result[idx][jdx] = 0;
                        break;
                    }

                    for(int i=0; i<4; i++){
                        int rr = r + dx[i];
                        int cc = c + dy[i];
                        
                        if(rr>=RR || cc>=CC) continue;

                        if(rr<0 || cc<0) continue;

                        if(visited[rr][cc]) continue;

                        if(mat[rr][cc]==0){
                            //  result[rr][cc] = 0;
                            continue;
                        }

                        rq.add(rr);
                        cq.add(cc);
                        
                        visited[rr][cc] = true;
                        nodes_in_next_layer++;
                    }

                    nodes_left_in_layer--;
                    if(nodes_left_in_layer==0){
                        nodes_left_in_layer = nodes_in_next_layer;
                        min_count ++;
                        nodes_in_next_layer = 0; 
                    }
                move_count += min_count;  
                }

                result[idx][jdx] = move_count;
                
            }
        }
        return result;
    }

    public static void main(String args[]){

        int arr[][] = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        int res[][] = updateMatrix(arr);

        for(int a[]: res){
            for(int b: a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
