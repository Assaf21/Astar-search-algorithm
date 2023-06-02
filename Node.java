package javaapplication19;

public class Node {
	 String id;
	    int s;
	    int e;
	    int heuristic;

	    public Node(String id, int x, int y, int heuristic) {
	        this.id = id;
	        this.s = s;
	        this.e = e;
	        this.heuristic = heuristic;
	    }

	    public double distance(Node other) {
	        int ds = this.s - other.s;
	        int de = this.e - other.e;
	        return Math.sqrt(ds * ds + de * de);
	    }

	    @Override
	    public String toString() {
	        return this.id;
	    }
}
