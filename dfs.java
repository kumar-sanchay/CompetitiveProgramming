import java.util.Arrays;
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

       dfs(4, g);
    }

    public static void dfs(int v, Graph g){

        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for(int i=0; i<v; i++)
            if(!visited[i])
                dfsUtil(g, i, visited);
    }

    public static void dfsUtil(Graph graph, int node, boolean visited[]){

        visited[node] = true;
        System.out.print(node+" ");
        Iterator<Integer> iter = graph.graph[node].listIterator();

        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n])
                dfsUtil(graph, n, visited);
        }
    }
}