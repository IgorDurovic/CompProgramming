import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by xen0phile on 12/13/15.
 */
class palpath {

    public static char[][] grid;
    public static int N;
    public static ArrayList<String> holder = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for(int i = 0; i < N; i++){
            grid[i] = br.readLine().toCharArray();
        }

        solve(0, 0, grid[0][0] + "");

        System.out.println(holder.size());

    }

    public static void solve(int x, int y, String cur){

        if(x == N - 1 && y == N - 1){
            if(isPalindrome(cur) && !holder.contains(cur)){
                holder.add(cur);
            }
            else{
                return;
            }
        }

        if(x < grid.length - 1) solve(x + 1, y, cur + grid[x + 1][y]);
        if(y < grid[0].length - 1) solve(x, y + 1, cur + grid[x][y + 1]);

    }

    public static boolean isPalindrome(String s){
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length/2; i++){
            if(c[i] != c[c.length - 1 - i]){
                return false;
            }
        }

        return true;
    }

}
