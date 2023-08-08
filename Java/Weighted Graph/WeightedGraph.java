import java.util.*;
public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    // Constructor
    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    // dijkstra's algorithm
    public void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbour : currentNode.neighbours) {
                // if the neighbour is not visited
                if (queue.contains(neighbour)) {
                    if(neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = (currentNode.distance + currentNode.weightMap.get(neighbour));
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }

        }
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node "+ nodeToCheck+", distance:"+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
    public void pathPrint(WeightedNode node) {
        if(node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.println(node.name + " ");
    }

    public void addWeightedEdge(int i, int j , int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbours.add(second);
        first.weightMap.put(second, d);
    }
    
    // Bellman Ford algorithm
    public void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i<nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbour : currentNode.neighbours) {
                    if(neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = (currentNode.distance + currentNode.weightMap.get(neighbour));
                        neighbour.parent = currentNode;

                    }
                }
            }
        }
        System.out.println("Checking for negative cycle...");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbour : currentNode.neighbours) {
                if(neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name:" + neighbour.name);
                    System.out.println("Old cost:" + neighbour.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbour);
                    System.out.println("New distance:" + newDistance);
                    return;
                }
            }
        }
        System.out.println("negative cycle not found");

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node "+ nodeToCheck+", distance:"+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
    // Floyd Warshall algorithm
    public void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];
        // updating the matrix to current edge, 0 and infinity
        for(int i = 0; i<size; i++) {
            WeightedNode first = nodeList.get(i);
            for(int j=0;j<size;j++) {
                WeightedNode second = nodeList.get(j);
                if(i==j) {
                    V[i][j] = 0;
                } else if(first.weightMap.containsKey(second)) {
                    V[i][j] = first.weightMap.get(second);

                } else {
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }
        // k is the via node, i and j are the coloumn and rows vertices 
        for(int k = 0; k<nodeList.size(); k++) {
            for(int i = 0; i<nodeList.size(); i++) {
                for(int j = 0; j<nodeList.size(); j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }
        for (int i = 0; i< size; i++) {
            System.out.println("Printing distance list for node "+nodeList.get(i) + ":");
            for (int j = 0;j<size; j++) {
                System.out.println(V[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A" , 0 ));
        nodeList.add(new WeightedNode("B" , 1 ));
        nodeList.add(new WeightedNode("C" , 2 ));
        nodeList.add(new WeightedNode("D" , 3 ));
        WeightedGraph newGraph = new WeightedGraph(nodeList);
        newGraph.addWeightedEdge(0, 3, 1);
        newGraph.addWeightedEdge(0, 1, 8);
        newGraph.addWeightedEdge(1, 2, 1);
        newGraph.addWeightedEdge(2, 0, 4);
        newGraph.addWeightedEdge(3, 1, 2);
        newGraph.addWeightedEdge(3, 2, 9);
        System.out.println("Printing floyd warshall algorithm from source A");
        newGraph.floydWarshall();
                
        
        
        

                


    }
}