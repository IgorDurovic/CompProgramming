import java.util.Scanner;

/**
 * Created by xen0phile on 8/1/15.
 */
class EASYPROB {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int N;

        for(int i = 0; i < 7; i++){
            N = scn.nextInt();
            System.out.println(N + "=" + solve(N));
        }

        scn.close();
    }

    public static String solve(int n){

        if(n == 1){
            return "2(0)";
        }

        if(n == 0){
            return "";
        }

        int temp = n;
        int counter = 0;

        while(true){
            if(temp % 2 != 0){
                break;
            }
            else{
                counter++;
                temp /= 2;
            }
        }

        if(n == (int)Math.pow(2, counter)){
            if(counter == 1){
                return "2";
            }
            else {
                return "2(" + solve(counter) + ")";
            }
        }
        else {
            return solve(n - (int) Math.pow(2, counter)) + "+" + solve((int) Math.pow(2, counter));
        }
    }

}

//2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
//2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)