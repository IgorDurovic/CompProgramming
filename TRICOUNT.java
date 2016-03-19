import java.util.Scanner;

class TRICOUNT {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        long N;

        for(int i = 0; i < T; i++){
            N = s.nextLong();
            N = (long)(N * (N + 2) * (2 * N + 1) * 0.125);
            System.out.println((long)(N * (N + 2) * (2 * N + 1) * 0.125));
        }
    }
}
