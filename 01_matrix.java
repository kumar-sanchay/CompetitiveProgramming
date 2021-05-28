import java.util.*;

class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        int RR = mat.length;
        int CC = mat[0].length;

        int result[][] = new int[mat.length][mat[0].length];

        for(int idx=0; idx<RR; idx++){
            for(int jdx=0; jdx<CC; jdx++){

                if(mat[idx][jdx]==0){
                    result[idx][jdx] = 0;
                }else{

                    LinkedList<Integer> rq = new LinkedList<>();
                    LinkedList<Integer> cq = new LinkedList<>();

                    rq.add(idx);
                    cq.add(jdx);
                    int final_move = 0;
                    boolean visited[][] = new boolean[RR][CC];
                    int node_left = 1;
                    int node_next = 0;

                    while(rq.size()>0){
                        int r = rq.poll();
                        int c = cq.poll();
                        visited[r][c] = true;
                        
                        if(mat[r][c]==0){
                            break;
                        }
                        for(int i=0; i<4; i++){
                            int rr = r + dx[i];
                            int cc = c + dy[i];

                            if (rr>=RR || cc>=CC) continue;
                            if(rr<0 || cc<0) continue;

                            if(visited[rr][cc]) continue;

                            rq.add(rr);                         
                            cq.add(cc);
                            node_next++;
                            visited[rr][cc] = true;
                        }

                        node_left--;
                        if(node_left==0){
                            node_left = node_next;
                            node_next = 0;
                            final_move++;
                        }


                    }

                    result[idx][jdx] = final_move;
                }
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
