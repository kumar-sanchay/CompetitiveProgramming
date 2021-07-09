
import java.util.Iterator;
import java.util.LinkedList;

class Graph{

    LinkedList<Integer> graph[];
    int v;

    Graph(int v){
        this.v = v;
        graph = new LinkedList[v];

        for(int i=0; i<v; i++)
            graph[i] = new LinkedList<>();
    }

    void addEdge(int from, int to){

        graph[from].add(to);
    }
}

class Solution{

    public static void main(String args[]){

       Graph g = new Graph(4);
       g.addEdge(0, 1);
       g.addEdge(0, 2);
       g.addEdge(1, 2);
       g.addEdge(2, 0);
       g.addEdge(2, 3);
       g.addEdge(3, 3);

       bfs(4, g);
    }

    public static void bfs(int v, Graph g){

        boolean visited[] = new boolean[v];
        
        bfsUtil(g, 2, visited);
    }

    public static void bfsUtil(Graph graph, int node, boolean visited[]){

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            int v = queue.poll();
            visited[v] = true;
            System.out.print(v+" ");
            Iterator<Integer> iter = graph.graph[v].listIterator();
            while(iter.hasNext()){
                int a = iter.next();
                if(!visited[a]){
                    queue.add(a);
                }

            }
        }
    }
}