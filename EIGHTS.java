import java.util.Scanner;

/**
 * Created by xen0phile on 6/25/15.
 */
class EIGHTS {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        long k;
        int[] holder = {192, 442, 692, 942};
        int temp;

        for(int i = 0; i < t; i++){
            k = scn.nextLong();
            temp = holder[(int)((k-1)%4)];
            System.out.println((k-1)/4 * 1000 + temp);
        }

        scn.close();
        System.exit(0);
    }
}
