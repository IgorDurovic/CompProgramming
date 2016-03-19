/*
ID: id.tesl1
LANG: JAVA
TASK: sprime
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class sprime {

    static int[] primes = {2, 3, 5, 7};
    static int N;
    static BufferedReader br;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new FileReader("sprime.in"));
        pw = new PrintWriter("sprime.out");

        N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 0; i < 4; i++){
            solve(primes[i], 2);
        }

        pw.flush();
        pw.close();
        System.exit(0);
    }

    public static void solve(int first, int cur){

        for(int i = 1; i < 10; i += 2){
            int temp = first * 10 + i;
            if(isPrime(temp)){
                if(cur == N){
                    pw.println(temp);
                }
                else{
                    solve(temp, cur + 1);
                }
            }
        }

    }

    public static boolean isPrime(int n){

        if(n % 2 == 0){
            return false;
        }

        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

}
