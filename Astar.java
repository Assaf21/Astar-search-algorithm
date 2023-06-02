package javaapplication19;
import java.util.*;
public class Astar {
	private Map<Node, List<Node>> adjacencyList;
    private Set<Node> exploredNodes;
    private PriorityQueue<Node> frontier;
    private Map<Node, Node> cameFrom;
    private Map<Node, Double> costSoFar;

    public Astar() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(Node from, Node to) {
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.get(from).add(to);
    }

    public List<Node> findPath(Node start, Node destination
) {
        Comparator<Node> comparator = (a, b) -> (int) ((a.heuristic + costSoFar.getOrDefault(a, Double.MAX_VALUE))
                - (b.heuristic + costSoFar.getOrDefault(b, Double.MAX_VALUE)));

        exploredNodes = new HashSet<>();
        frontier = new PriorityQueue<>(comparator);
        cameFrom = new HashMap<>();
        costSoFar = new HashMap<>();

        frontier.add(start);
        costSoFar.put(start, 0.0);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.equals(destination
)) {
                return reconstructPath(cameFrom, start, destination
);
            }

            exploredNodes.add(current);

            for (Node neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                double newCost = costSoFar.get(current) + current.distance(neighbor);
                if (!costSoFar.containsKey(neighbor) || newCost < costSoFar.get(neighbor)) {
                    costSoFar.put(neighbor, newCost);
                    cameFrom.put(neighbor, current);
                    if (!exploredNodes.contains(neighbor)) {
                        frontier.add(neighbor);
                    }
                }
            }
        }
        return null; // can not reach
    }

    private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node start, Node destination
) {
        List<Node> path = new ArrayList<>();
        Node current = destination
;
        while (!current.equals(start)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
