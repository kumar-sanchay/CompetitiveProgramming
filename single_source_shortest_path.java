import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import javax.print.DocFlavor.INPUT_STREAM;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class Edge{

    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

}
class Graph{

    LinkedList<Edge> graph[];
    int v;

    Graph(int v){
        this.v = v;
        graph = new LinkedList[v];

        for(int i=0; i<v; i++)
            graph[i] = new LinkedList<>();
    }

    void addEdge(int from, int to, int cost){
        graph[from].add(new Edge(from, to, cost));
    }
}

class Solution{

    public static void main(String args[]){
       
       HashMap<Integer, Integer> map = new HashMap<>();
       Graph g = new Graph(12);
       g.addEdge(0, 1, 4);
       g.addEdge(0, 7, 8);
       g.addEdge(1, 2, 8);
       g.addEdge(1, 7, 11);
       g.addEdge(7, 8, 7);
       g.addEdge(7, 6, 1);
       g.addEdge(0, 1, 4);

       dfs(12, g, map);

       for(Map.Entry<Integer,Integer> entry: map.entrySet())
            System.out.println(entry.getKey()+" "+entry.getValue());
    }


    public static void dfs(int v, Graph g, HashMap<Integer, Integer> map){

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for(int i=0; i<v; i++)
            if(!visited[i])
                dfsUtil(g, i, visited, stack);
        
        while(!stack.isEmpty()){
            map.put(stack.pop(), Integer.MAX_VALUE);
        }

        bfs(12, g, map);
    }

    public static void dfsUtil(Graph graph, int node, boolean visited[], Stack<Integer> stack){

        visited[node] = true;
        Iterator<Edge> iter = graph.graph[node].listIterator();
        while(iter.hasNext()){
            Edge n = iter.next();
            if(!visited[n.to])
                dfsUtil(graph, n.to, visited, stack);
        }

        stack.push(node);
    }

    public static void bfs(int v, Graph g, HashMap<Integer, Integer> map){

        boolean visited[] = new boolean[v];
        map.put(0, 0);
        for(int i=0; i<v; i++)
            bfsUtil(g, i, visited, map);
    }

    public static void bfsUtil(Graph graph, int node, boolean visited[], HashMap<Integer, Integer> map){

        Iterator<Edge> iter = graph.graph[node].listIterator();
        int a = map.get(node);
        while(iter.hasNext()){
            Edge e = iter.next();
            int b = map.get(e.to);

            if(b>a+e.cost){
                map.put(e.to, a+e.cost);
            }

        }
    }
}