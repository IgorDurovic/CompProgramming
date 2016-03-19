import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/14/15.
 */
public class lightson {

    public static Room[][] grid;
    public static int total;
    public static ArrayList<Switch> visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter("lightson.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());
        grid = new Room[N + 1][N + 1];
        visit = new ArrayList<Switch>();

        total = 1;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                grid[i][j] = new Room();
            }
        }

        grid[1][1].on = true;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()),
                    y = Integer.parseInt(st.nextToken()),
                    a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken());

            grid[x][y].lights.add(new Switch(a, b));
        }

        solve(1, 1);

        /*for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(grid[i][j].on){
                    System.out.println(i + " " + j + " here");
                }
            }
        }*/

        pw.println(total);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(int x, int y){

        grid[x][y].visited = true;
        visit.add(new Switch(x, y));

        for(Switch s: grid[x][y].lights){
            if(!grid[s.x][s.y].on) {
                grid[s.x][s.y].on = true;
                total++;
            }
        }

        for(int i = x - 1; i <= x + 1; i++){
            if(i >= 1 && i < grid.length){
                if(grid[i][y].on && !grid[i][y].visited){
                    //System.out.println(i + " " + y);
                    solve(i, y);
                }
            }
        }
        for(int j = y - 1; j <= y + 1; j++){
            if(j >= 1 && j < grid[0].length){
                if(grid[x][j].on && !grid[x][j].visited){
                    //System.out.println(x + " " + j);
                    solve(x, j);
                }
            }
        }

        for(int ii = 0; ii < visit.size(); ii++){
            Switch s = visit.get(ii);
            for(int i = s.x - 1; i <= s.x + 1; i++){
                if(i >= 1 && i < grid.length){
                    if(grid[i][s.y].on && !grid[i][s.y].visited){
                        solve(i, s.y);
                    }
                }
            }
            for(int j = s.y - 1; j <= s.y + 1; j++){
                if(j >= 1 && j < grid[0].length){
                    if(grid[s.x][j].on && !grid[s.x][j].visited){
                        solve(s.x, j);
                    }
                }
            }
        }

    }

    public static class Room{
        public boolean on;
        public boolean visited;
        public ArrayList<Switch> lights;

        Room(){
            on = false;
            visited = false;
            lights = new ArrayList<Switch>();
        }
    }

    public static class Switch{
        public int x;
        public int y;

        Switch(int a, int b){
            x = a;
            y = b;
        }
    }
}
