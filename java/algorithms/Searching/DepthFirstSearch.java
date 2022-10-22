package algorithms.Searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    List tree = new ArrayList();

    public static void main(String[] args) {
        Node nodeD = new Node("D", null, null);
        Node nodeE = new Node("E", null, null);
        Node nodeF = new Node("F", null, null);
        Node nodeB = new Node("B", nodeD,nodeE);
        Node nodeC = new Node("C", null, nodeF);
        Node root = new Node("A", nodeB, nodeC);

        DepthFirstSearch.executeDFS(root);
    }

    public static void executeDFS(Node root){
        Stack nodeStack = new Stack();
        Node currentNode = root;
        System.out.println("***********DFS traversal************");
        nodeStack.push(currentNode);
        while(!nodeStack.isEmpty()){
            currentNode = (Node) nodeStack.pop();
            System.out.println("--" + currentNode.getData() + "--");

            if (currentNode.getLeft() == null && currentNode.getRight()==null){
                continue;
            } else {
                if(currentNode.getRight() != null){
                    nodeStack.push(currentNode.getRight());
                }
                if(currentNode.getLeft() != null) {
                    nodeStack.push(currentNode.getLeft());
                }
            }
        }
    }
}
class Node {
    String data;
    Node left;
    Node right;

    public Node(String data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String getData(){
        return this.data;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

}