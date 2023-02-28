
// 4. Simulate and implement Distance Vector Routing Algorithm. 


import java.util.Scanner;

public class DVR {

    static int INFINITY = 9999;
    static int n; // number of routers
    static int[][] cost; // cost matrix
    static int[] distance; // distance vector
    static int[] prev; // previous node in path

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of routers:");
        n = sc.nextInt();
        cost = new int[n][n];
        distance = new int[n];
        prev = new int[n];

        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0 && i != j) {
                    cost[i][j] = INFINITY;
                }
            }
        }

        // initialize distance vector and previous node in path
        for (int i = 0; i < n; i++) {
            distance[i] = cost[0][i];
            prev[i] = 0;
        }

        // calculate the distance vector
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i] > cost[i][k] + distance[k] && cost[i][k] != INFINITY) {
                        distance[i] = cost[i][k] + distance[k];
                        prev[i] = k;
                    }
                }
            }
        }

        // print the distance vector and paths
        for (int i = 0; i < n; i++) {
            System.out.print("Router " + i + ": ");
            System.out.print("Distance = " + distance[i] + ", ");
            System.out.print("Path = " + i);
            int j = i;
            while (j != 0) {
                j = prev[j];
                System.out.print(" <- " + j);
            }
            System.out.println();
        }
    }
}
