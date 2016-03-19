import java.util.Scanner;

/**
 * Created by xen0phile on 6/25/15.
 */
class HANGOVER {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        double c = scn.nextDouble();
        double temp = 0;
        int counter = 0;

        while(c != 0.0){
            while(temp < c){
                counter++;
                temp += 1.0/(counter + 1.0);
            }
            System.out.println(counter + " card(s)");
            c = scn.nextDouble();
            counter = 0;
            temp = 0;
        }

        scn.close();
        System.exit(0);
    }
}
