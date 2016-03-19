/*
ID: id.tesl1
LANG: JAVA
TASK: comehome
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/25/15.
 */
class comehome {

    public static final int BARN = 'Z' - 65;

    public static Pasture[] farm;
    public static boolean[] visited;
    public static int[] distance;

    public static class Pasture{
        public ArrayList<Path> paths;
        public boolean barn;

        Pasture(){
            paths = new ArrayList<Path>();
            barn = false;
        }
    }

    public static class Path{
        public int length, destination;

        Path(int a, int b){
            length = a;
            destination = b;
        }

        public boolean equals(Object o){
            if(o instanceof Path){
                return this.destination == ((Path) o).destination;
            }

            return false;
        }
    }

    public static void dijkstra() {

        int visitedNodes = 0;

        while (visitedNodes < farm.length) {
            int checking = minDist(distance, visited);
            //System.out.println(checking);
            if (checking == -1) {
                break;
            }
            for (Path p : farm[checking].paths) {
                if (!visited[p.destination]) {
                    distance[p.destination] = Math.min(p.length + distance[checking], distance[p.destination]);
                }
            }
            visited[checking] = true;
            visitedNodes++;
        }

    }

    public static int minDist(int[] distance, boolean[] visited){

        int min = Integer.MAX_VALUE, index = -1;
        for(int i = 0; i < distance.length; i++){
            if(visited[i]){
                continue;
            }
            if(min > distance[i]){
                min = distance[i];
                index = i;
            }
        }

        return index;
    }

    public static int max(){

        int min = Integer.MAX_VALUE, index = -1;
        for(int i = 0; i < 26; i++){
            if(distance[i] == Integer.MAX_VALUE || i == BARN) continue;
            if(min > distance[i]){
                min = distance[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("comehome.in"));
        PrintWriter pw = new PrintWriter("comehome.out");
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        farm = new Pasture[100];
        visited = new boolean[100];
        distance = new int[100];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[BARN] = 0;

        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());

            int a = st.nextToken().charAt(0) - 65,
                    b = st.nextToken().charAt(0) - 65,
                    c = Integer.parseInt(st.nextToken());

            if(farm[a] == null){
                farm[a] = new Pasture();
            }
            if(farm[b] == null){
                farm[b] = new Pasture();
            }

            if(a == b){
                continue;
            }

            if(farm[a].paths.contains(new Path(c, b))){
                int index = farm[a].paths.indexOf(new Path(c, b));
                int temp = farm[a].paths.get(index).length;
                farm[a].paths.get(index).length = Math.min(temp, c);
                index = farm[b].paths.indexOf(new Path(c, a));
                farm[b].paths.get(index).length = Math.min(temp, c);
            }
            else if(farm[b].paths.contains(new Path(c, a))){
                int index = farm[b].paths.indexOf(new Path(c, a));
                int temp = farm[b].paths.get(index).length;
                farm[b].paths.get(index).length = Math.min(temp, c);
                index = farm[a].paths.indexOf(new Path(c, b));
                farm[a].paths.get(index).length = Math.min(temp, c);
            }
            else{
                farm[a].paths.add(new Path(c, b));
                farm[b].paths.add(new Path(c, a));
            }
        }

        dijkstra();

        /*for(int i = 0; i < distance.length; i++){
            System.out.println(((char)(i + 65)) + " " + distance[i]);
        }*/

        int sol = max() + 65;
        pw.println(((char)sol) + " " + distance[sol - 65]);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
