import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/22/15.
 */
class PT07Y {

    static Point[] tree;
    static boolean[] visited;
    static int counter = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        tree = new Point[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++){
            tree[i] = new Point();
        }

        int u, v;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            tree[u].neighbors.push(v);
            tree[v].neighbors.push(u);
        }

        visited[1] = true;
        boolean b = solve(tree[1], 1);
        if(b && counter == N){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static boolean solve(Point p, int i){

        counter++;
        if(p.neighbors.isEmpty()){
            return true;
        }

        Point temp;
        int t;

        int size = p.neighbors.size();

        for(int j = 0; j < size; j++){

            t = p.neighbors.pop();

            if(visited[t]){
                return false;
            }

            visited[t] = true;
            temp = tree[t];
            temp.neighbors.remove(new Integer(i));

            if(!solve(temp, t)){
                return false;
            }
        }

        return true;
    }

    public static class Point{
        public LinkedList<Integer> neighbors;

        Point(){
            neighbors = new LinkedList<Integer>();
        }
    }
}
