import java.util.*;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class DijkstraAlgorithm {

    public static void dijkstra(int V, List<List<Pair>> adj, int source) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int dis = current.distance;

            for (Pair neighbor : adj.get(node)) {

                int adjNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        System.out.println("Shortest distances from source:");

        for (int i = 0; i < V; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected weighted graph
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        adj.get(0).add(new Pair(2, 4));
        adj.get(2).add(new Pair(0, 4));

        adj.get(1).add(new Pair(2, 1));
        adj.get(2).add(new Pair(1, 1));

        adj.get(1).add(new Pair(3, 7));
        adj.get(3).add(new Pair(1, 7));

        adj.get(2).add(new Pair(4, 3));
        adj.get(4).add(new Pair(2, 3));

        dijkstra(V, adj, 0);
    }
}