package datastructures.Graph;

import java.util.*;

public class DFSTraversal {
    private int V;
    private LinkedList<Integer> adj[];

    DFSTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()){
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        DFSTraversal graphDFSTraversal = new DFSTraversal(4);

        graphDFSTraversal.addEdge(0, 1);
        graphDFSTraversal.addEdge(0, 2);
        graphDFSTraversal.addEdge(1, 2);
        graphDFSTraversal.addEdge(2, 0);
        graphDFSTraversal.addEdge(2, 3);
        graphDFSTraversal.addEdge(3, 3);

        graphDFSTraversal.DFS(2);
    }


}
