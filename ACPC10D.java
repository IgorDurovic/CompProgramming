import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xen0phile on 6/26/15.
 */
class ACPC10D {

    static int[][] a;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int holder[][];
        String[] line;

        while(N != 0){

            holder = new int[N][3];

            for(int i = 0; i < N; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < 3; j++){
                    holder[i][j] = Integer.parseInt(line[j]);
                }
            }

            a = holder;

            System.out.println(count(1, 0));

            N = Integer.parseInt(br.readLine());
        }

        br.close();
        System.exit(0);
    }

    public static int count(int start, int row){

        int counter = a[row][start];

        if(row == N - 2){
            if(start < 2 && a[N - 1][0] < 0){
                counter += a[N - 1][0] + a[N - 1][1];
            }
            else{
                counter += a[N - 1][1];
            }
            return counter;
        }

        int temp;
        int temp2;

        if(a[row + 1][1] < a[row + 1][2] && a[row + 1][0] > a[row + 1][1]){
            if(start < 2 && a[row][start + 1] < 0){
                counter += count(start + 1, row);
            }
            else {
                counter += count(1, ++row);
            }
        }
        else if(start != 1){
            if(start == 0 && a[row][start + 1] < 0){
                counter += count(start + 1, row);
            }
            else {
                temp = count(start, row + 1);
                temp2 = count(1, row + 1);
                counter += (temp > temp2) ? temp2 : temp;
            }
        }
        else{
            if(a[row + 1][0] < 0){
                temp = Math.min(count(0, row + 1), count(min(a[row + 1]), row + 1));
                counter += Math.min(temp, count(start + 1, row));
            }
            else {
                counter += Math.min(count(start + 1, row), count(min(a[row + 1]), row + 1));
            }
        }

        return counter;
    }

    public static int min(int[] ar){
        int min = 0;
        for(int i = 1; i < 3; i++){
            if(ar[i] < ar[min]){
                min = i;
            }
        }
        return min;
    }

}
