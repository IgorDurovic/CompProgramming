import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/12/15.
 */
class moocrypt {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken()), max = 0;
        char[][] crypt = new char[rows][col];

        for(int i = 0; i < rows; i++){
            crypt[i] = br.readLine().toCharArray();
        }

        for(char i = 'A'; i <= 'Z'; i++){
            for(char j = 'A'; j <= 'Z'; j++){
                if(i == j) continue;
                int count = 0;
                for(int a = 0; a < rows; a++){
                    for(int b = 0; b < col; b++){
                        if(crypt[a][b] == i){
                            if(a >= 2){
                                if(crypt[a - 1][b] == j &&
                                        crypt[a - 2][b] == j){
                                    count++;
                                }
                            }
                            if(b >= 2){
                                if(crypt[a][b - 1] == j &&
                                        crypt[a][b - 2] == j){
                                    count++;
                                }
                            }
                            if(b >= 2 && a >= 2){
                                if(crypt[a - 1][b - 1] == j &&
                                        crypt[a - 2][b - 2] == j){
                                    count++;
                                }
                            }
                            if(a < rows - 2){
                                if(crypt[a + 1][b] == j &&
                                        crypt[a + 2][b] == j){
                                    count++;
                                }
                            }
                            if(b < col - 2){
                                if(crypt[a][b + 1] == j &&
                                        crypt[a][b + 2] == j){
                                    count++;
                                }
                            }
                            if(a < rows - 2 && b < col - 2){
                                if(crypt[a + 1][b + 1] == j &&
                                        crypt[a + 2][b + 2] == j){
                                    count++;
                                }
                            }
                            if(a >= 2 && b < col - 2){
                                if(crypt[a - 1][b + 1] == j &&
                                        crypt[a - 2][b + 2] == j){
                                    count++;
                                }
                            }
                            if(b >= 2 && a < rows - 2){
                                if(crypt[a + 1][b - 1] == j &&
                                        crypt[a + 2][b - 2] == j){
                                    count++;
                                }
                            }
                        }
                    }
                }
                if(count > max){
                    max = count;
                }
            }
        }

        System.out.println(max);
    }
}
