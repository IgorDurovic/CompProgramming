import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by xen0phile on 7/21/15.
 */
class MCIRGAME {

    static HashMap<Integer, BigInteger> m = new HashMap<Integer, BigInteger>();
    static boolean[][] sol;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;

        while (true) {
            n = Integer.parseInt(br.readLine());
            sol = new boolean[n + 1][n + 1];
            if(n == -1){
                break;
            }

            System.out.println(solve(n));
        }

        br.close();
        System.exit(0);
    }

    public static BigInteger solve(int n){

        int temp = n * 2;

        if(m.containsKey(n)){
            return m.get(n);
        }

        if(n == 0){
            return new BigInteger("1");
        }
        if(n <= 2){
            return new BigInteger("" + n);
        }

        BigInteger total = new BigInteger("0");
        for(int j = 1; j < temp; j++) {
            for (int i = j + 1; i <= temp; i += 2) {
                total = total.add(solve((i - j - 1)/2).multiply(solve((temp - (i - j) - 1)/2)));
            }
        }

        m.put(n, total);

        return total;
    }
}
//    1
//1       1
//8       2
//7       3
//    5

//6 + 24