import java.util.Scanner;

class FCTRL {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int lines = scn.nextInt();
        for(int i = 0; i < lines; i++){
            System.out.println(countZeros(scn.nextInt()));
        }

        scn.close();
        System.exit(0);
    }

    public static int countZeros(int num){
        int counter = 0;
        for(int i = 5; i <= num; i *= 5) {
            counter += num / i;
        }
        return counter;
    }

}
