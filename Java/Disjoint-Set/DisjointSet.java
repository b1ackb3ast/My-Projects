import java.util.ArrayList;
public class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public static void makeSet(ArrayList<WeightedNode> nodeList) {
        for(WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.disjointSet = set;

        }
    }
    public static DisjointSet findSet(WeightedNode node) {
        return node.disjointSet;
        
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
        if(node1.disjointSet.equals(node2.disjointSet)) {
            return null;
        } else {
            DisjointSet set1 = node1.disjointSet;
            DisjointSet set2 = node2.disjointSet;
        }
    }
}

