import java.util.Scanner;

class SAMER08F {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int total;

        while(N != 0){
            if(N == 1){
                System.out.println(1);
            }
            else {
                total = N * N + 1;
                for (int i = N - 1; i > 1; i--) {
                    total += (N - i + 1) * (N - i + 1);
                }
                System.out.println(total);
            }
            N = scn.nextInt();
        }

        scn.close();
        System.exit(0);
    }
}
