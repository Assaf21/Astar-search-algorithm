package javaapplication19;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Node AlAziziyah = new Node("Al-Aziziyah", 0, 0, 5);
        Node AlHindawiyyah = new Node("Al-Hindawiyyah", 3, 2, 3);
        Node AlShisha = new Node("Al-Shisha", 1, 2, 2);
        Node AlGhassalah = new Node("Al-Ghassalah", 6, 4, 0);
        Node AlMansour = new Node("Al-Mansour", 8, 2, 2);
        Node AlKhalidiyyah = new Node("Al-Khalidiyyah", 9, 5, 3);
        Node AlRusaifah = new Node("Al-Rusaifah", 5, 7, 2);
        Node AlSharae = new Node("Al-Sharae", 7, 8, 2);
        Node AlShemal = new Node("Al-Shemal", 4, 9, 1);
        Node AlNuzha = new Node("Al-Nuzha", 2, 5, 1);

        Astar aStar = new Astar();
        aStar.addEdge(AlAziziyah, AlHindawiyyah);
        aStar.addEdge(AlAziziyah, AlShisha);
        aStar.addEdge(AlAziziyah, AlNuzha);
        aStar.addEdge(AlHindawiyyah, AlMansour);
        aStar.addEdge(AlHindawiyyah, AlSharae);
        aStar.addEdge(AlShisha, AlGhassalah);
        aStar.addEdge(AlShisha, AlRusaifah);
        aStar.addEdge(AlGhassalah, AlMansour);
        aStar.addEdge(AlMansour, AlKhalidiyyah);
        aStar.addEdge(AlKhalidiyyah, AlSharae);
        aStar.addEdge(AlSharae, AlShemal);
        aStar.addEdge(AlShemal, AlNuzha);
        aStar.addEdge(AlRusaifah, AlShemal);

        List<Node> path = aStar.findPath(AlAziziyah, AlShemal);
        if (path != null) {
            System.out.println("can  reach from : " + path);
        } else {
            System.out.println("can not reach");
        }
    }
}
