import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xen0phile on 6/24/15.
 */
class FASHION {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        int N;
        int[] men;
        int[] women;
        int total = 0;

        for(int i = 0; i < t; i++){
            N = scn.nextInt();
            men = new int[N];
            women = new int[N];
            for(int j = 0; j < N; j++){
                men[j] = scn.nextInt();
            }
            Arrays.sort(men);

            for(int j = 0; j < N; j++){
                women[j] = scn.nextInt();
            }
            Arrays.sort(women);

            for(int j = 0; j < N; j++){
                total += men[j] * women[j];
            }

            System.out.println(total);
            total = 0;
        }

        scn.close();
        System.exit(0);
    }
}
