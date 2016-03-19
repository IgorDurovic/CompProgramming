import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/31/15.
 */
class PT07Z {

    static Node[] nodes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()), u, v;
        nodes = new Node[N + 1];

        for(int i = 0; i <= N; i++){
            nodes[i] = new Node();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            nodes[u].addNeighbor(v);
            nodes[u].value++;
            nodes[v].addNeighbor(u);
            nodes[v].value++;
        }

        int max = 0, temp;
        int counter = 1;
        while(counter <= N){
            if(nodes[counter].value == 1) {
                temp = traverse(nodes[counter], counter, -1);
                if (temp > max) {
                    max = temp;
                }
            }
            counter++;
        }

        pw.println(max);

        pw.flush();
        pw.close();
        br.close();
    }

    public static int traverse(Node n, int in, int na){

        if(na != -1 && n.neighbor.size() == 1){
            return 0;
        }

        int temp, max = 0;

        for(int i = 0; i < n.neighbor.size(); i++){
            temp = n.neighbor.get(i);
            if(temp != na){
                temp = traverse(nodes[temp], temp, in);
                if(temp > max){
                    max = temp;
                }
            }
        }

        return ++max;
    }

    public static class Node implements Comparable<Node>{
        public ArrayList<Integer> neighbor;
        public int value;

        Node(){
            value = 0;
            neighbor = new ArrayList<Integer>();
        }

        public void addNeighbor(int n){
            neighbor.add(n);
        }

        public int compareTo(Node n){
            return this.value - n.value;
        }
    }

}
