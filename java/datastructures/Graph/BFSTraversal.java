package datastructures.Graph;

import java.util.*;

class BFSTraversal {
    private int V;
    private LinkedList<Integer> adj[];

    BFSTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void printBFSTraversal(int s){
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graphBFSTraversal = new BFSTraversal(4);

        graphBFSTraversal.addEdge(0,1);
        graphBFSTraversal.addEdge(0,2);
        graphBFSTraversal.addEdge(1,2);
        graphBFSTraversal.addEdge(2,0);
        graphBFSTraversal.addEdge(2,3);
        graphBFSTraversal.addEdge(3,3);
        System.out.println("Implementing BFS Bread First Traversal");

        graphBFSTraversal.printBFSTraversal(2);



    }

}