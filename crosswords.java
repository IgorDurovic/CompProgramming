import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 11/7/15.
 */
class crosswords {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/home/xen0phile/Downloads/crosswords_bronze/10.in"));
        PrintWriter pw = new PrintWriter("crosswords.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] grid = new boolean[N][M];
        boolean[][] sol = new boolean[N][M];

        for(int i = 0; i < N; i++){
            char[] row = br.readLine().toCharArray();

            for(int j = 0; j < row.length; j++){
                if(row[j] == '#'){
                    grid[i][j] = false;
                }
                else{
                    grid[i][j] = true;
                }
            }
        }

        int total = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] && isValid(i, j, grid)){
                    sol[i][j] = true;
                    total++;
                }
            }
        }

        pw.println(total);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(sol[i][j]) pw.println((i + 1) + " " + (j + 1));
            }
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static boolean isValid(int a, int b, boolean[][] grid){

        if((a == 0 || !grid[a - 1][b])
                && a + 2 < grid.length
                && grid[a + 1][b]
                && grid[a + 2][b]){
            return true;
        }

        if((b == 0 || !grid[a][b - 1])
                && b + 2 < grid[0].length
                && grid[a][b + 1]
                && grid[a][b + 2]){
            return true;
        }

        return false;
    }

}
