import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 2/20/16.
 */
public class gold3 {

    public static int N, M;
    public static int[][][] visited;
    public static int[][] tiles;
    public static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static PriorityQueue<State> pq = new PriorityQueue<>();

    public static class State implements Comparable<State>{
        public int x, y, dist, orange;

        State(int a, int b, int c, int d){
            x = a;
            y = b;
            dist = c;
            orange = d;
        }

        public int compareTo(State o){
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dream.in"));
        PrintWriter pw = new PrintWriter("dream.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N][M][2];
        tiles = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                tiles[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j][0] = visited[i][j][1] = Integer.MAX_VALUE;
            }
        }

        pq.add(new State(0, 0, 0, 0));

        while(!pq.isEmpty()){
            State s = pq.remove();

            if(s.x == N - 1 && s.y == M - 1){
                pw.println(s.dist);
                pw.flush();
                pw.close();
                br.close();
                return;
            }
            if(visited[s.x][s.y][s.orange] != Integer.MAX_VALUE) continue;
            visited[s.x][s.y][s.orange] = s.dist;

            for(int i = 0; i < 4; i++){
                int steps = 1, nx = s.x + dir[i][0], ny = s.y + dir[i][1], o = s.orange;

                if(!isValid(nx, ny, s.orange)) continue;

                while(tiles[nx][ny] == 4){
                    o = 0;
                    nx += dir[i][0];
                    ny += dir[i][1];
                    if(isValid(nx, ny, o)){
                        steps++;
                    }
                    else{
                        nx -= dir[i][0];
                        ny -= dir[i][1];
                        break;
                    }
                }

                if(tiles[nx][ny] == 2) o = 1;

                if(steps + visited[s.x][s.y][s.orange] <= visited[nx][ny][o]){
                    pq.add(new State(nx, ny, steps + visited[s.x][s.y][s.orange], o));
                }
            }
        }

        pw.println(-1);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static boolean isValid(int x, int y, int orange){
        if(x < 0 || x >= N || y < 0 || y >= M || tiles[x][y] == 0) return false;
        if(tiles[x][y] == 3 && orange == 0) return false;
        return true;
    }
}
