import java.util.Arrays;
import java.util.Stack;
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

       Graph g = new Graph(6);
       g.addEdge(5, 2);
       g.addEdge(5, 0);
       g.addEdge(4, 0);
       g.addEdge(4, 1);
       g.addEdge(2, 3);
       g.addEdge(3, 1);

       dfs(6, g);
    }


    public static void dfs(int v, Graph g){

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for(int i=0; i<v; i++)
            if(!visited[i])
                dfsUtil(g, i, visited, stack);
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void dfsUtil(Graph graph, int node, boolean visited[], Stack<Integer> stack){

        visited[node] = true;
        Iterator<Integer> iter = graph.graph[node].listIterator();
        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n])
                dfsUtil(graph, n, visited, stack);
        }

        stack.push(node);
    }
}