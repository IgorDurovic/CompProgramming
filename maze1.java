/*
ID: id.tesl1
LANG: JAVA
TASK: maze1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/24/15.
 */
class maze1 {

    public static char[][] maze;
    public static ArrayList<ArrayList<Integer>> distance;
    public static int[] endx;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("maze1.in"));
        PrintWriter pw = new PrintWriter("maze1.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()),
                H = Integer.parseInt(st.nextToken());

        maze = new char[2 * H + 1][2 * W + 1];
        distance = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < H * W; i++){
            distance.add(new ArrayList<Integer>());
        }
        visited = new boolean[H * W];
        endx = new int[]{-1, -1};

        for(int i = 0; i < 2 * H + 1; i++){
            char[] c = br.readLine().toCharArray();
            if(c.length < 2 * W + 1){
                for(int j = 0; j < c.length; j++){
                    maze[i][j] = c[j];
                }
                maze[i][maze.length - 2] = 32;
                maze[i][maze.length - 1] = 32;
                if(endx[0] == -1){
                    endx[0] = (i/2 + 1) * ((maze[0].length - 1)/2) - 1;
                }
                else{
                    endx[1] = (i/2 + 1) * ((maze[0].length - 1)/2) - 1;
                }
            }
            else{
                maze[i] = c;
            }
        }

        pw.println(solve() + 1);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(){

        for(int i = 0; i < distance.size(); i++){
            //System.out.println(i + " " + (2 * (i / ((maze[0].length - 1)/2))) + " " + (2 * (i % ((maze[0].length - 1)/2)) + 1));
                if(maze[2 * (i / ((maze[0].length - 1)/2))][2 * (i % ((maze[0].length - 1)/2)) + 1] == ' '){
                    if(2 * (i / ((maze[0].length - 1)/2)) + 1 == 1) {
                        if (endx[0] == -1){
                            endx[0] = i;
                        }
                        else{
                            endx[1] = i;
                        }
                    }
                    else {
                        distance.get(i).add(i - (maze[0].length - 1) / 2);
                    }
                }
                if(maze[2 * (i / ((maze[0].length - 1)/2)) + 2][2 * (i % ((maze[0].length - 1)/2)) + 1] == ' '){
                    if(2 * (i / ((maze[0].length - 1)/2)) + 1 == maze.length - 2) {
                        if (endx[0] == -1){
                            endx[0] = i;
                        }
                        else{
                            endx[1] = i;
                        }
                    }
                    else {
                        distance.get(i).add(i + (maze[0].length - 1) / 2);
                    }
                }
                if(maze[2 * (i / ((maze[0].length - 1)/2)) + 1][2 * (i % ((maze[0].length - 1)/2))] == ' ') {
                    if (2 * (i % ((maze[0].length - 1) / 2)) + 1 == 1) {
                        if (endx[0] == -1) {
                            endx[0] = i;
                        } else {
                            endx[1] = i;
                        }
                    } else {
                        distance.get(i).add(i - 1);
                    }
                }
                if(maze[2 * (i / ((maze[0].length - 1)/2)) + 1][2 * (i % ((maze[0].length - 1)/2)) + 2] == ' '){
                    if(2 * (i % ((maze[0].length - 1)/2)) + 1 == maze[0].length - 2) {
                        if (endx[0] == -1){
                            endx[0] = i;
                        }
                        else{
                            endx[1] = i;
                        }
                    }
                    else {
                        distance.get(i).add(i + 1);
                    }
                }
        }

        /*for(ArrayList<Integer> ai: distance){
            for(int i: ai){
                System.out.print(i + " ");
            }
            System.out.println();
        }*/

        /*for(int i = 0; i < distance.length; i++){
            for(int j = 0; j < distance.length; j++){
                if(distance[i][j] == 15){
                    System.out.print(0 + " ");
                }
                else{
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }*/

        int[] dists = new int[visited.length];
        Arrays.fill(dists, Integer.MAX_VALUE);
        int[] dist = dijkstra(endx[0]);
        for(int j = 0; j < dists.length; j++){
            dists[j] = Math.min(dist[j], dists[j]);
        }
        dist = dijkstra(endx[1]);
        for(int j = 0; j < dists.length; j++){
            dists[j] = Math.min(dist[j], dists[j]);
        }

        int res = 0;
        for (int i = 0; i < visited.length; i++) {
            res = Math.max(res, dists[i]);
        }

        return res;
    }

    public static int[] dijkstra(int source){

        int[] d = new int[visited.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[source] = 0;
        visited = new boolean[d.length];
        int visitedNodes = 0;

        while (visitedNodes < d.length) {
            int checking = minDist(d);
            for (int v : distance.get(checking)) {
                // distance(checking,v) = 1
                d[v] = Math.min(d[v], d[checking] + 1);
            }
            visited[checking] = true;
            visitedNodes++;
        }

        return d;
    }

    public static int minDist(int[] d){
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (visited[i]) continue;
            if (min > d[i]) {
                min = d[i];
                res = i;
            }
        }
        return res;
    }

    public static class step{
        public int value;
        public int cost;

        step(int a, int b){
            value = a;
            cost = b;
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof step){
                if(((step) o).value == this.value){
                    return true;
                }
            }
            return false;
        }
    }
}
