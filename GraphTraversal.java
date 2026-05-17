import java.util.*;

public class GraphTraversal {

    // Recursive DFS
    public static void dfs(int v, List<Integer>[] adj, boolean[] visited) {

        visited[v] = true;
        System.out.print(v + " ");

        for (int adjNode : adj[v]) {
            if (!visited[adjNode]) {
                dfs(adjNode, adj, visited);
            }
        }
    }

    // BFS
    public static void bfs(int start, List<Integer>[] adj, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int adjNode : adj[node]) {

                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Undirected Graph
        adj[0].addAll(Arrays.asList(1, 2));

        adj[1].addAll(Arrays.asList(0, 3, 4));

        adj[2].add(0);

        adj[3].addAll(Arrays.asList(1, 4));

        adj[4].addAll(Arrays.asList(1, 3));

        // DFS
        System.out.println("DFS Traversal:");
        boolean[] visitedDFS = new boolean[n];
        dfs(0, adj, visitedDFS);

        // BFS
        System.out.println("\n\nBFS Traversal:");
        boolean[] visitedBFS = new boolean[n];
        bfs(0, adj, visitedBFS);
    }
}