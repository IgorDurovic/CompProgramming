/*
ID: id.tesl1
LANG: JAVA
TASK: numtri
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class numtri {

    public static int[][] tri;
    public static int[][] t;
    public static boolean[][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter("numtri.out");
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tri = new int[N][N];
        visit = new boolean[N][N];
        t = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pw.println(solve(0, 0, 0));

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(int x, int y, int total){

        if(visit[x][y]){
            return t[x][y];
        }

        visit[x][y] = true;

        total += tri[x][y];

        if(x == tri.length - 1){
            t[x][y] = tri[x][y];
            return tri[x][y];
        }

        t[x][y] = Math.max(solve(x + 1, y, total), solve(x + 1, y + 1, total)) + tri[x][y];

        return t[x][y];
    }

}
