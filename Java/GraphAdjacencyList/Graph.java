import java.util.*;
import java.util.LinkedList;
public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<nodeList.size();i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j <nodeList.get(i).neighbours.size(); j++){
                if (j == nodeList.get(i).neighbours.size()-1) {
                    s.append((nodeList.get(i).neighbours.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            } 
            
            s.append("\n");
        }
        return s.toString();
    }

    // BFs internal
    public void bfsVisit(GraphNode node) {
        LinkedList <GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.println(currentNode.name + " ");
            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            } 
        }
    }
    public void bfs(){
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
            bfsVisit(node);
            }
        }
    }
    public void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.println(currentNode.name + " ");
            for(GraphNode neighbour : currentNode.neighbours) {
                if(!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }
    public void dfs() { 
        for(GraphNode node : nodeList) {
            if(!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    // Topological sort
    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }
    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbour : node.neighbours) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }
    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodeList) {
            if(!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().name + " ");
        }

    }
    public void pathPrint(GraphNode node) { 
        if (node.parent != null) {
            pathPrint(node.parent);

        }
        System.out.println(node.name+ " ");
    }
    public void BFSforSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.println("Printing path for node " + currentNode.name +": ");
            pathPrint(currentNode);
            System.out.println();
            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }
    public static void main(String[] args){
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(1, 6);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(3, 5);
        g.addUndirectedEdge(4, 5);
        g.addUndirectedEdge(5, 6);
        

        g.BFSforSSPP(nodeList.get(0));

    }
}
