import java.util.*;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int result = 0;
        int max = 0;
        int N = grid.length;
        int M = grid[0].length;

        HashMap<String, Boolean> map = new HashMap<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]==1)
                    map.put(String.valueOf(i)+":"+String.valueOf(j), false);
            }
        }

        int x_map[] = {0, 0, 1, -1};
        int y_map[] = {1, -1, 0, 0};

        HashMap<String, Integer> outer_visited = new HashMap<>();


        for(Map.Entry<String, Boolean> e: map.entrySet()){

            
            if(outer_visited.containsKey(e.getKey()))
                continue;
            int max_size = 0;
            result++;

            String split[] = e.getKey().split(":");

            int x1 = Integer.valueOf(split[0]);
            int y1 = Integer.valueOf(split[1]);

            LinkedList<Integer> rx = new LinkedList<>();
            LinkedList<Integer> ry = new LinkedList<>();

            rx.add(x1);
            ry.add(y1);

            while(rx.size()>0){
                int x = rx.poll();
                int y = ry.poll();
                
                if(outer_visited.containsKey(x+":"+y))
                    continue;
                
                outer_visited.put(x+":"+y, result);
                max_size++;
                for(int i=0; i<4; i++){
                    int next_x = x + x_map[i];
                    int next_y = y + y_map[i];

                    if(isSafe(next_x, next_y, N,  M)){
                        
                        if(map.containsKey(next_x+":"+next_y) && !outer_visited.containsKey(next_x+":"+next_y)){
                            rx.add(next_x);
                            ry.add(next_y);
                            
                        }

                    }
                }
            }

            if(max_size>max){
                max = max_size;
            }
        }

        //System.out.println(outer_visited);
        return max;
    }

    public static boolean isSafe(int i, int j, int N, int M){

        return (i>=0 && i<N && j>=0 && j<M);
    }
}