import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 2/22/16.
 */
public class fencedin {

    public static int A, B, n, m;
    public static int[] N, M;
    public static boolean[][] intree;
    public static Dim[][] tree;

    public static class Pair implements Comparable<Pair>{
        public int x, y, value;

        Pair(int a, int b, int c){
            x = a;
            y = b;
            value = c;
        }

        public int compareTo(Pair p){
            return this.value - p.value;
        }
    }

    public static class Dim{
        public int width, length;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("fencedin.in"));
        PrintWriter pw = new PrintWriter("fencedin.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        N = new int[n + 1];
        M = new int[m + 1];

        intree = new boolean[(n + 1)][(m + 1)];
        tree = new Dim[(n + 1)][(m + 1)];

        for(int i = 0; i < n; i++){
            N[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < m; i++){
            M[i] = Integer.parseInt(br.readLine());
        }

        N[n] = A;
        M[m] = B;

        Arrays.sort(N);
        Arrays.sort(M);

        for(int i = 0; i < n + 1; i++){
            tree[i][0] = new Dim();
            tree[i][0].length = M[0];
        }

        for(int i = 0; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++) {
                tree[i][j] = new Dim();
                tree[i][j].length = M[j] - M[j - 1];
            }
        }

        for(int i = 0; i < m + 1; i++){
            tree[0][i].width = N[0];
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                tree[i][j].width = N[i] - N[i - 1];
            }
        }

        /*for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                System.out.print(tree[j][i].width + "-" + tree[j][i].length + " ");
            }
            System.out.println();
        }*/

        pw.println(prim());

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int prim(){

        intree[0][0] = true;
        int treeCost = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(1, 0, tree[0][0].length));
        pq.add(new Pair(0, 1, tree[0][0].width));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int ix = p.x, iy = p.y, cost = p.value;
            if(intree[ix][iy]) continue;
            //System.out.println(ix + " " + iy);
            intree[ix][iy] = true;
            treeCost += cost;

            if(ix > 0 && !intree[ix - 1][iy]) pq.add(new Pair(ix - 1, iy, tree[ix][iy].length));
            if(iy > 0 && !intree[ix][iy - 1]) pq.add(new Pair(ix, iy - 1, tree[ix][iy].width));
            if(ix < tree.length - 1 && !intree[ix + 1][iy]) pq.add(new Pair(ix + 1, iy, tree[ix][iy].length));
            if(iy < tree[0].length - 1 && !intree[ix][iy + 1]) pq.add(new Pair(ix, iy + 1, tree[ix][iy].width));
        }

        return treeCost;
    }

}
