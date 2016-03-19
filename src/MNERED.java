import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/30/15.
 */
class MNERED {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x, y, N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][N + 1];
        int[][] c = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            grid[x][y] = 1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                c[i][j] = grid[i][j] + c[i][j - 1] + c[i - 1][j] - c[i - 1][j - 1];
            }
        }

        int max = 0;
        int total;
        for(int i = 1; i <= M && i <= N; i++){
            if(M % i == 0){
                x = i;
                y = M / x;
                for(int a = x; a <= N; a++){
                    for(int b = y; b <= N; b++){
                        total = c[a][b] + c[a - x][b - y] - c[a - x][b] - c[a][b - y];
                        if(total > max){
                            max = total;
                        }
                    }
                }
            }
        }

        pw.println(M - max);

        pw.flush();
        pw.close();
        br.close();
    }
}
