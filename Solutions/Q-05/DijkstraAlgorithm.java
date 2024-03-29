// By - Kaustav Purkayastha ( Gurucharan University, Silchar - @ Department of Computer Science )

// 5. Simulate and implement Dijkstra Algorithm for Shortest Path Routing.


public class DijkstraAlgorithm {

    public void dijkstra(int[][] graph, int source) {
      int count = graph.length;
      boolean[] visitedVertex = new boolean[count];
      int[] distance = new int[count];
      for (int i = 0; i < count; i++) {
        visitedVertex[i] = false;
        distance[i] = Integer.MAX_VALUE;
      }
  
      // Distance of self loop is zero
      distance[source] = 0;
      for (int i = 0; i < count; i++) {
  
        // Update the distance between neighbouring vertex and source vertex
        int u = findMinDistance(distance, visitedVertex);
        visitedVertex[u] = true;
  
        // Update all the neighbouring vertex distances
        for (int v = 0; v < count; v++) {
          if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
            distance[v] = distance[u] + graph[u][v];
          }
        }
      }
      for (int i = 0; i < distance.length; i++) {
        System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
      }
  
    }
  
    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
      int minDistance = Integer.MAX_VALUE;
      int minDistanceVertex = -1;
      for (int i = 0; i < distance.length; i++) {
        if (!visitedVertex[i] && distance[i] < minDistance) {
          minDistance = distance[i];
          minDistanceVertex = i;
        }
      }
      return minDistanceVertex;
    }
  
    public static void main(String[] args) {
      int graph[][] = new int[][] { 
        {0, 2, 0, 6, 0},
        {2, 0, 3, 8, 5},
        {0, 3, 0, 0, 7},
        {6, 8, 0, 0, 9},
        {0, 5, 7, 9, 0} 
        };
      
        DijkstraAlgorithm T = new DijkstraAlgorithm();
    
        T.dijkstra(graph, 0);
    }
 }



/*
EXPLANATION: (Pseudo Code)
 function dijkstra(G, S)
    for each vertex V in G
        distance[V] <- infinite
        previous[V] <- NULL
        If V != S, add V to Priority Queue Q
    distance[S] <- 0
	
    while Q IS NOT EMPTY
        U <- Extract MIN from Q
        for each unvisited neighbour V of U
            tempDistance <- distance[U] + edge_weight(U, V)
            if tempDistance < distance[V]
                distance[V] <- tempDistance
                previous[V] <- U
    return distance[], previous[]
 */
