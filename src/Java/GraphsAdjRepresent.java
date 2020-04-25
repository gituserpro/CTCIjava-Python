package Java;

import Java.StackLL.StackNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphsAdjRepresent {


    int vertices;
    int matrices[][];
    LinkedList<Integer> adjList[];

    public GraphsAdjRepresent(int v) {
        this.vertices = v;
        matrices = new int[v][v];

        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

    }

    public void addEdgeMatrix(int source, int destination) {

        matrices[source][destination] = 1;
        matrices[destination][source] = 1;
    }

    public void printMatrices() {

        System.out.print("  ");
        for (int i = 0; i < vertices; i++) {
            System.out.print("" + i);
        }

        System.out.println("");
        for (int j = 0; j < vertices; j++) {
            System.out.print(+j + " ");
            for (int l = 0; l < vertices; l++) {
                System.out.print("" + matrices[j][l]);
            }
            System.out.println("");
        }


    }


    public void addEdgeLinkedList(int source, int dest) {

        adjList[source].add(dest);
        adjList[dest].add(source);
    }


    public void printAdjList() {

        for (int i = 0; i < vertices; i++) {
            if (adjList[i].size() > 0) {
                System.out.print(+i + " is connected to ->  ");
                for (int j = 0; j < adjList[i].size(); j++) {
                    System.out.print(" " + adjList[i].get(j));
                }
                System.out.println();
            }
        }

    }


    /* BFS using Queue */
    public void BFS(int start) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int key = queue.remove();
            System.out.print(+key);

            Iterator<Integer> iterator = adjList[key].listIterator();

            while (iterator.hasNext()) {

                int val = iterator.next();
                if (!visited[val]) {
                    visited[val] = true;
                    ((LinkedList<Integer>) queue).push(val);
                }
            }

        }
    }


    /*  DFS  using Stack Recursive   */

    public void DFSUtilRecursive(int start) {

        boolean visited[] = new boolean[vertices];
        DFSUtilRecursive(start, visited);
    }

    public void DFSUtilRecursive(int node, boolean[] vist) {

        vist[node] = true;
        System.out.print(" -- > " + node);

        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()) {

            int keyNode = it.next();
            if (!vist[keyNode]) {
                DFSUtilRecursive(keyNode, vist);
            }
        }
    }



    /*  DFS  using Stack Iterative  */
    public void DFSIterative(int start){

        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[vertices];

        stack.push(start);


         while(stack.empty()==false){


            int key = stack.peek();
            stack.pop();


                visited[key] = true;
                System.out.print(" --- > " + key);




            Iterator<Integer> it = adjList[key].listIterator();
            while(it.hasNext()){

                int val = it.next();

                if(!visited[val]) {
                    stack.push(val);
                }
            }
        }
    }




    public static void main(String[] args) {

        GraphsAdjRepresent graphsAdjRepresent = new GraphsAdjRepresent(6);

        graphsAdjRepresent.addEdgeMatrix(0, 1);
        graphsAdjRepresent.addEdgeMatrix(1, 2);
        graphsAdjRepresent.addEdgeMatrix(2, 3);
        graphsAdjRepresent.addEdgeMatrix(3, 4);
        graphsAdjRepresent.addEdgeMatrix(4, 5);
        graphsAdjRepresent.addEdgeMatrix(5, 0);

//        graphsAdjRepresent.printMatrices();

        graphsAdjRepresent.addEdgeLinkedList(0, 1);
        graphsAdjRepresent.addEdgeLinkedList(1, 2);
        graphsAdjRepresent.addEdgeLinkedList(2, 3);
        graphsAdjRepresent.addEdgeLinkedList(3, 4);
        graphsAdjRepresent.addEdgeLinkedList(4, 5);
        graphsAdjRepresent.addEdgeLinkedList(5, 0);

//      graphsAdjRepresent.printAdjList();

//       graphsAdjRepresent.BFS(0);

//        graphsAdjRepresent.DFSUtilRecursive(0);

        graphsAdjRepresent.DFSIterative(0);




    }
}



