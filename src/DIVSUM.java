import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 6/14/15.
 */
class DIVSUM {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int lines = Integer.parseInt(scn.nextLine());

        for(int i = 0; i < lines; i++){
            int num = Integer.parseInt(scn.nextLine());
            System.out.println(divSum(num));
        }

        scn.close();
        System.exit(0);
    }

    public static int divSum(int num){
        if(num == 1){
            return 0;
        }
        int sum = 1;
        int i;
        for(i = 2; i < Math.sqrt(num); i++){
            if(num%i == 0){
                sum += i;
                sum += num/i;
            }
        }
        if(i == Math.sqrt(num)){
            sum += i;
        }

        return sum;
    }

}
