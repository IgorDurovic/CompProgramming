/*
ID: id.tesl1
LANG: JAVA
TASK: cowtour
 */

import java.io.*;
import java.util.*;

public class cowtour {

    public static final int UNASSIGNED = -2;

    public static int n;
    public static Point[] point;
    public static boolean[][] adjacent;
    public static double[][] distance;
    public static int[] area;
    public static int existingArea = 0;

    public static class Point {
        double x;
        double y;

        public double distance(Point other) {
            double dx = x - other.x;
            double dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("(%f, %f)", x, y);
        }
    }

    public static String solve(int[] xs, int[] ys, String[] map) {
        init(xs, ys, map);

        for (int from = 0; from < n; from++) {
            dijkstra(from);
        }

        double[] diameter = new double[existingArea];
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                int fromArea = area[from];
                if (fromArea == area[to]) {
                    diameter[fromArea] = Math.max(diameter[fromArea], distance[from][to]);
                }
            }
        }

        double res = Double.MAX_VALUE;
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                int fromArea = area[from];
                int toArea = area[to];
                if (fromArea != toArea) {
                    double d = point[from].distance(point[to]) + max(distance[from]) + max(distance[to]);
                    d = Math.max(diameter[fromArea], d);
                    d = Math.max(diameter[toArea], d);
                    if (res > d) {
                        res = Math.min(res, d);
                    }
                }
            }
        }

        return String.format("%.6f", res);
    }

    public static double max(double[] ds) {
        double res = 0;
        for (double d : ds) {
            if (d < Double.MAX_VALUE) {
                res = Math.max(d, res);
            }
        }
        return res;
    }

    public static void init(int[] xs, int[] ys, String[] map) {
        n = xs.length;
        adjacent = new boolean[n][n];
        point = new Point[n];
        distance = new double[n][n];
        area = new int[n];

        for (int i = 0; i < n; i++) {
            area[i] = UNASSIGNED;
        }
        for (int i = 0; i < n; i++) {
            point[i] = new Point(xs[i], ys[i]);
            for (int j = 0; j < n; j++) {
                adjacent[i][j] = (map[i].charAt(j) == '1');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacent[i][j]) {
                    distance[i][j] = point[i].distance(point[j]);
                } else {
                    distance[i][j] = Double.MAX_VALUE;
                }
            }
        }
    }

    public static void dijkstra(int source) {
        distance[source][source] = 0;
        boolean[] visited = new boolean[n];
        int visitedNodes = 0;
        if (area[source] == UNASSIGNED) {
            area[source] = existingArea++;
        }

        while (visitedNodes < n) {
            int checking = minDist(distance[source], visited);
            if (checking == -1) {
                break;
            }
            for (int v : neighbors(checking)) {
                if (!visited[v]) {
                    double d = Math.min(distance[source][v], distance[source][checking] + distance[checking][v]);
                    distance[source][v] = distance[v][source] = d;
                    if (area[v] == UNASSIGNED) {
                        area[v] = area[source];
                    }
                }
            }
            visited[checking] = true;
            visitedNodes++;
        }
    }

    public static ArrayList<Integer> neighbors(int checking) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (adjacent[checking][i]) {
                res.add(i);
            }
        }

        return res;
    }

    public static int minDist(double[] dist, boolean[] visited) {
        assert (dist.length == visited.length);
        int res = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;
            if (min > dist[i]) {
                min = dist[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String problemName = "cowtour";
        BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = f.readLine();
        }

        String res = solve(xs, ys, map);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
        out.println(res);
        out.close(); // close the output file
        System.exit(0); // don't omit this!
    }
}